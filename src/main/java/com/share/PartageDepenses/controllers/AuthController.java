package com.share.PartageDepenses.controllers;

	import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.share.PartageDepenses.dao.RoleRepository;
import com.share.PartageDepenses.dao.UserRepository;
import com.share.PartageDepenses.entities.ERole;
import com.share.PartageDepenses.entities.Role;
import com.share.PartageDepenses.entities.User;
import com.share.PartageDepenses.payload.request.LoginRequest;
import com.share.PartageDepenses.payload.request.SignUpRequest;
import com.share.PartageDepenses.payload.response.JwtResponse;
import com.share.PartageDepenses.payload.response.MessageResponse;
import com.share.PartageDepenses.security.jwt.JwtUtils;
import com.share.PartageDepenses.security.services.UserDetailsImpl;

	@CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {
		@Autowired
		AuthenticationManager authenticationManager;

		@Autowired
		UserRepository userRepository;

		@Autowired
		RoleRepository roleRepository;

		@Autowired
		PasswordEncoder encoder;

		@Autowired
		JwtUtils jwtUtils;

		@PostMapping("/signin")
		public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);
			
			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
			List<String> roles = userDetails.getAuthorities().stream()
					.map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, 
													 userDetails.getIdUser(), 
													 userDetails.getUsername(), 
													 userDetails.getPseudo(), 
													 roles));
		}

		@PostMapping("/signup")
		public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Ce nom d'utilisateur est déja pris"));
			}

			if (userRepository.existsByPseudo(signUpRequest.getPseudo())) {
				return ResponseEntity
						.badRequest()
						.body(new MessageResponse("Pseudo déja pris"));
			}

			// Create new user's account
			User user = new User(signUpRequest.getUsername(), 
								 signUpRequest.getPseudo(),
								 encoder.encode(signUpRequest.getPassword()));

			Set<String> strRoles = signUpRequest.getRole();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Ceci n'est pas un rôle valide"));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Ceci n'est pas un rôle valide"));
						roles.add(adminRole);

						break;
					case "mod":
						Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
								.orElseThrow(() -> new RuntimeException("Ceci n'est pas un rôle valide"));
						roles.add(modRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Ceci n'est pas un rôle valide"));
						roles.add(userRole);
					}
				});
			}

			user.setRoles(roles);
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("Votre compte a bie été crée!"));
		}
}

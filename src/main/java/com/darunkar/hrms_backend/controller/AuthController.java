package com.darunkar.hrms_backend.controller;

import com.darunkar.hrms_backend.dto.AuthRequest;
import com.darunkar.hrms_backend.dto.AuthResponse;
import com.darunkar.hrms_backend.entity.User;
import com.darunkar.hrms_backend.repository.UserRepository;
import com.darunkar.hrms_backend.service.CustomUserDetailsService;
import com.darunkar.hrms_backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = jwtUtil.generateToken(userDetails);

		User user = userRepository.findByEmail(request.getEmail()).orElseThrow();

		return ResponseEntity.ok(new AuthResponse(token, user.getEmail(), user.getRole()));
	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("User registered");
	}
}

package com.project.Fitness.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Fitness.DTO.LoginRequest;
import com.project.Fitness.DTO.RegisterRequest;
import com.project.Fitness.DTO.UserResponse;
import com.project.Fitness.Service.JwtService;
import com.project.Fitness.Service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	
	private final UserService userService;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;


	
	

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
		
		return ResponseEntity.ok(userService.register(registerRequest));
		
	}

	@PostMapping("/login")
	public String generateToken(@RequestBody LoginRequest loginReq){
		Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginReq.getUserName(), loginReq.getPassword()));

		if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginReq.getUserName(),authentication.getAuthorities());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
	}
	
	

}

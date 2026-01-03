package com.project.Fitness.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Fitness.DTO.RegisterRequest;
import com.project.Fitness.DTO.UserResponse;
import com.project.Fitness.Service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
	
	
	private final UserService userService;

	
	

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest) {
		
		return ResponseEntity.ok(userService.register(registerRequest));
		
	}
	
	

}

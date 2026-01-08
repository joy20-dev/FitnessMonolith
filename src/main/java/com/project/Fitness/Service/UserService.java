package com.project.Fitness.Service;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Fitness.DTO.RegisterRequest;
import com.project.Fitness.DTO.UserResponse;
import com.project.Fitness.Models.Users;
import com.project.Fitness.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service

public class UserService {
	
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;


	

	public UserResponse register(RegisterRequest registerReq) {
		// TODO Auto-generated method stub
		
		Users user = Users.builder()
		
					.email(registerReq.getEmail())
					.password(encoder.encode(registerReq.getPassword()))
					.firstName(registerReq.getFirstName())
					.lastName(registerReq.getLastName())
					.role(registerReq.getRole())
					.build();
		
		
					
//		Users user = new Users(
//				null,
//				registerReq.getEmail(),
//				registerReq.getPassword(),
//				registerReq.getFirstName(),
//				registerReq.getLastName(),
//				Instant.parse("2025-12-31T12:37:12.708Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//				Instant.parse("2025-12-31T12:37:12.708Z").atZone(ZoneOffset.UTC).toLocalDateTime(),
//				List.of(),
//				List.of()) ;
		
		userRepository.save(user);
		return mappedToResponse(user);
		
	}

	private UserResponse mappedToResponse(Users user) {
		// TODO Auto-generated method stub
		UserResponse response = new UserResponse(
				user.getId(),
				user.getEmail(),
				user.getFirstName(),
				user.getLastName(),
				user.getPassword(),
				user.getRole(),
				user.getCreatedAt(),
				user.getUpdatedAt());
		return response;
		
	}

}

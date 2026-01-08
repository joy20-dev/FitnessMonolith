package com.project.Fitness.DTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
	
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}

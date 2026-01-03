package com.project.Fitness.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
	
	private String email;
	private String firstName;
	private String lastName;
	private String password;

}

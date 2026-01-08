package com.project.Fitness.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Users {
	
	@Id
	@GeneratedValue(strategy =GenerationType.UUID)
	private  String id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String role;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime  updatedAt;
	
	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Activity> activities = new ArrayList<>();
	
	@OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<Recommendation> recommendations = new ArrayList<>();
	
	

}

package com.project.Fitness.DTO;

import java.time.LocalDateTime;

import com.project.Fitness.Models.ActivityType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityResponse {
	private Integer caloriesBurned;
	private LocalDateTime startTime;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	private ActivityType type;

}

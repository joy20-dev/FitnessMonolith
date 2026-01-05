package com.project.Fitness.DTO;

import java.time.LocalDateTime;
import java.util.Map;

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
	private String id;
	private String userId;
	private Integer caloriesBurned;
	private Integer duration;
	private LocalDateTime startTime;
	private LocalDateTime createdAt;
	private LocalDateTime updateAt;
	private ActivityType type;
	private Map<String,Object> additionalMetrics;

}

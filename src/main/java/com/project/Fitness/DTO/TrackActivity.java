package com.project.Fitness.DTO;

import java.time.LocalDateTime;

import com.project.Fitness.Models.ActivityType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackActivity {
	private String userId;
	private Integer duration;
	private Integer caloriesBurned;
	private Map<String,Object> additionalMetrics;
	private LocalDateTime startTime;
	private ActivityType type;
//	private String id; created for testing api 

}

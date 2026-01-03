package com.project.Fitness.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Fitness.DTO.ActivityResponse;
import com.project.Fitness.DTO.TrackActivity;
import com.project.Fitness.Service.ActivityService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/activities")
public class ActivityController {
	
	private final ActivityService activityService;
	
	@GetMapping("/fetch")
	public ResponseEntity<List<ActivityResponse>> fetchActivities(){
		return ResponseEntity.ok(activityService.fetchActivities());
	}
	
	@PostMapping("/track")
	public ResponseEntity<ActivityResponse> trackActivity(@RequestBody TrackActivity activity) {
		return ResponseEntity.ok(activityService.track(activity));
		
	}

}

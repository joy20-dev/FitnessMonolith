package com.project.Fitness.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Fitness.DTO.ActivityResponse;
import com.project.Fitness.DTO.TrackActivity;
import com.project.Fitness.Models.*;
import com.project.Fitness.Repository.ActivityRepository;
import com.project.Fitness.Repository.UserRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class ActivityService {
	
	private final ActivityRepository activityRepo;
	private final UserRepository userRepo;

	public ActivityResponse track(TrackActivity trackActivity) {
		// TODO Auto-generated method stub
		Users user = userRepo.findById(trackActivity.getId()).orElseThrow(() -> new RunTimeException("user not found"));  //created for testing the api
		Activity act = Activity.builder()
				.duration(trackActivity.getDuration())
				.caloriesBurned(trackActivity.getCaloriesBurned())
				.startTime(trackActivity.getStartTime())
				.type(trackActivity.getType())
				.user(user)  // need to get logged in user from security context after adding spring security
				.build();
		 Activity savedAct = activityRepo.save(act);
		 return mappedToResponse(savedAct);
	}

	private ActivityResponse mappedToResponse(Activity activity) {
		// TODO Auto-generated method stub
		ActivityResponse response = ActivityResponse.builder()
				.duration(activity.getDuration())
				.caloriesBurned(activity.getCaloriesBurned())
				.startTime(activity.getStartTime())
				.createdAt(activity.getCreatedAt())
				.updateAt(activity.getUpdatedAt())
				.type(activity.getType())
				.build();
		return response;
	}

	public List<ActivityResponse> fetchActivities() {
		// TODO Auto-generated method stub
		return activityRepo.findAll().stream().map(this::mappedToResponse).toList();
	}

}

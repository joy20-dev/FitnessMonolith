package com.project.Fitness.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Fitness.DTO.ActivityResponse;
import com.project.Fitness.DTO.TrackActivity;
import com.project.Fitness.Models.Recommendation;
import com.project.Fitness.Service.ActivityService;

import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/user")
    public ResponseEntity<List<RecommendationResponse>> getRecommendations(@PathVariable String userId) {
        return ResponseEntity.ok(recommendationService.getRecommendationsByUser(userId));
    }

    @GetMapping("/activity")
    public ResponseEntity<List<RecommendationResponse>> getRecommendationsByActivity(@PathVariable String activityId){
        return ResponseEntity.ok(recommendationService.getRecommendationsByActivity(activityId));
    }

    @PostMapping("/generate")
    public ResponseEntity<RecommendationResponse> generateRecommendation(@RequestBody RecommendationRequest request) {
        return ResponseEntity.ok(recommendationService.generateRecommendation(request));
    }
}
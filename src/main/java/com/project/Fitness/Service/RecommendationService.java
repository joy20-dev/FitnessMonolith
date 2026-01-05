package com.project.Fitness.Service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.Fitness.DTO.RecommendationRequest;
import com.project.Fitness.DTO.RecommendationResponse;
import com.project.Fitness.Models.Recommendation;
import com.project.Fitness.Models.*;
import com.project.Fitness.Repository.ActivityRepository;
import com.project.Fitness.Repository.RecommendationRepository;
import com.project.Fitness.Repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;
    private final UserRepository userRepo;
    private final ActivityRepository activityRepo;

    private RecommendationResponse mappedToResponse(Recommendation recommendation){
        RecommendationResponse response = RecommendationResponse.builder()
                                            .userId(recommendation.getUser().getId())
                                            .id(recommendation.getId())
                                            .activityId(recommendation.getActivity().getId())
                                            .type(recommendation.getType())
                                            .recommendation(recommendation.getRecommendation())
                                            .improvements(recommendation.getImprovements())
                                            .suggestions(recommendation.getSuggestions())
                                            .safety(recommendation.getSafety())
                                            .createdAt(recommendation.getCreatedAt())
                                            .updatedAt(recommendation.getUpdatedAt())

                                            .build();
                                        
        return response;
    }

    public List<RecommendationResponse> getRecommendationsByUser(String userId){
        // Implementation to fetch recommendations by userId
        return recommendationRepository.findByUserId(userId).stream().map(this::mappedToResponse).toList();


    }

    public List<RecommendationResponse> getRecommendationsByActivity(String activityId){
        // Implementation to fetch recommendations by activityId

        return recommendationRepository.findByActivityId(activityId).stream().map(this::mappedToResponse).toList();
        

    }
    public RecommendationResponse generateRecommendation(RecommendationRequest request){
        // implementation to generate recommendations for user
        Users user = userRepo.findById(request.getUserId()).orElseThrow(() ->  new RuntimeException("user not found"));
        Activity act = activityRepo.findById(request.getActivityId()).orElseThrow(()-> new RuntimeException("activity not found"));

        Recommendation recommendation = Recommendation.builder()
                                        .type(request.getType())
                                        .safety(request.getSafety())
                                        .recommendation(request.getRecommendation())
                                        .improvements(request.getImprovements())
                                        .suggestions(request.getSuggestions())
                                        .user(user)
                                        .activity(act)
                                        .build();
         
        Recommendation savedRecommendation = recommendationRepository.save(recommendation);
        return mappedToResponse(savedRecommendation);
    
    }


}

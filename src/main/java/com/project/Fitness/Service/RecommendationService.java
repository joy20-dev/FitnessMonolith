package com.project.Fitness.Service;

import java.util.List;

import com.project.Fitness.DTO.RecommendationResponse;
import com.project.Fitness.Models.Recommendation;

@Service
public class RecommendationService {
    private final RecommendationRepository recommendationRepository;

    private RecommendationResponse mappedToResponse(Recommendation recommendation){
        RecommendationResponse response = RecommendationResponse.builder()
                                            .

                                            build();
    }

    public List<RecommendationResponse> getRecommendationsByUser(String userId){
        // Implementation to fetch recommendations by userId

    }

    public List<RecommendationResponse> getRecommendationsByActivity(String activityId){
        // Implementation to fetch recommendations by activityId
        

    }
    public List<RecommendationResponse> generateRecommendation(RecommendationRequest request){
        // implementation to generate recommendations for user
    
    }


}

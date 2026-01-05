package com.project.Fitness.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest{
    private String userId;
    private String activityId;
    private String type;
    private String recommendation;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;

}
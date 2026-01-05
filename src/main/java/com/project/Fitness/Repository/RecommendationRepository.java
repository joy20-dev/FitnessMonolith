package com.project.Fitness.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Fitness.Models.Recommendation;


public interface RecommendationRepository extends JpaRepository<Recommendation, Long>{
    List<Recommendation> findByUserId(String userId);
    List<Recommendation> findByActivityId(String activityId);
    

    
    

}

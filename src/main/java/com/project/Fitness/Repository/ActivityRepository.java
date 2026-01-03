package com.project.Fitness.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Fitness.Models.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	

}

package com.project.Fitness.Repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Fitness.Models.Users;

@Repository
public interface UserRepository  extends JpaRepository<Users, String>{
    Optional<Users> findByEmail(String email);

}

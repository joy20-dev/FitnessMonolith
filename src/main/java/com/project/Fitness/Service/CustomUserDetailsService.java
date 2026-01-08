package com.project.Fitness.Service;

import com.project.Fitness.Models.Users;
import com.project.Fitness.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService{

    
    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email){
        Users savedUser = userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("user not found"));

        UserDetails userDetails =  org.springframework.security.core.userdetails.User.builder().
                                                                                                    username(savedUser.getEmail()).
                                                                                                    password(savedUser.getPassword()).
                                                                                                    authorities(new SimpleGrantedAuthority(savedUser.getRole())).
                                                                                                    build();
                                                                                                
        return userDetails;

    }

    

}

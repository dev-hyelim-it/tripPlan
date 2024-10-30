package com.teamProject.tripPlan.service;

import com.teamProject.tripPlan.dto.CustomUserDetails;
import com.teamProject.tripPlan.entity.Users;
import com.teamProject.tripPlan.repository.JoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private JoinRepository joinRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Users users = joinRepository.findByUserId(userId);
        if (!ObjectUtils.isEmpty(users)) {
            return new CustomUserDetails(users);
        }
        return null;
    }
}

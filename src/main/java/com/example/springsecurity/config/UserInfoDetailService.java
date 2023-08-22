package com.example.springsecurity.config;

import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.repository.UserInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoDetailService implements UserDetailsService {

    @Autowired
    UserInfoRepo userInfoRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userInfo = userInfoRepo.findByName(username);
     return userInfo.map(UserInfoUserDetail::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}

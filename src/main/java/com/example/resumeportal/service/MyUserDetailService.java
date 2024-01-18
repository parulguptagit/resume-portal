package com.example.resumeportal.service;

import com.example.resumeportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.resumeportal.model.MyUser;
import com.example.resumeportal.model.MyUserDetails;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> user = userRepository.findByUserName(username);


        user.orElseThrow(()-> new UsernameNotFoundException("Not Found" + username));

        return user.map(MyUserDetails::new).get();
    }
}

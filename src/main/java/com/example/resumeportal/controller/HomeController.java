package com.example.resumeportal.controller;

import com.example.resumeportal.model.UserProfile;
import com.example.resumeportal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("principal","hello");
        return "hello World";
    }

    @GetMapping("/edit")
    public String edit(){
        return "edit World";
    }

    @GetMapping("/view/{userId}")
    public String view(@PathVariable ("userId") String userId, Model model){
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(()-> new RuntimeException("Not Found" + userId));
        UserProfile userProfile = userProfileOptional.get();
        model.addAttribute("userId",userId);
        model.addAttribute("userProfile", userProfile);
        return "profile-templates/" + userProfile.getTheme() + "/index";
    }
}

package com.codingpotato.controller;

import com.codingpotato.config.AppProperties;
import com.codingpotato.exception.ResourceNotFoundException;
import com.codingpotato.model.User;
import com.codingpotato.repository.UserRepository;
import com.codingpotato.security.CurrentUser;
import com.codingpotato.security.TokenProvider;
import com.codingpotato.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenProvider tokenProvider;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

    @GetMapping("/profile")
    public Map<String, String> requestSomething(@RequestHeader Map<String, Object> requestHeader) {
        System.out.println(requestHeader);

        String temp = requestHeader.get("authorization").toString().replace("Bearer ","");

        HashMap<String,String> map = new HashMap<>();
        map.put("userEmail",tokenProvider.getUserEmailFromToken(temp));

        return map;
    }
}

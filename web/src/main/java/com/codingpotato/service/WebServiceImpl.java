package com.codingpotato.service;

import com.codingpotato.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebServiceImpl implements WebService{

    @Autowired
    private TokenProvider tokenProvider;

    public Map<String, String> getProfile(String params){

        HashMap<String, String> userProfile = new HashMap<>();

        userProfile.put("userEmail", tokenProvider.getUserEmailFromToken(params));

        return userProfile;
    }
}

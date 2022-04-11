package com.codingpotato.controller;

import com.codingpotato.exception.ResourceNotFoundException;
import com.codingpotato.model.User;
import com.codingpotato.repository.UserRepository;
import com.codingpotato.security.CurrentUser;
import com.codingpotato.security.TokenProvider;
import com.codingpotato.security.UserPrincipal;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
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

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        String path = "D:\\Git\\VideoMosaicWeb\\web\\src\\main\\resources\\slice_test2.mp4";

        byte[] fileByte = FileUtils.readFileToByteArray(new File(path));

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("slice_test2.mp4", "UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}

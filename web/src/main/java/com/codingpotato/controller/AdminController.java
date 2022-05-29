package com.codingpotato.controller;

import com.codingpotato.DTO.BoardDTO;
import com.codingpotato.DTO.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @PostMapping("/adminlogin")
    public String adminLogin(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getId());
        return "test";
    }

}

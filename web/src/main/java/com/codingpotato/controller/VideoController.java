package com.codingpotato.controller;

import com.codingpotato.DTO.BoardDTO;
import com.codingpotato.model.Board;
import com.codingpotato.repository.UserRepository;
import com.codingpotato.security.TokenProvider;
import com.codingpotato.service.BoardService;
import com.codingpotato.service.VideoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.Socket;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import java.util.Optional;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private TokenProvider tokenProvider;


    @GetMapping("/download/list")
    public String[] downloadList(@RequestHeader Map<String, Object> requestHeader) throws Exception {
        String reqToken = requestHeader.get("authorization").toString().replace("Bearer ", "");
        String userEmail = tokenProvider.getUserEmailFromToken(reqToken);

        String[] fileNames = videoService.downloadList(userEmail);
        return fileNames;
    }

    @GetMapping("/download")
    public void download(@RequestHeader Map<String, Object> requestHeader,
                         HttpServletResponse response,
                         @RequestParam("fileName") String fileName) throws Exception {
        String reqToken = requestHeader.get("authorization").toString().replace("Bearer ", "");
        String userEmail = tokenProvider.getUserEmailFromToken(reqToken);

        videoService.downloadVideo(response, userEmail, fileName);
    }


    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadvideo(@RequestHeader Map<String, Object> requestHeader,
                            @RequestParam(value = "video") MultipartFile video,
                            @RequestParam(value = "face") MultipartFile face) throws Exception {
        String reqToken = requestHeader.get("authorization").toString().replace("Bearer ", "");
        String userEmail = tokenProvider.getUserEmailFromToken(reqToken);

        videoService.uploadVideo(video, face, userEmail);
    }
}

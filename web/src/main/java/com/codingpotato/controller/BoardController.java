package com.codingpotato.controller;

import com.codingpotato.DTO.BoardDTO;
import com.codingpotato.model.Board;
import com.codingpotato.service.BoardService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import java.util.Optional;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @PostMapping("/insert")
    public void insertBoard(@RequestBody BoardDTO boardDTO) throws Exception {
        boardService.insertBoard(boardDTO);
    }

    @GetMapping("/index")
    public List<Board> insertBoard() throws Exception {
        return boardService.indexBoard();
    }

    @GetMapping("/read")
    public Optional<Board> readBoard(BoardDTO boardDTO) throws Exception {
        return boardService.readBoard(boardDTO);
    }

    @PostMapping("/update")
    public void updateBoard(@RequestBody BoardDTO boardDTO) throws Exception {
        boardService.updateBoard(boardDTO);
    }

    @PostMapping("/delete")
    public void deleteBoard(@RequestBody BoardDTO boardDTO) throws Exception {
        boardService.deleteBoard(boardDTO);
    }

}

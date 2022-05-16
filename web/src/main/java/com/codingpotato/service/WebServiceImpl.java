package com.codingpotato.service;

import com.codingpotato.DTO.BoardDTO;
import com.codingpotato.model.Board;
import com.codingpotato.repository.BoardRepository;
import com.codingpotato.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebServiceImpl implements WebService{

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void insertBoard(BoardDTO boardDTO) throws Exception {
        Board board = new Board();
        board.setTitle(boardDTO.getTitle());
        board.setContent(boardDTO.getContent());
        boardRepository.save(board);
    }

    public List<Board> indexBoard() throws Exception {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Map<String, String> getProfile(String params){
        HashMap<String, String> userProfile = new HashMap<>();
        userProfile.put("userEmail", tokenProvider.getUserEmailFromToken(params));
        return userProfile;
    }
}

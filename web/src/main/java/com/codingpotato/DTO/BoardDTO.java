package com.codingpotato.DTO;

import com.codingpotato.model.Board;
import com.codingpotato.model.User;
import lombok.*;


@Data
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;
}

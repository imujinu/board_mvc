package com.beyond.basic.b2_board.author.dto;

import com.beyond.basic.b2_board.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorFindById {
    private Author author;
    private String errorMessage;

}

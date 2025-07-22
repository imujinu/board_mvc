package com.beyond.basic.b2_board.author.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorLoginDto {
    private String email;
    private String password;
}

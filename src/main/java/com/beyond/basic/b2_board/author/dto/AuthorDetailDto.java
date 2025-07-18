package com.beyond.basic.b2_board.author.dto;

import com.beyond.basic.b2_board.author.domain.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorDetailDto {
    private Long id;
    private String name;
    private String email;

    // 1개의 entity로만 조립되는 것이 아니기에, dto 계층에서 fromEntity를 설계
    public static AuthorDetailDto fromEntity(Author author){
    return new AuthorDetailDto(author.getId(), author.getName(), author.getEmail());
    }
}

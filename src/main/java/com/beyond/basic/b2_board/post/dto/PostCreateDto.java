package com.beyond.basic.b2_board.post.dto;

import com.beyond.basic.b2_board.author.domain.Author;
import com.beyond.basic.b2_board.post.domain.Post;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostCreateDto {
    @NotEmpty(message = "제목은 필수 값입니다.")
    private String title;
    private String contents;
    @Builder.Default
    private String appointment="N";
    private String category;

    //시간 정보는 직접 localDateTime으로 형변환 하는 경우가 많음.

    private String appointmentTime;
//    @NotNull // 숫자는 NotEmpty사용 불가
//    private Long authorId;

    public Post toEntity(Author author, LocalDateTime appointmentTime){
        return Post.builder()
                .title(this.title)
                .contents(this.contents)
                .author(author)
                .delYn("N")
                .appointment(this.appointment)
                .category(this.category)
                .appointmentTime(appointmentTime)
                .build();
    }
}

package com.beyond.basic.b1_hello.controller;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

//@Getter // 클래스 내의 모든 변수를 대상으로 getter를 생성
//@Setter
@Data // getter, setter, toString 메서드까지 만들어주는 어노테이션
@AllArgsConstructor // 모든 매개변수가 있는 생성자
@NoArgsConstructor
//기본 생성자 + getter로 parsing이 이뤄지므로 보통은 필수적 요소
public class Hello {
    private String name;
    private String email;
//    private MultipartFile photo;


}

package com.beyond.basic.b1_hello.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private String email;
    private List<score> scores;

    @Data
    @NoArgsConstructor
    static class score{
        private String subject;
        private int point;
    }

}

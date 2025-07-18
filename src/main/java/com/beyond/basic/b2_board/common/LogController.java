package com.beyond.basic.b2_board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    //logback 객체 만드는 방법 1.
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);
    @GetMapping("/log/test")
    public String logTest(){
        // 기존의 system print는 spring에서는 잘 사용되지 않음
        // 이유 1 : 성능이 떨어짐
        // 이유 2 : 로그 분류작업 불가

        System.out.println("hello world");
        // 가장 많이 사용되는 로그 라이브러리 : logback
        // 로그레벨(프로젝트 차원의 설정) : trace < debug < info < error
        logger.trace("trace 로그입니다.");
        logger.debug("debug 로그입니다.");
        logger.info("info 로그입니다.");
        logger.error("error 로그 입니다.");
        return "ok";
    }
}

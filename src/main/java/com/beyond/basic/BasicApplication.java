package com.beyond.basic;

import com.beyond.basic.b1_hello.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//ComponentScan은 Application  파일을 포함한 하위 요소들만 scan 가능
@SpringBootApplication

//주로 web 서블릿 기반의 구성요소를 스캔, 자동으로 빈으로 등록
@ServletComponentScan
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	HelloController hc = new HelloController();

}

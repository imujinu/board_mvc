package com.beyond.basic;

import com.beyond.basic.b1_hello.controller.HelloController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ComponentScan은 Application  파일을 포함한 하위 요소들만 scan 가능
@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
	}
	HelloController hc = new HelloController();

}

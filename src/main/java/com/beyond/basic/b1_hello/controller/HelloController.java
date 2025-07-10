package com.beyond.basic.b1_hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//어노테이션 내에 컴포넌트 어노테이션이 붙어있을 경우 별도의 객체를 생성할 필요가 없는 싱글톤 객체 생성한다.
//Controller 어노테이션을 통해 쉽게 사용자의 http rep를 분석하고, http res를 생서해준다.

@Controller
@RequestMapping("/hello")
public class HelloController {

    //get 요청 case들
    // case1. 서버가 사용자에게 단순히 String 데이터 return - @ResponseBody 있을 때

    @GetMapping("") //아래 메서드에 대한 서버의 엔드포인트 설정
// ResponseBody가 없고 return 타입이 String인 경우 서버는 templates폴더 밑에 파일 명을 찾는다.
//    @ResponseBody
    public String helloWorld(){
        return "helloworld";
    }

    // case 2. 서버가 사용자에게 String(json 형식)의 데이터 return

    @GetMapping("/json")
    @ResponseBody
    public Hello helloJson() throws JsonProcessingException {
        //직접 josn으로 직렬할 필요업이 return 타입에 객체가 있으면 자동으로 직렬화
        Hello h1 = new Hello("jinwoo", "jin@naver.com");
//        ObjectMapper objectMapper = new ObjectMapper();
//        String result = objectMapper.writeValueAsString(h1);
        return h1;
    }


    // case 3. parameter 방식을 통해 사용자로부터 값을 수신
    // parameter 형식 : /member?name=hongildong

    @GetMapping("/param")
    @ResponseBody
    public Hello param(@RequestParam(value = "name")String inputName){
        return new Hello(inputName, inputName+"@naver.com");
    }

    // case 4. pathVariable 방식
    // /member/1
    // pathVariable 방식은 url을 통해 자원의 구조를 명확하게 표현할 때 사용 좀 더 restful함
    @GetMapping("/path/{inputId}")
    @ResponseBody
    public String path(@PathVariable long inputId){
        //별도의 형변환 없이도, 매개변수에 타입지정 시 자동형변환 시켜줌.
        //        long id = Long.parseLong(inputId);
        System.out.println(inputId);
        return "OK";
    }

    // case 5. parameter 2개 이상 형식
    @GetMapping("/param2")
    @ResponseBody
    public Hello param2(@RequestParam(value = "name")String inputName, @RequestParam(value = "email")String inputEmail){

        return new Hello(inputName,inputEmail);
    }
}

package com.playdata.springfirstproject.domain.web.controller;

import com.playdata.springfirstproject.domain.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // command + shift + T : JUnit test code 생성

    /**
     * API GET method 테스트
     * @return hello 문자를 보여준다.
     */

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam(value = "name", defaultValue = "제이") String name,
                                     @RequestParam(value = "amount", defaultValue = "123") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

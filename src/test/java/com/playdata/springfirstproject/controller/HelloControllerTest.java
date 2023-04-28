package com.playdata.springfirstproject.controller;

import com.playdata.springfirstproject.domain.web.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

// Add-on demand 를 통해 static 으로 import 를 통해 생략해서 사용할 수 있다.
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class) // 스프링 프레임워크를 사용하는 테스트를 위한 설정
@WebMvcTest(controllers = HelloController.class) // 특정 컨트롤러를 테스트하기 위한 설정
class HelloControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // Http status 가 200 이면 ok
                .andExpect(content().string("hello")); // 응답 content 가 "hello" 인지 검증
    }

    @Test
    public void helloDto() throws Exception{
        //given
        String name = "제이";
        int amount = 123;

        // when

        // then
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amount").value(amount));
    }
}
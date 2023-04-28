package com.playdata.springfirstproject.domain.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HelloResponseDtoTest {
    // given-when-then
    // 소프트웨어 테스트에서 사용하는 표준 구문

    @Test
    public void lombokTest() {
        // given - 테스트에 필요한
        String name = "text";
        int amount = 123;

        // when -
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then -
        // assertThat 은 assertj 라이브러리에서 제공된다.
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
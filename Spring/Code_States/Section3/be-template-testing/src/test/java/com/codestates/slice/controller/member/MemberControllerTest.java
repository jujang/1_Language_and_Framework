package com.codestates.slice.controller.member;

import com.codestates.member.dto.MemberDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    void postMemberTest() throws Exception {
        // given (1)
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com",
                                                    "홍길동",
                                                    "010-1234-5678");
        String content = gson.toJson(post); // (2)

        // when
        ResultActions actions =
                mockMvc.perform(    // (3)
                                    post("/v11/members") // (4)
                                        .accept(MediaType.APPLICATION_JSON) // (5)
                                        .contentType(MediaType.APPLICATION_JSON) // (6)
                                        .content(content) // (7)
        );

        // then
        actions
                .andExpect(status().isCreated()) // (8)
                .andExpect(header().string("Location", is(startsWith("/v11/members/")))); // (9)
    }

    @Test
    void getMemberTest() throws Exception {
        // ===================================== (1) postMember()를 이용한 테스트 데이터 생성 시작
        // given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com", "홍길동", "010-1111-1111");
        String postContent = gson.toJson(post);

        ResultActions postActions =
                mockMvc.perform(
                    post("/v11/members")
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(postContent)
                );
        // ===================================== (1) postMember()를 이용한 테스트 데이터 생성 끝

        // (2)
        String location = postActions.andReturn().getResponse().getHeader("Location");

        // when / then
        mockMvc.perform(
                        get(location)  // (3)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())  // (4)
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))    // (5)
                .andExpect(jsonPath("$.data.name").value(post.getName()))      // (6)
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()));   // (7)
    }
}

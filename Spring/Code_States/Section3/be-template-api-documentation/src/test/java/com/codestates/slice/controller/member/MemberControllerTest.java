package com.codestates.slice.controller.member;

import com.codestates.helper.MemberControllerTestHelper;
import com.codestates.helper.StubData;
import com.codestates.member.dto.MemberDto;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Controller의 API만 이용하는 방법(리팩토링 후)
 */
@Transactional    // 테스트 케이스 하나의 실행이 끝나면 매 번 rollback 처리를 해준다.
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest implements MemberControllerTestHelper {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    private ResultActions postResultActions;
    private MemberDto.Post post;
    private MvcResult postResult;

    @BeforeEach
    public void init() throws Exception {
        // given
        this.post = (MemberDto.Post) StubData.MockMember.getRequestBody(HttpMethod.POST);
        String content = gson.toJson(post);
        URI uri = getURI();
        this.postResultActions = mockMvc.perform(postRequestBuilder(uri, content));
    }

    @Test
    public void postMemberTest() throws Exception {
        // given
        // init() 에서..

        // when
        // init() 에서..

        // then
        this.postResultActions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
    }

    @Test
    void patchMemberTest() throws Exception {
        // given
        long memberId = getResponseMemberId();

        MemberDto.Patch patch =
                (MemberDto.Patch) StubData.MockMember.getRequestBody(HttpMethod.PATCH); // 별도의 Stub Data를 만들어서 재사용
        String content = gson.toJson(patch);
        URI uri = getURI(memberId);

        // when
        ResultActions actions =
                mockMvc.perform(patchRequestBuilder(uri, content));

        // then
        actions.andExpect(status().isOk())
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()));
    }

    @Test
    void getMemberTest() throws Exception {
        // given
        // init() 에서..

        // when
        long memberId = getResponseMemberId();
        URI uri = getURI(memberId);

        // then
        mockMvc.perform(getRequestBuilder(uri))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.email").value(this.post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(this.post.getName()))
                .andExpect(jsonPath("$.data.phone").value(this.post.getPhone()));
    }

    @Test
    void getMembersTest() throws Exception {
        // given
        String content = gson.toJson(new MemberDto.Post("hgd2@gmail.com", "홍길동2",
                "010-2222-2222"));
        URI uri = getURI();

        // init에서 첫번째 데이터를 DB에 넣어 준 후, 두 번째 데이터 한번 더..
        mockMvc.perform(postRequestBuilder(uri, content));

        String page = "1";
        String size = "10";
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", page);
        queryParams.add("size", size);

        // when
        ResultActions actions = mockMvc.perform(getRequestBuilder(uri, queryParams));

        // then
        MvcResult result = actions
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.data").isArray())
                                .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertThat(list.size(), is(2));
    }

    @Test
    void deleteMemberTest() throws Exception {
        // given
        // init() 에서 DB에 넣어준다.

        // when
        long memberId = getResponseMemberId();
        URI uri = getURI(memberId);

        // then
        mockMvc.perform(deleteRequestBuilder(uri))
                .andExpect(status().isNoContent());
    }

    private long getResponseMemberId() {
        long memberId;
        String location = this.postResultActions.andReturn().getResponse().getHeader("Location"); // "/v11/members/1"
        memberId = Long.parseLong(location.substring(location.lastIndexOf("/") + 1));

        return memberId;
    }
}

package com.codestates.restdocs.member;


import com.codestates.helper.StubData;
import com.codestates.member.controller.MemberController;
import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;

import static com.codestates.util.ApiDocumentUtils.getRequestPreProcessor;
import static com.codestates.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class MemberControllerRestDocsTest {
    @Autowired
    private MockMvc mockMvc;

    // (1)
    @MockBean
    private MemberService memberService;

    // (2)
    @MockBean
    private MemberMapper mapper;

    @Autowired
    private Gson gson;

    @Test
    public void postMemberTest() throws Exception {
        // (3) given
        MemberDto.Post post = new MemberDto.Post("hgd@gmail.com", "홍길동", "010-134-5678");
        String content = gson.toJson(post);

        // (4)
        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        // (5)
        Member mockResultMember = new Member();
        mockResultMember.setMemberId(1L);
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(mockResultMember);

        // (6)
        ResultActions actions =
                mockMvc.perform(
                        post("/v11/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))))
                .andDo(document(        // (7)
                        "post-member",      // (7-1)
                        getRequestPreProcessor(),       // (7-2)
                        getResponsePreProcessor(),      // (7-3)
                        requestFields(      // (7-4)
                                List.of(
                                        fieldWithPath("email").type(JsonFieldType.STRING).description("이메일"), // (7-5)
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호")
                                )
                        ),
                        responseHeaders(        // (7-6)
                                headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                        )
                ));
    }

    @Test
    public void patchMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Patch patch = new MemberDto.Patch(memberId, "홍길동", "010-1111-1111", Member.MemberStatus.MEMBER_ACTIVE);
        String content = gson.toJson(patch);

        MemberDto.Response responseDto =
                new MemberDto.Response(1L,
                        "hgd@gmail.com",
                        "홍길동",
                        "010-1111-1111",
                        Member.MemberStatus.MEMBER_ACTIVE,
                        new Stamp());

        // willReturn()이 최소한 null은 아니어야 한다.
        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());

        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());

        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(responseDto);

        // when
        ResultActions actions =
                mockMvc.perform(
                        patch("/v11/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(patch.getMemberId()))
                .andExpect(jsonPath("$.data.name").value(patch.getName()))
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(patch.getMemberStatus().getStatus()))
                .andDo(document("patch-member",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(         // (1)
                                parameterWithName("member-id").description("회원 식별자 ID")
                        ),
                        requestFields(
                                List.of(
                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자").ignored(),       // (2)
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름").optional(),
                                        fieldWithPath("phone").type(JsonFieldType.STRING).description("휴대폰 번호").optional(),
                                        fieldWithPath("memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴먼 계정) / MEMBER_QUIT(탈퇴)")
                                                .optional()
                                )
                        ),
                        responseFields(         // (4)
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),        // (5)
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴먼 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void getMemberTest() throws Exception {
        // given
        long memberId = 1L;
        MemberDto.Response response = new MemberDto.Response(memberId, "jujang@gmail.com", "jujang", "010-1234-5678", Member.MemberStatus.MEMBER_ACTIVE, new Stamp());

        given(memberService.findMember(Mockito.any(long.class))).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions getAction =
                mockMvc.perform(
                        get("/v11/members/{member-id}", memberId)
                                .accept(MediaType.APPLICATION_JSON)
        );

        // then
        getAction
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.memberId").value(response.getMemberId()))
                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
                .andExpect(jsonPath("$.data.name").value(response.getName()))
                .andExpect(jsonPath("$.data.phone").value(response.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(response.getMemberStatus()))
                .andExpect(jsonPath("$.data.stamp").value(response.getStamp()))
                .andDo(document("get-member",
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자 ID")
                        ),
                        responseFields(
                                List.of(
                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터").optional(),
                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                        fieldWithPath("data.email").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("data.name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("data.phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                        fieldWithPath("data.memberStatus").type(JsonFieldType.STRING)
                                                .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴먼 계정) / MEMBER_QUIT(탈퇴)"),
                                        fieldWithPath("data.stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수")
                                )
                        )
                ));
    }

    @Test
    public void getMembersTest() throws Exception {
        // given
        int page = 1;
        int size = 10;

        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("page", String.valueOf(page));
        queryParams.add("size", String.valueOf(size));


        Member member1 = new Member("jujang1@gmail.com", "jujang1", "010-1111-1111");
        member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member1.setStamp(new Stamp());

        Member member2 = new Member("jujang2@gmail.com", "jujang2", "010-2222-2222");
        member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member2.setStamp(new Stamp());

        Page<Member> pageMembers =
                new PageImpl<>(
                        List.of(member1, member2),
                        PageRequest.of(page, size,
                                Sort.by("memberId").descending()), 2
                );
        given(memberService.findMembers(Mockito.any(int.class), Mockito.any(int.class))).willReturn(pageMembers);

//        List<MemberDto.Response> responses = StubData.MockMember.getRequestBody();

        List<MemberDto.Response> responses =
                List.of(
                        new MemberDto.Response(
                                1L,
                                "jujang1@gmail.com",
                                "jujang1",
                                "010-1111-1111",
                                Member.MemberStatus.MEMBER_ACTIVE,
                                new Stamp()
                        ),
                        new MemberDto.Response(
                                2L,
                                "jujang2@gmail.com",
                                "jujang2",
                                "010-2222-2222",
                                Member.MemberStatus.MEMBER_ACTIVE,
                                new Stamp()
                        )
                );
        given(mapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);


        // when
        ResultActions getsAction =
                mockMvc.perform(
                        get("/v11/members")
                                .params(queryParams)
                                .accept(MediaType.APPLICATION_JSON)
                );


        // then
        MvcResult result =
                getsAction
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data").isArray())
                        .andDo(document("get-members",
                                getRequestPreProcessor(),
                                getResponsePreProcessor(),
                                requestParameters(
                                        parameterWithName("page").description("페이지 번호"),
                                        parameterWithName("size").description("페이지 사이즈")
                                ),
                                responseFields(
                                        List.of(
                                                fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터").optional(),
                                                fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
                                                fieldWithPath("data[].email").type(JsonFieldType.STRING).description("이메일"),
                                                fieldWithPath("data[].name").type(JsonFieldType.STRING).description("이름"),
                                                fieldWithPath("data[].phone").type(JsonFieldType.STRING).description("휴대폰 번호"),
                                                fieldWithPath("data[].memberStatus").type(JsonFieldType.STRING)
                                                        .description("회원 상태: MEMBER_ACTIVE(활동중) / MEMBER_SLEEP(휴면 계정) / MEMBER_QUIT(탈퇴)"),
                                                fieldWithPath("data[].stamp").type(JsonFieldType.NUMBER).description("스탬프 갯수"),
                                                fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지 정보"),
                                                fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("페이지 번호"),
                                                fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 사이즈"),
                                                fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("전체 건 수"),
                                                fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("전체 페이지 수")
                                        )
                                )
                        ))
                        .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");
        assertEquals(list.size(), 2);
    }

    @Test
    public void deleteMemberTest() throws Exception {
        // given
        long memberId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.any(long.class));

        // when
        ResultActions deleteAction =
                mockMvc.perform(
                        delete("/v11/members/{member-id}", memberId)
                );

        // then
        deleteAction
                .andExpect(status().isNoContent())
                .andDo(document("delete-member",
                        pathParameters(
                                parameterWithName("member-id").description("회원 식별자")
                        )
                ));
    }

}

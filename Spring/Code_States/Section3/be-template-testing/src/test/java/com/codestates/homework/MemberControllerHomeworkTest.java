package com.codestates.homework;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerHomeworkTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private MemberService memberService;

    @MockBean
    private MemberMapper mapper;

    @Test
    void postMemberTest() throws Exception {
        // given
        MemberDto.Post post = new MemberDto.Post("jujang@gmail.com", "주장", "010-1111-2222");
        String content = gson.toJson(post);
        URI uri = UriComponentsBuilder.newInstance().path("/v11/members").build().toUri();

        given(mapper.memberPostToMember(Mockito.any(MemberDto.Post.class))).willReturn(new Member());

        Member mockMember = new Member();
        mockMember.setMemberId(1L);
        given(memberService.createMember(Mockito.any(Member.class))).willReturn(mockMember);

        // when
        ResultActions postAction =
                mockMvc.perform(
                        post(uri)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        // then
        postAction
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/v11/members/"))));
    }

    @Test
    void patchMemberTest() throws Exception {
        // TODO MemberController의 patchMember() 핸들러 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // give
        long memberId = 1L;
        MemberDto.Patch patch = new MemberDto.Patch(memberId, "주장", "010-1234-5678", Member.MemberStatus.MEMBER_ACTIVE);
        String patchContent = gson.toJson(patch);

        MemberDto.response response = new MemberDto.response(memberId, "jujang@gmail.com", "주장", "010-1234-5678", Member.MemberStatus.MEMBER_ACTIVE, new Stamp());

        given(mapper.memberPatchToMember(Mockito.any(MemberDto.Patch.class))).willReturn(new Member());
        given(memberService.updateMember(Mockito.any(Member.class))).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        URI uri = UriComponentsBuilder.newInstance().path("/v11/members").build().toUri();

        // when
        ResultActions patchAction =
                mockMvc.perform(
                        patch(uri + "/" + memberId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(patchContent)
                );

        // then
        patchAction
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.phone").value(patch.getPhone()));
    }

    @Test
    void getMemberTest() throws Exception {
        // TODO MemberController의 getMember() 핸들러 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // given
        long memId = 1L;

        MemberDto.response response = new MemberDto.response(memId, "jujang@gmail.com", "jujang", "010-1234-5678", Member.MemberStatus.MEMBER_ACTIVE, new Stamp());

        given(memberService.findMember(memId)).willReturn(new Member());
        given(mapper.memberToMemberResponse(Mockito.any(Member.class))).willReturn(response);

        // when
        ResultActions getResultAction =
                mockMvc.perform(
                        get("/v11/members/" + memId)
                                .accept(MediaType.APPLICATION_JSON)
                );

        // then
        getResultAction
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.email").value(response.getEmail()))
                .andExpect(jsonPath("$.data.name").value(response.getName()))
                .andExpect(jsonPath("$.data.phone").value(response.getPhone()))
                .andExpect(jsonPath("$.data.memberStatus").value(response.getMemberStatus()))
                .andExpect(jsonPath("$.data.stamp").value(response.getStamp()));
    }

    @Test
    void getMembersTest() throws Exception {
        // TODO MemberController의 getMembers() 핸들러 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // given
        int page = 1;
        int size = 10;

        Member member1 = new Member("jujang1@gmail.com", "주장1", "010-1111-1111");
        member1.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member1.setStamp(new Stamp());

        Member member2 = new Member("jujang2@gmail.com", "주장2", "010-2222-2222");
        member2.setMemberStatus(Member.MemberStatus.MEMBER_ACTIVE);
        member2.setStamp(new Stamp());


        Page<Member> pageMembers = new PageImpl<>(List.of(member1, member2),
                PageRequest.of(page, size,
                        Sort.by("memberId").descending()), 2);

        List<MemberDto.response> responses = List.of(
                new MemberDto.response(1L,
                        "jujang1@gmail.com",
                        "주장1",
                        "010-1111-1111",
                        Member.MemberStatus.MEMBER_ACTIVE,
                        new Stamp()),
                new MemberDto.response(2L,
                        "jujang2@gmail.com",
                        "주장2",
                        "010-2222-2222",
                        Member.MemberStatus.MEMBER_ACTIVE,
                        new Stamp())
        );

        given(memberService.findMembers(Mockito.any(int.class), Mockito.any(int.class))).willReturn(pageMembers);
        given(mapper.membersToMemberResponses(Mockito.anyList())).willReturn(responses);

        // when
        ResultActions getsActions = mockMvc.perform(
                get("/v11/members" + "?" + "page=" + page + "&size=" + size)
                        .accept(MediaType.APPLICATION_JSON)
        );
//        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
//        queryParams.add("page", String.valueOf(page));
//        queryParams.add("size", String.valueOf(size));
//
//        URI uri = UriComponentsBuilder.newInstance().path("/v11/members").build().toUri();
//
//        ResultActions getsActions = mockMvc.perform(
//                get(uri)
//                        .params(
//                                queryParams
//                        )
//                        .accept(MediaType.APPLICATION_JSON));

        // then
        MvcResult result =
                getsActions
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.data").isArray())
                        .andReturn();

        List list = JsonPath.parse(result.getResponse().getContentAsString()).read("$.data");

        assertEquals(list.size(), 2);
    }

    @Test
    void deleteMemberTest() throws Exception {
        // TODO MemberController의 deleteMember() 핸들러 메서드를 테스트하는 테스트 케이스를 여기에 작성하세요.
        // TODO Mockito를 사용해야 합니다. ^^

        // given
        long memId = 1L;
        doNothing().when(memberService).deleteMember(Mockito.any(long.class));

        // when
        ResultActions deleteAction = mockMvc.perform(delete("/v11/members/" + memId));

        // then
        deleteAction.andExpect(status().isNoContent());
    }
}


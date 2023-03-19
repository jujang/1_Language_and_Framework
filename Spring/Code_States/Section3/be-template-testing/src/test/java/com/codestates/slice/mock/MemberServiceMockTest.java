package com.codestates.slice.mock;

import com.codestates.exception.BusinessLogicException;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

// (1)
@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {
    @Mock // (2)
    private MemberRepository memberRepository;

    @InjectMocks // (3)
    private MemberService memberService;

    @Test
    public void createMemberTest() {
        // given
        Member member = new Member("hgd@gmail.com", "홍길동", "010-1111-1111");

        // (4)
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.ofNullable(member)); // (5)


        // when & then (6)
        assertThrows(BusinessLogicException.class, () -> memberService.createMember(member));
    }

    @Test
    public void createMemberNotThrowTest() {
        // given
        Member member2 = new Member("111@gmail1.com", "1홍길동1", "210-1111-1112");

        // (4)
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(Optional.ofNullable(null)); // (5)

        // when & then (6)
        assertDoesNotThrow(() -> memberService.createMember(member2));
    }
}

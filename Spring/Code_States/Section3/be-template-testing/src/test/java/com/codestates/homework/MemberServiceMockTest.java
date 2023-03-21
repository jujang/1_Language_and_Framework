package com.codestates.homework;


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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {
    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    void deleteMemberTest(){
        // given
        long memberId = 1L;
        Optional<Member> optionalMember = Optional.empty();

        when(memberRepository.findById(Mockito.any(long.class))).thenReturn(optionalMember);

        // when & then
        assertThrows(BusinessLogicException.class, () -> memberService.deleteMember(memberId));
    }
}

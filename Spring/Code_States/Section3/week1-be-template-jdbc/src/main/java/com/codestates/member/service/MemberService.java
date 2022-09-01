package com.codestates.member.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * V2
 *  - 메서드 구현
 *  - DI 적용
 */
@Service
public class MemberService {
    public Member createMember(Member member) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Member updateMember(Member member) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public Member findMember(long memberId) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public List<Member> findMembers() {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }

    public void deleteMember(long memberId) {
        // TODO should business logic

        throw new BusinessLogicException(ExceptionCode.NOT_IMPLEMENTATION);
    }
}

package com.codestates.member;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DBMemberService implements MemberService {

    @Override
    public Member createMember(Member member) {
        return null;
    }
}

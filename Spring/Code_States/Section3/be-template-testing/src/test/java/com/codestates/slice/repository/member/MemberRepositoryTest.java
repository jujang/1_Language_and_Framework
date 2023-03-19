package com.codestates.slice.repository.member;

import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest  // (1)
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;  // (2)

    @Test
    public void saveMemberTest() {
        // given  (3)
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when  (4)
        Member savedMember = memberRepository.save(member);

        // then  (5)
        assertNotNull(savedMember);
        assertTrue(member.getEmail().equals(savedMember.getEmail()));
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
    }

    @Test
    public void findByEmailTest(){
        // given (1)
        Member member = new Member();
        member.setEmail("hgd@gmail.com");
        member.setName("홍길동");
        member.setPhone("010-1111-2222");

        // when
        memberRepository.save(member); // (2)
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail()); // (3)

        // then (4)
        assertTrue(findMember.isPresent()); // (4-1)
        assertTrue(findMember.get().getEmail().equals(member.getEmail())); // (4-2)
    }
}

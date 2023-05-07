package com.codestates.config;

import com.codestates.member.InMemoryMemberService;
import com.codestates.member.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
    @Bean
    public MemberService inMemoryMemberService() {
        return new InMemoryMemberService();
    }
}

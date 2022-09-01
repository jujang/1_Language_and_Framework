package com.codestates.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *  - 멤버 변수 추가
 *  - lombok 추가
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private long memberId;

    private String email;

    private String name;

    private String phone;
}

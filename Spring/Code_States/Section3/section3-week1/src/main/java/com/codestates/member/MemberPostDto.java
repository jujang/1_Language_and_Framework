package com.codestates.member;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberPostDto {

    @NotBlank
    @Email
    private String email;
    // 값이 비어있지 않거나 공백이 아니어야 함 -> @NotBlank
    // 유효한 이메일 주소 형식이어야 함 -> @Email

    @NotBlank(message="이름은 공백이 아니어야 합니다.")
    private String name;
    // 값이 비어있지 않거나 공백이 아니어야 함


    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;
    // 값이 비어있지 않거나 공백이 아니어야 함
    // 아래와 같이 010으로 시작하는 11자리 숫자와 '-'로 구성된 문자열이어야 함


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

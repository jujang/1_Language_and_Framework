package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member1 = new HashMap<>();
        long memberId = 1L;
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! -------------------//

    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
    @PutMapping("/{member_Id}")
    public ResponseEntity putMember(@PathVariable("member_Id") long member_Id,
                                    @RequestParam("phone") String phone)
    {
        String email = (String) ((HashMap)members.get(member_Id)).get("email");
        String name = (String) ((HashMap)members.get(member_Id)).get("name");

        Map<String, Object> map = new HashMap<>();
        map.put("memberId", member_Id);
        map.put("email", email);
        map.put("name", name);
        map.put("phone",phone);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
    @DeleteMapping("/{member_Id}")
    public ResponseEntity deleteMember(@PathVariable("member_Id") long member_Id)
    {
        members.remove(member_Id);
        return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
    }
}

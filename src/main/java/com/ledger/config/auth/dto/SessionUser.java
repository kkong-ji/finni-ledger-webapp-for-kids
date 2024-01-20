package com.ledger.config.auth.dto;

import com.ledger.entity.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private static final long serialVersionUID = -3776997247765955522L;
    // 역직렬화할때 오류가 발생하여 serialVersionUID 를 명시적으로 선언해주었습니다.

    private String nickname;
    private String email;
    private String profile;

    public SessionUser(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.profile = member.getProfile();
    }
}

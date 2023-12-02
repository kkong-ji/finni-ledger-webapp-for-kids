package com.ledger.config.auth.dto;

import com.ledger.entity.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickname;
    private String email;
    private String profile;

    public SessionUser(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.profile = member.getProfile();
    }
}

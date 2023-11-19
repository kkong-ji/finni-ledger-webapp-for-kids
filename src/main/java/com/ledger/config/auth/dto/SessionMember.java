package com.ledger.config.auth.dto;

import com.ledger.constant.Profile;
import com.ledger.entity.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionMember implements Serializable {
    private String nickname;
    private String email;
    private String profile;

    public SessionMember(Member member) {
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.profile = member.getProfile();
    }
}

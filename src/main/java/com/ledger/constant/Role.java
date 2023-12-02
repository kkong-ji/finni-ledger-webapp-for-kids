package com.ledger.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    /**
     * 회원 권한 코드
     * (For Spring Security)
     **/

    GUEST("ROLE_GUEST", "손님"),
    SOCIAL("ROLE_SOCIAL", "일반 사용자");

    private final String key;
    private final String title;
}

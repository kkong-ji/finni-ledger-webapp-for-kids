package com.ledger.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Profile {

    /**
     * 회원 프로필 사진
     * 회원은 여러 개의 제공된 캐릭터 중 하나를 골라 프로필로 설정할 수 있다.
     * 로컬 PC에 저장된 사진을 불러와서 설정하는 것은 불가능.
     **/

    CAT, PUPPY
}

package com.ledger.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Session 값을 가져오는 부분이 중복됨.
 * 따라서, 반복코드를 줄이기 위해 메소드 인자로 세션값을 바로 받을 수 있게
 * @LoginUser 커스텀 어노테이션 생성
 */

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
}

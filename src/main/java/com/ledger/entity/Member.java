package com.ledger.entity;

import com.ledger.constant.Profile;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    private String nickname;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    private String provider;                    // oauth2를 이용한 소셜 로그인 시 플랫폼

    @Column(name="social_id", unique = true)    // 회원들을 유일하게 식별하는 값이기 때문에 unique = true 값 걸어둠
    private String providerId;                  // oauth2를 이용한 소셜 로그인 시 아이디값

//        @Builder(builderClassName = "OAuth2Register", builderMethodName = "userDetailRegister")
//        public Member(String nickname, String password, String picture, String provider, String providerId) {
//            this.nickname = nickname;
//            this.password = password;
//            this.picture = picture;
//            this.provider = provider;
//            this.providerId = providerId;
//        }

    /**
     * 회원수정 메소드
     */
    public void updateUserNickname(String nickname) { this.nickname = nickname; }

    public void updateUserAge(Integer age) { this.age = age; }

    // 유저 password 변경의 경우, 사용자가 직접 변경할 수는 없지만 로그인 플랫폼이 변경될 경우를 위한 것
    // ex) 카카오 -> 네이버로 변경. 두 소셜 계정의 비밀번호는 각각 다를 수 있기 때문
    private void updatePassword(String password) { this.password = password; }

    public void updateUserProvider(String provider) { this.provider = provider; }

    // 상기 서술한 updatePassword 메소드와 같은 이유로 private
    private void updateUserProviderId(String providerId) { this.providerId = providerId; }
}

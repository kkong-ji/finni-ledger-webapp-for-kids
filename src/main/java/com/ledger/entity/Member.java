package com.ledger.entity;

import com.ledger.constant.Role;
import lombok.*;
<<<<<<< HEAD
=======

import javax.persistence.*;
>>>>>>> Feat/oauth2-login

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column(nullable = false, length = 50)
    private String email;

    @Column
<<<<<<< HEAD
=======
    private String password;

    @Column
>>>>>>> Feat/oauth2-login
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String profile;    // 회원 프로필 사진

    @Builder
<<<<<<< HEAD
    public Member(String nickname, String profile, String email, Role role) {
=======
    public Member(String nickname, String email, String profile, Role role) {
>>>>>>> Feat/oauth2-login
        this.nickname = nickname;
        this.email = email;
        this.profile = profile;
        this.role = role;
    }


    /**
     * 회원 수정 메소드
     */
    public Member update(String nickname, String profile) {
        this.nickname = nickname;
        this.profile = profile;
<<<<<<< HEAD
        this.email = email;
        this.role = role;
=======

>>>>>>> Feat/oauth2-login
        return this;
    }

    /* 소셜로그인시 이미 등록된 회원이라면 수정날짜만 업데이트하고
     * 기존 데이터는 그대로 보존하도록 예외처리 */
    public Member updateModifiedDate() {
        this.onPreUpdate();
        return this;
    }

    public String getRoleValue() {
        return this.role.getKey();
    }

}

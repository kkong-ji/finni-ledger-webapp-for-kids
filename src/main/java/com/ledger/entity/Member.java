package com.ledger.entity;

import com.ledger.constant.Profile;
import com.ledger.constant.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="member")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member extends BaseEntity {

    @Id
    @Column(name="member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column(nullable = false)
    private String email;           // 소셜 로그인 시 이메일 값

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String profile;    // 회원 프로필 사진

    @Builder
    public Member(String nickname, String profile, String email, Role role) {
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
        this.email = email;
        this.role = role;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}

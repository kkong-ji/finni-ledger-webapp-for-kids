package com.ledger.entity;

import com.ledger.constant.Role;
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "member")
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

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, length = 50)
    private String email;

    @Column
    private String password;

    @Column
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String profile;    // 회원 프로필 사진

    @OneToOne
    @JoinColumn(name = "pocketMoney_id")
    private PocketMoney pocketMoney;

    @Builder
    public Member(String nickname, String email, String profile, Role role) {
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
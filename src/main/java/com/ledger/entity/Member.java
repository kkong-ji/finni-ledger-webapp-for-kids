package com.ledger.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password;

    private String nickname;

    private Integer age;

    private String picture;

    private String provider;        // oauth2를 이용한 소셜 로그인 시 플랫폼

    @Column(name="social_id", unique = true)
    private String providerId;      // oauth2를 이용한 소셜 로그인 시 아이디값



}

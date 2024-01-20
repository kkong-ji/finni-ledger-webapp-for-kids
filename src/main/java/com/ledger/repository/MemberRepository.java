package com.ledger.repository;

import com.ledger.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

   Optional<Member> findByEmail(String email);     // 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지
                                                  // 처음 가입하는 사용자인지 판단하는 메소드

}

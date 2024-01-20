package com.ledger.repository;

import com.ledger.entity.PocketMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PocketMoneyRepository extends JpaRepository<PocketMoney, Long> {

    PocketMoney findByMemberId(Long memberId);  // 현재 로그인한 회원의 memberId를 알기위한 쿼리

    Optional<PocketMoney> findById(Long id);
}

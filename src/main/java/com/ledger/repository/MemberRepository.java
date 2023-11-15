package com.ledger.repository;

import com.ledger.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class MemberRepository implements JpaRepository<Member, Long> {

}

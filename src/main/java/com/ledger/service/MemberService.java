package com.ledger.service;

import com.ledger.entity.Member;
import com.ledger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;


    public Member findByEmail(String userEmail) {
        return memberRepository.findByEmail(userEmail).orElse(null);
    }

    public Member findMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

    /*
    * 회원 정보 업데이트
    * */
    @Transactional
    public void update(Member member) {
        memberRepository.save(member);
    }

    /*
    * 회원 탈퇴
    * */
    @Transactional
    public void delteMember(Long memberId) {
        Member memberById = findMemberById(memberId);
        memberRepository.delete(memberById);
    }



}

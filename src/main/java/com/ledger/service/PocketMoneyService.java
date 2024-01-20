package com.ledger.service;

import com.ledger.entity.PocketMoney;
import com.ledger.repository.PocketMoneyRepository;
import com.ledger.request.PocketMoneyForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PocketMoneyService extends BaseService{

    private final PocketMoneyRepository pocketMoneyRepository;

    public Long findById(Long memberId) {
        PocketMoney byMemberId = pocketMoneyRepository.findByMemberId(memberId);
        return byMemberId.getId();
    }
    public Long newPocketMoney(PocketMoneyForm pocketMoneyForm) {
        log.debug(pocketMoneyRepository.save(pocketMoneyForm.toEntity()).getId().toString());
        return pocketMoneyRepository.save(pocketMoneyForm.toEntity()).getId();
    }
}

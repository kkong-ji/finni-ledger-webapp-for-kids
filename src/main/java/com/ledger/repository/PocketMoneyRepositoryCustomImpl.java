package com.ledger.repository;

import com.ledger.request.PocketMoneyForm;
import com.ledger.entity.PocketMoney;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PocketMoneyRepositoryCustomImpl implements PocketMoneyRepositoryCustom {

    @Override
    public Page<PocketMoney> getPocketMoneyPage(PocketMoneyForm pocketMoneyForm, Pageable pageable) {
        return null;
    }
}

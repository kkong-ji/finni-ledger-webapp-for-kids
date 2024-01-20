package com.ledger.repository;

import com.ledger.request.PocketMoneyForm;
import com.ledger.entity.PocketMoney;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PocketMoneyRepositoryCustom {

    Page<PocketMoney> getPocketMoneyPage(PocketMoneyForm pocketMoneyForm, Pageable pageable);

}

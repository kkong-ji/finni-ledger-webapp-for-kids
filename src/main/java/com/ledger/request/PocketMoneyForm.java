package com.ledger.request;

import com.ledger.entity.PocketMoney;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

/**
 * 용돈 데이터 정보를 전달하는 DTO
 */

@Getter
@Setter
@NoArgsConstructor
public class PocketMoneyForm {

    private Long id;
    private String moneyCycle;
    private Integer moneyAmount;
    private String moneyCategory;
    public PocketMoney pocketMoney;

    @Builder
    public PocketMoneyForm(String moneyCycle, Integer moneyAmount, String moneyCategory) {
        this.moneyCycle = moneyCycle;
        this.moneyAmount = moneyAmount;
        this.moneyCategory = moneyCategory;
    }

    public PocketMoney toEntity() {
        return PocketMoney.builder()
                .moneyCycle(moneyCycle)
                .moneyAmount(moneyAmount)
                .moneyCategory(moneyCategory)
                .build();
    }
}

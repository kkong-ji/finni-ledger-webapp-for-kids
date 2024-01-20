package com.ledger.entity;

import com.ledger.request.PocketMoneyForm;
import lombok.*;
import javax.persistence.*;

/**
 * 용돈 관련 Entity
 * cf. 클래스명으로 용돈을 뜻하는 영어 'allowance' 를 고려해보았으나
 * 직관적이지 않아 'money' 로 하였습니다.
 * 더 좋은 아이디어가 있다면 제시해주세요!
 */

@Entity
@Table(name = "pocketMoney")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PocketMoney extends BaseEntity{

    @Id
    @Column(name = "pocket_money_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "pocketMoney")
    @JoinColumn(name = "member_id")
    private Member member;              // member (회원) 과 1:1 양방향 매핑을 하기 위함

    @Column(nullable = false)
    private String moneyCycle;          // 용돈 주기

    @Column(nullable = false)
    private Integer moneyAmount;      // 용돈 금액

    @Column(nullable = false)
    private String moneyCategory;    // 용돈 분류

    @Builder
    public PocketMoney(String moneyCycle, Integer moneyAmount, String moneyCategory) {
        this.moneyCycle = moneyCycle;
        this.moneyAmount = moneyAmount;
        this.moneyCategory = moneyCategory;
    }
    public static PocketMoney createPocketMoney(Member member, PocketMoneyForm pocketMoneyForm) {
        PocketMoney pocketMoney = new PocketMoney();
        pocketMoney.setMember(member);
        pocketMoney.setMoneyCycle(pocketMoneyForm.getMoneyCycle());
        pocketMoney.setMoneyAmount(pocketMoneyForm.getMoneyAmount());
        pocketMoney.setMoneyCategory(pocketMoneyForm.getMoneyCategory());
        return pocketMoney;
    }

}

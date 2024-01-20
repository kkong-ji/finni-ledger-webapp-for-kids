package com.ledger.controller;

import com.ledger.config.auth.dto.SessionUser;
import com.ledger.entity.Member;
import com.ledger.entity.PocketMoney;
import com.ledger.request.PocketMoneyForm;
import com.ledger.service.MemberService;
import com.ledger.service.PocketMoneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 사용자가 입력한 용돈에 관한 정보
 * 즉, 용돈 주기, 용돈 금액, 용돈 카테고리 정보를
 * service 단에 저장하기 위한 controller
 */
@Controller
@RequiredArgsConstructor
public class PocketMoneyController {

    private final PocketMoneyService pocketMoneyService;
    private final MemberService memberService;
    private final HttpSession httpSession;
    public PocketMoney pocketMoney;

    @GetMapping(value = "/PocketMoney")
    public String PocketMoney(Model model, @SessionAttribute("user") SessionUser user) {

        Member member = memberService.findByEmail(user.getEmail());
        pocketMoneyService.findById(member.getId());

        if (ObjectUtils.isEmpty(member)) {
            model.addAttribute("userPocketMoneyCycle", pocketMoney.getMoneyCycle());
            model.addAttribute("userPocketMoneyAmount", pocketMoney.getMoneyAmount());
            model.addAttribute("userPocketMoneyCategory", pocketMoney.getMoneyCategory());
            httpSession.setAttribute("userEmail", member.getEmail());
        }
        return "pocketmoney/pocketmoney-read";
    }

    @GetMapping(value = "/newPocketMoney")
    public String newPocketMoney(Model model) {
        model.addAttribute("PocketMoneyForm");
        return "pocketmoney/pocketmoney-new";
    }

    @PostMapping(value = "/newPocketMoney")
    @ResponseBody
    public ResponseEntity newPocketMoney(@RequestBody PocketMoneyForm pocketMoneyForm, BindingResult bindingResult, @SessionAttribute("user") SessionUser user) {

        Member member = memberService.findByEmail(user.getEmail());

        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }

        Long pocketMoney;

        try {
            pocketMoney = pocketMoneyService.newPocketMoney(pocketMoneyForm);
            System.out.println(member);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Long>(pocketMoney, HttpStatus.OK);
    }
}

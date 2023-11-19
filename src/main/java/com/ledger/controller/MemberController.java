package com.ledger.controller;

import com.ledger.config.auth.LoginUser;
import com.ledger.config.auth.dto.SessionMember;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/")
    public String login(Model model, @LoginUser SessionMember member) {

        if (member != null) {
            model.addAttribute("userName", member.getNickname());
        }
        return "login";
    }
}

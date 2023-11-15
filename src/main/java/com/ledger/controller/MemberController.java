package com.ledger.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/login")
    public String getLoginPage(){
        return "/login";
    }
}

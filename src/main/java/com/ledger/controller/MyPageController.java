package com.ledger.controller;

import com.ledger.config.auth.PrincipalDetails;
import com.ledger.config.auth.dto.SessionUser;
import com.ledger.constant.Profile;
import com.ledger.constant.Role;
import com.ledger.entity.Member;
import com.ledger.request.MemberForm;
import com.ledger.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final MemberService memberService;
    private final HttpSession httpSession;

    /*
     * 마이페이지 진입
     * */
    @GetMapping("/members/mypage")
    public String myPage(Model model, @SessionAttribute("user") SessionUser user,
                         PrincipalDetails principalDetails, MemberForm memberForm) {

        Member member = memberService.findByEmail(user.getEmail());

        if (member != null) {
            Long memberId = member.getId();
            memberForm.setNickName(member.getNickname());
            memberForm.setEmail(member.getEmail());
            model.addAttribute("memberForm", memberForm);
            model.addAttribute("profiles", Profile.values());
            httpSession.setAttribute("userEmail", member.getEmail());

            return "myPage";
        }
        return "index";
    }

    /*
     * 마이페이지 정보 업데이트
     */
    @PostMapping("/members/mypage")
    public String updateMyPage(@ModelAttribute MemberForm memberForm, @SessionAttribute("user") SessionUser user) {
        Member member = memberService.findByEmail(user.getEmail());

        if (member != null) {

            member.setNickname(memberForm.getNickName());
            member.setAge(memberForm.getAge());
            member.setProfile(memberForm.getProfile());
            member.setEmail(member.getEmail());

            member.setRole(Role.SOCIAL);

            memberService.update(member);
        }
        return "myPage";
    }

    @PostMapping("/members/delete")
    @ResponseBody
    public ResponseEntity<?> deleteMember(@SessionAttribute("user") SessionUser user) {
        try {
            Member member = memberService.findByEmail(user.getEmail());
            Long memberId = member.getId();

            memberService.deleteMember(memberId);
            System.out.println(member.getNickname() + " 탈퇴 처리 완료. memberId = " + memberId);

            return ResponseEntity.ok().build(); // 성공 응답
        } catch (Exception ex) {
            System.out.println("회원 탈퇴 중 에러 = " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 오류 응답
        }
    }

}



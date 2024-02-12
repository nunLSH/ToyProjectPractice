package smu.toyproject1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import smu.toyproject1.product.CreditLoan;
import smu.toyproject1.repository.JdbcDBConnection;
import smu.toyproject1.service.MemberService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final MemberService memberService;

    private JdbcDBConnection jdbcDBConnection;

    @Autowired
    public ProductController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    @GetMapping은 HTTP GET 요청이 해당 URL ("/members/new")로 들어왔을 때, 이를 처리하는 메소드
     */
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    // 보통 데이터를 등록할 때는 post, 조회할 때는 get
    // url은 위와 똑같지만 post 방식인 아래의 메소드가 선택이 됨.
//    @PostMapping("/members/new")
//    public String create(MemberForm form) {
//        Member member = new Member();
//        member.setName(form.getName());
//
//        memberService.join(member);
//
//        return "redirect:/";
//    }
    @GetMapping("/creditLoan")
    public String list(Model model) {
        List<CreditLoan> creditLoans = jdbcDBConnection.retrieveDataFromTable("신용대출");
        model.addAttribute("members", creditLoans);
        return "members/memberList";
    }
}

package smu.toyproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import smu.toyproject1.entity.CreditLoanProduct;
import smu.toyproject1.repository.JdbcDBConnection;
//import smu.toyproject1.service.MemberService;

import java.util.List;

@Controller
public class ProductController {

    private JdbcDBConnection jdbcDBConnection;

    /*
    @GetMapping은 HTTP GET 요청이 해당 URL ("/creditLoan")로 들어왔을 때, 이를 처리하는 메소드
    보통 데이터를 등록할 때는 post, 조회할 때는 get
     */

    // 신용대출 상품 목록
    @GetMapping("/creditLoan")
    public String list(Model model) {
        List<CreditLoanProduct> creditLoans = jdbcDBConnection.retrieveDataFromTable("신용대출");
        model.addAttribute("members", creditLoans);
        return "products/creditLoanProductsList";
    }

    // 정기예금 상품 목록
//    @GetMapping("/fixedDeposit")
//    public String list(Model model) {
//
//    }

}

package nvb.dev.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping(path = "/myLoan")
    public String getLoanDetails() {
        return "Here are the loan details from the DB!";
    }

}

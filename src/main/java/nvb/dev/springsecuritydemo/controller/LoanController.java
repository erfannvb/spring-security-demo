package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @GetMapping(path = "/myLoans")
    public ResponseEntity<?> getLoanDetails(@RequestParam long id) {
        return ResponseEntity
                .ok(loanService.getByCustomerIdOrderByStartDtDesc(id));
    }

}

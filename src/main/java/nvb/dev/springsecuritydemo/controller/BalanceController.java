package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.service.BalanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping(path = "/myBalance")
    public ResponseEntity<?> getBalanceDetails(@RequestParam long id) {
        return ResponseEntity
                .ok(balanceService.getByCustomerIdOrderByTransactionDtDesc(id));
    }

}

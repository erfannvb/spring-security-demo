package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping(path = "/myCards")
    public ResponseEntity<?> getCardDetails(@RequestParam long id) {
        return ResponseEntity
                .ok(cardService.getByCustomerId(id));
    }

}

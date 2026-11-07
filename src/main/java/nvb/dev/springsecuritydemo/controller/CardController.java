package nvb.dev.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping(path = "/myCard")
    public String getCardDetails() {
        return "Here are the card details from the DB!";
    }

}

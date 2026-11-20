package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.ContactEntity;
import nvb.dev.springsecuritydemo.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping(path = "/contact")
    public ResponseEntity<?> saveContactInquiryDetails(@RequestBody ContactEntity contact) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactService.saveContactInquiryDetails(contact));
    }

}

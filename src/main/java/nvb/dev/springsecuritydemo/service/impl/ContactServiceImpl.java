package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.CardsEntity;
import nvb.dev.springsecuritydemo.model.ContactEntity;
import nvb.dev.springsecuritydemo.repository.ContactRepository;
import nvb.dev.springsecuritydemo.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Override
    public ContactEntity saveContactInquiryDetails(ContactEntity contact) {
        contact.setContactId(getServiceReqNumber());
        contact.setCreateDt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR" + ranNum;
    }
}

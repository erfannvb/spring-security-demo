package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.ContactEntity;

public interface ContactService {

    ContactEntity saveContactInquiryDetails(ContactEntity contact);

}

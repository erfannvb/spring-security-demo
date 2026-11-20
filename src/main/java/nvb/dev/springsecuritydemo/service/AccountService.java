package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.AccountsEntity;

public interface AccountService {

    AccountsEntity getByCustomerId(long id);

}

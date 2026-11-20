package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.AccountsEntity;
import nvb.dev.springsecuritydemo.repository.AccountsRepository;
import nvb.dev.springsecuritydemo.service.AccountService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    @Override
    public AccountsEntity getByCustomerId(long id) {
        return accountsRepository.findByCustomerId(id);
    }
}

package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.AccountTransactionsEntity;
import nvb.dev.springsecuritydemo.repository.AccountTransactionsRepository;
import nvb.dev.springsecuritydemo.service.BalanceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @Override
    public List<AccountTransactionsEntity> getByCustomerIdOrderByTransactionDtDesc(long id) {
        return accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);
    }
}

package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.AccountTransactionsEntity;

import java.util.List;

public interface BalanceService {

    List<AccountTransactionsEntity> getByCustomerIdOrderByTransactionDtDesc(long id);

}

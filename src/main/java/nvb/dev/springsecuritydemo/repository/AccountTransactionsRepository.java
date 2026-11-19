package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.AccountTransactionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionsRepository extends CrudRepository<AccountTransactionsEntity, String> {

    List<AccountTransactionsEntity> findByCustomerIdOrderByTransactionDtDesc(long customerId);

}

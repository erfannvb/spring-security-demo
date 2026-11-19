package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.AccountsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<AccountsEntity, Long> {

    AccountsEntity findByCustomerId(long customerId);

}

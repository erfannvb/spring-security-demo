package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.LoansEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoansRepository extends CrudRepository<LoansEntity, Long> {

    List<LoansEntity> findByCustomerIdOrderByStartDtDesc(long customerId);

}

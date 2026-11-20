package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.LoansEntity;

import java.util.List;

public interface LoanService {

    List<LoansEntity> getByCustomerIdOrderByStartDtDesc(long customerId);

}

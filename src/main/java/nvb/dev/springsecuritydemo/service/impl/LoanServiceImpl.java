package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.LoansEntity;
import nvb.dev.springsecuritydemo.repository.LoansRepository;
import nvb.dev.springsecuritydemo.service.LoanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoansRepository loansRepository;

    @Override
    public List<LoansEntity> getByCustomerIdOrderByStartDtDesc(long customerId) {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customerId);
    }
}

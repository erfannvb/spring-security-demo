package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.CardsEntity;
import nvb.dev.springsecuritydemo.repository.CardsRepository;
import nvb.dev.springsecuritydemo.service.CardService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardsRepository cardsRepository;

    @Override
    public List<CardsEntity> getByCustomerId(long id) {
        return cardsRepository.findByCustomerId(id);
    }
}

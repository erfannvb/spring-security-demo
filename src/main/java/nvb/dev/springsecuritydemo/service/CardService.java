package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.CardsEntity;

import java.util.List;

public interface CardService {

    List<CardsEntity> getByCustomerId(long id);

}

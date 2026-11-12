package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

}

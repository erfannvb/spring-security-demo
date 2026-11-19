package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.ContactEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, String> {
}

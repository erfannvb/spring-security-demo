package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.AuthLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthLogRepository extends JpaRepository<AuthLogEntity, Long> {
}

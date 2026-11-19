package nvb.dev.springsecuritydemo.repository;

import nvb.dev.springsecuritydemo.model.NoticeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<NoticeEntity, Long> {

    @Query(value = "from NoticeEntity n where CURDATE() BETWEEN noticeBegDt AND noticeEndDt")
    List<NoticeEntity> findAllActiveNotices();

}

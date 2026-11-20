package nvb.dev.springsecuritydemo.service;

import nvb.dev.springsecuritydemo.model.NoticeEntity;

import java.util.List;

public interface NoticeService {

    List<NoticeEntity> getAllActiveNotices();

}

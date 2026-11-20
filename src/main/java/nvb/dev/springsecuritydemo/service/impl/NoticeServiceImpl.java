package nvb.dev.springsecuritydemo.service.impl;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.NoticeEntity;
import nvb.dev.springsecuritydemo.repository.NoticeRepository;
import nvb.dev.springsecuritydemo.service.NoticeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    @Override
    public List<NoticeEntity> getAllActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}

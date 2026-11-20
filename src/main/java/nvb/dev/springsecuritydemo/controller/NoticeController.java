package nvb.dev.springsecuritydemo.controller;

import lombok.RequiredArgsConstructor;
import nvb.dev.springsecuritydemo.model.NoticeEntity;
import nvb.dev.springsecuritydemo.service.NoticeService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping(path = "/notices")
    public ResponseEntity<?> getNotices() {
        List<NoticeEntity> notices = noticeService.getAllActiveNotices();
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(notices);
    }

}

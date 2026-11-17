package nvb.dev.springsecuritydemo.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nvb.dev.springsecuritydemo.model.AuthLogEntity;
import nvb.dev.springsecuritydemo.model.EventType;
import nvb.dev.springsecuritydemo.repository.AuthLogRepository;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthenticationEvents {

    private final AuthLogRepository authLogRepository;

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        String username = successEvent.getAuthentication().getName();

        AuthLogEntity authLog = AuthLogEntity.builder()
                .username(username)
                .eventType(EventType.LOGIN_SUCCESS)
                .timestamp(LocalDateTime.now())
                .build();

        authLogRepository.save(authLog);

        log.info("Login successful for the user: {}", username);
    }

    @EventListener
    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        String username = failureEvent.getAuthentication().getName();

        AuthLogEntity authLog = AuthLogEntity.builder()
                .username(username)
                .eventType(EventType.LOGIN_FAILURE)
                .timestamp(LocalDateTime.now())
                .build();

        authLogRepository.save(authLog);

        log.error("Login failed for the user: {}, due to: {}",
                username,
                failureEvent.getException().getMessage());
    }

}

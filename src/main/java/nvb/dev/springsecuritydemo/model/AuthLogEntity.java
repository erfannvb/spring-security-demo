package nvb.dev.springsecuritydemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Enumerated(value = EnumType.STRING)
    private EventType eventType;

    private LocalDateTime timestamp;

}

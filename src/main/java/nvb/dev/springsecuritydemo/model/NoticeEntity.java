package nvb.dev.springsecuritydemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "notice_details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private int noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notice_beg_dt")
    private LocalDate noticeBegDt;

    @Column(name = "notice_end_dt")
    private LocalDate noticeEndDt;

    @JsonIgnore
    @Column(name = "create_dt")
    private LocalDate createDt;

    @JsonIgnore
    @Column(name = "update_dt")
    private LocalDate updateDt;

}

package nvb.dev.springsecuritydemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "account_transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountTransactionsEntity {

    @Id
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "transaction_dt")
    private LocalDate transactionDt;

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "transaction_amt")
    private int transactionAmt;

    @Column(name = "closing_balance")
    private int closingBalance;

    @Column(name = "create_dt")
    private LocalDate createDt;

}

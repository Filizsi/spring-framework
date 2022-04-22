package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_details_id")
    private PaymentDetail paymentDetail;

    //one to many is not good cascading
    @ManyToOne
    private Merchant merchant;

    @ManyToOne
    private Customer customer;

    public Payment( BigDecimal amount,LocalDate createdDate, Status paymentStatus) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.paymentStatus = paymentStatus;
    }
}

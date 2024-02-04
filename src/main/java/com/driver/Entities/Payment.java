package com.driver.Entities;

import com.driver.model.PaymentMode;

import javax.persistence.*;

@Entity
@Table(name = "payment_info")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean paymentCompleted;
    @Enumerated(value = EnumType.STRING)
    private PaymentMode paymentMode;

    @JoinColumn
    @OneToOne
    private Reservation reservation;

    public Payment() {
    }

    public Payment(Boolean paymentCompleted, PaymentMode paymentMode, Reservation reservation) {
        this.paymentCompleted=paymentCompleted;
        this.paymentMode = paymentMode;
        this.reservation = reservation;
    }
}

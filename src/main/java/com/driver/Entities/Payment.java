package com.driver.Entities;

import javax.persistence.*;

@Entity
@Table(name = "payment_info")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Boolean paymentMode;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Reservation reservation;

}

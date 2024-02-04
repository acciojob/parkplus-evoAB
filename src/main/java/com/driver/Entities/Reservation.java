package com.driver.Entities;

import javax.persistence.*;

@Entity
@Table(name = "reservation_info")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer numberOfHours;

    @JoinColumn
    @ManyToOne
    private User user;

    @JoinColumn
    @ManyToOne
    private Spot spot;

    @JoinColumn
    @OneToOne
    private Payment payment;

    public Reservation() {
    }

    public Reservation(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public void setNumberOfHours(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumberOfHours() {
        return numberOfHours;
    }

    public User getUser() {
        return user;
    }

    public Spot getSpot() {
        return spot;
    }

    public Payment getPayment() {
        return payment;
    }
}

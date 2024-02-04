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

    @OneToOne(mappedBy = "reservation",cascade = CascadeType.ALL)
    private Payment payment;

    public Reservation() {
    }

    public Reservation(Integer numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public Reservation(Integer numberOfHours, User user, Spot spot) {
        this.numberOfHours = numberOfHours;
        this.user = user;
        this.spot = spot;
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

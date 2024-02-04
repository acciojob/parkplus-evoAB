package com.driver.model;

import com.driver.model.ParkingLot;
import com.driver.model.Reservation;
import com.driver.model.SpotType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "spot_info")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private SpotType spotType;

    private Integer pricePerHour;

    private Boolean occupied;

    @JoinColumn
    @ManyToOne
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "spot", cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

    public Spot(SpotType spotType, Integer pricePerHour, Boolean occupied, ParkingLot parkingLot) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied = occupied;
        this.parkingLot = parkingLot;
    }

    public Spot() {
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public void setPricePerHour(Integer pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public Integer getId() {
        return id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Integer getPricePerHour() {
        return pricePerHour;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }
}

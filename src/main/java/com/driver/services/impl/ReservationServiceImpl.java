package com.driver.services.impl;

import com.driver.model.ParkingLot;
import com.driver.model.Reservation;
import com.driver.model.Spot;
import com.driver.model.User;
import com.driver.model.*;
import com.driver.repository.ParkingLotRepository;
import com.driver.repository.ReservationRepository;
import com.driver.repository.SpotRepository;
import com.driver.repository.UserRepository;
import com.driver.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    UserRepository userRepository3;
    @Autowired
    SpotRepository spotRepository3;
    @Autowired
    ReservationRepository reservationRepository3;
    @Autowired
    ParkingLotRepository parkingLotRepository3;
    @Override
    public Reservation reserveSpot(Integer userId, Integer parkingLotId, Integer timeInHours, Integer numberOfWheels) throws Exception {
        User user;
        ParkingLot parkingLot;
        try{
            user = userRepository3.findById(userId).get();
            parkingLot = parkingLotRepository3.findById(parkingLotId).get();
        }catch(Exception e){
            throw new Exception("Cannot make reservation");
        }
        SpotType spotType = null;
        if (numberOfWheels<=2)
            spotType=SpotType.TWO_WHEELER;
        else if (numberOfWheels<=4) {
            spotType=SpotType.FOUR_WHEELER;
        }
        else
            spotType=SpotType.OTHERS;

        Spot unreservedSpot=null;
        int minCost = Integer.MAX_VALUE;
        List<Spot> spotList = parkingLot.getSpotList();
        for (Spot spot : spotList){
            if(!spot.getOccupied() && spot.getSpotType()==spotType && minCost>timeInHours*spot.getPricePerHour()){
                unreservedSpot = spot;
                minCost=timeInHours*spot.getPricePerHour();
            }
        }
        if(unreservedSpot == null){
            throw new Exception("Cannot make reservation");
        }
        Reservation reservation = new Reservation(timeInHours, user, unreservedSpot);

        user.getReservationList().add(reservation);
        unreservedSpot.getReservationList().add(reservation);
        unreservedSpot.setOccupied(true);

        userRepository3.save(user);
        spotRepository3.save(unreservedSpot);
        return reservation;
    }
}

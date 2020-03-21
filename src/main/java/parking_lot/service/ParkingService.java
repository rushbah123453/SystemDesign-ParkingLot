package parking_lot.service;

import parking_lot.exception.ParkingException;
import parking_lot.model.Car;

public interface ParkingService {


    public void parkMyCar(Car car) throws ParkingException;

    public void removeMyCar(String registrationNumber, Integer timeParked) throws ParkingException;

    public int parkingCharge(int timeParked);

    public void getStatus();


}

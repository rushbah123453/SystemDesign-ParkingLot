package parking_lot.controller;

import parking_lot.constant.Constants;
import parking_lot.exception.ErrorCode;
import parking_lot.exception.ParkingException;
import parking_lot.model.Car;
import parking_lot.service.ParkingServiceImpl;

public class ParkingHandlerMapping {
    ParkingServiceImpl parkingService = new ParkingServiceImpl();
    public void execute(String input) throws Exception {
        String[] inputs = input.split(" ");
        String key = inputs[0];
        switch (key) {
            case Constants.CREATE_PARKING_LOT:
                try {
                    int capacity = Integer.parseInt(inputs[1]);
                    parkingService.setParkingSlot(capacity);
                } catch (NumberFormatException e) {
                    throw new ParkingException(ErrorCode.INVALID_VALUE.getMessage().replace("{variable}", "capacity"));
                } catch (ParkingException p) {
                    throw p;
                }
                break;
            case Constants.PARK:
                parkingService.parkMyCar(new Car(inputs[1], inputs[2]));
                break;
            case Constants.LEAVE:
                try {
                    int timeVehicleParked = Integer.parseInt(inputs[2]);
                    parkingService.removeMyCar(inputs[1], timeVehicleParked);

                } catch (NumberFormatException e) {
                    throw new ParkingException(ErrorCode.INVALID_VALUE.getMessage().replace("{variable}", "Time"));
                }
                break;
            case Constants.STATUS:
                parkingService.getStatus();
                break;
            case Constants.REG_NUMBER_FOR_CARS_WITH_COLOR:
                break;
            case Constants.SLOTS_NUMBER_FOR_CARS_WITH_COLOR:
                break;
            case Constants.SLOTS_NUMBER_FOR_REG_NUMBER:
                break;
            default:
                break;
        }

    }
}

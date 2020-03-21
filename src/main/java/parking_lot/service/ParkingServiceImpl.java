package parking_lot.service;

import parking_lot.constant.Constants;
import parking_lot.dao.ParkingDao;
import parking_lot.exception.ErrorCode;
import parking_lot.exception.ParkingException;
import parking_lot.model.Car;



public class ParkingServiceImpl implements ParkingService {

    private int slotSize;
    ParkingDao parkingQuery=new ParkingDao();

    public int getSlotSize() {
        return slotSize;
    }

    public void setParkingSlot(int slotSize) throws ParkingException {
        if(slotSize<=Constants.NON_VALID_PARKING_SIZE)
        {
            System.out.println("Parking Slots cannot be zero or Negative, Please Enter valid Size");
            return;
        }
        if (getSlotSize()==Constants.PARKING_SLOT_EMPTY){
            this.slotSize=slotSize;
            parkingQuery.setSlotSize(slotSize);
            System.out.println("Created parking lot with "+slotSize+" slots");
        }else {
            throw new ParkingException(ErrorCode.SLOT_ALREADY_EXISTS.getMessage());
        }

    }

    public int  getTotalAvailableParkingSize(){
        return getSlotSize()-parkingQuery.getVehicleEntrySize();
    }

    public void parkMyCar(Car car) throws ParkingException {
        try {
            if (getTotalAvailableParkingSize() > Constants.PARKING_SLOT_EMPTY) {
                int slotNumber = getSlotNumber();
                parkingQuery.addVehicleEntry(slotNumber, car);
                System.out.println("Allocated slot number: "+slotNumber);
            } else if (getSlotSize()==Constants.PARKING_SLOT_EMPTY){
                System.out.println("Sorry, No Parking Slot Allocatted .Please Create Parking Lot");
            }else {
                System.out.println("Sorry, parking lot is full");
            }
        } catch (ParkingException e){
            throw e;
        } catch (Exception e){
            throw new ParkingException(ErrorCode.PROCESSING_ERROR.getMessage());
        }
    }
    public void removeMyCar(String registrationNumber, Integer timeParked) throws ParkingException {
        try {
          int slotNumber= parkingQuery.removeVehicle(registrationNumber);
          int parkingCharge = parkingCharge(timeParked);
          System.out.println("Registration number "+registrationNumber +" with Slot Number "+slotNumber+" is free with Charge " + parkingCharge);
        } catch(ParkingException p){
            throw p;
        } catch (Exception e){
            throw new ParkingException(ErrorCode.PROCESSING_ERROR.getMessage());
        }
    }

    public int parkingCharge(int timeParked) throws OutOfMemoryError{
        return timeParked>2?(10+10*(timeParked-2)):10;
    }

    public void getStatus() {
        parkingQuery.getParkingStatus();
    }

    public Integer getSlotNumber() {
        return parkingQuery.getSlotNumber();
    }
}

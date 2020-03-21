package parking_lot.dao;

import parking_lot.constant.Constants;
import parking_lot.exception.ErrorCode;
import parking_lot.exception.ParkingException;
import parking_lot.model.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingDao {

    private HashMap<Integer, Car> vehicleEntry=new HashMap<Integer, Car>();
    private int slotSize;

   public void addVehicleEntry(int slotNumber, Car car) throws ParkingException {
        if (findSlotFromRegistrationNumber(car.getRegistrationNumber())== Constants.NOT_AVAILABLE)
        vehicleEntry.put(slotNumber,car);
        else
            throw new ParkingException(ErrorCode.PARKING_ALREADY_EXIST.getMessage());
   }
    public int removeVehicle(String registrationNumber) throws ParkingException {
       if (findSlotFromRegistrationNumber(registrationNumber)!=Constants.NOT_FOUND){
            int slotNumber = findSlotFromRegistrationNumber(registrationNumber);
            vehicleEntry.remove(slotNumber);
            return slotNumber;
        }
        else
            throw new ParkingException(ErrorCode.PARKING_NOT_EXIST_ERROR.getMessage());
    }

    public Integer getSlotNumber() {
        Integer slotNumber = Constants.NOT_FOUND;
        for (int i=1;i<=slotSize;i++){
            if(!vehicleEntry.containsKey(i)){
                slotNumber= i;
                break;
            }
        }
        return slotNumber;
    }

    public void getParkingStatus() {
       if (vehicleEntry.keySet().size()==Constants.EMPTY){
           System.out.println("No Car Parked, Please Park and check the Status");
           return;
       }

        System.out.println("Slot No.\t\tRegistration No.\t\t\t\tColor");
        for (Integer index: vehicleEntry.keySet()){
            String slotNumber = index.toString();
            String registrationNumber = vehicleEntry.get(index).getRegistrationNumber().toString();
            String colour = vehicleEntry.get(index).getColour().toString();
            System.out.println(slotNumber+"\t\t\t"+registrationNumber+"\t\t\t\t\t"+colour);
        }
    }

    public int findSlotFromRegistrationNumber(String registrationNumber) {
        int slotNumber=Constants.NOT_FOUND;
        for (Map.Entry<Integer, Car> entry : vehicleEntry.entrySet()) {
            String compare=entry.getValue().getRegistrationNumber();
            if (registrationNumber.equals(compare)) {
                slotNumber= entry.getKey();
                break;
            }
        }
        return slotNumber;
    }

    public int getVehicleEntrySize() {
       return vehicleEntry.size();
    }

    public void setSlotSize(int slotSize) {
        this.slotSize=slotSize;
    }
}

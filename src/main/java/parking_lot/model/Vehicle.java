package parking_lot.model;

public abstract class Vehicle {

    private String registrationNumber;
    private String colour;

    public Vehicle(String registrationNumber, String colour) {
        this.registrationNumber = registrationNumber;
        this.colour = colour;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}

package parking_lot.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import parking_lot.dao.ParkingDao;
import parking_lot.exception.ParkingException;
import parking_lot.model.Car;
import parking_lot.model.Vehicle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ParkingServiceImplTest {

    private final ByteArrayOutputStream outContent	= new ByteArrayOutputStream();

    private int slotSize;

    private  ParkingServiceImpl parkingService;

    @Before
    public void setUp() throws Exception {
    }

    @Before
    public void init()
    {
         parkingService = new ParkingServiceImpl();
        System.setOut(new PrintStream(outContent));
    }



    @Test
    public void setParkingSlotPositive() throws ParkingException {
        parkingService.setParkingSlot(3);
        assertTrue("Created parking lot with 3 slots".equalsIgnoreCase(outContent.toString().trim()));
    }

    @Test
    public void setParkingSlotNegativeSlotSize() throws ParkingException {
        parkingService.setParkingSlot(-1);
        assertTrue("Parking Slots cannot be zero or Negative, Please Enter valid Size".equalsIgnoreCase(outContent.toString().trim()));
    }


    @Test
    public void parkMyCarNegative() throws ParkingException {
        Car car=new Car("MH12-GH-4301","Blue" );
        parkingService.parkMyCar(car);
    }

    @Test(expected = ParkingException.class)
    public void removeMyCarNegative() throws ParkingException {
        parkingService.removeMyCar("nocar",1);
        assertTrue(("Sorry, Car Parking Does not Exist").equalsIgnoreCase(outContent.toString().trim()));

    }


    @Test
    public void getStatusNegative() {
        parkingService.getStatus();
        assertTrue(("No Car Parked, Please Park and check the Status").equalsIgnoreCase(outContent.toString().trim()));
    }


}
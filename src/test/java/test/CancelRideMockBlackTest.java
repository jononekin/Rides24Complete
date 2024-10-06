package test;

import domain.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dataAccess.DataAccess;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CancelRideMockBlackTest {
	
	@Mock
	private Driver driver;
	
	private Ride ride;
	private Date data;
	private DataAccess sut = new DataAccess();
	
	   @Before
	    public void setUp() {
	        MockitoAnnotations.openMocks(this); // Inicializa los mocks
	        ride = new Ride("Californi", "Cation", data, 123, 14,driver); // Inyecta el mock en Servicio
	    }

	@Test
	public void testCancelRide() {
		try{
			ride = null;
			sut.cancelRide(ride);
			
		}catch (NullPointerException e) {
			System.out.println("NullPointerException jaso da, berez ondo dago!");

		}	catch(Exception e) {
			System.out.println("Hey");
			fail();
		}
		
		fail("Not yet implemented");
	}
	
    public void testCancelRide_rideIsNull() throws Exception {
        sut.cancelRide(null);
    }

}

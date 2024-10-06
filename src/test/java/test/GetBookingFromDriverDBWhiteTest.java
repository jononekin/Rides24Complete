package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Booking;
import domain.Driver;
import domain.Ride;
import testOperations.TestDataAccess;

public class GetBookingFromDriverDBWhiteTest {
	
	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
//	 static TestDataAccess testDA;

	@SuppressWarnings("unused")
	private Driver driver; 
	
    @Before
    public void setUp() {
    	//testDA=new TestDataAccess();
    	
		
	}
    // Test Case 1: Excepción lanzada (NULL input)
    @Test
    public void test1() {
    	sut.open();
    	List<Booking> result = sut.getBookingFromDriver(null);
        assertEquals(null, result); 
        sut.close();
    }
    

    // Test Case 2: Usuario sin rides ("Bob Esponja" - no rides found)
    @Test
    public void test2() {
    	sut.open();
        List<Booking> result = sut.getBookingFromDriver("Bob Esponja");
        
 //       assertEquals(0, result.size());
        sut.close();
    }

    // Test Case 3: Ride exists but is not active ("Jon" - no active rides)
    @Test
    public void test3() {
    	sut.open();
        List<Booking> result = sut.getBookingFromDriver("Urtzi");
        assertEquals(null, result); // No hay bookings porque la ride no está activa
        sut.close();
    }

    // Test Case 4: Ride exists and is active ("Mikel" - active ride)
    @Test
    public void test4() {
    	sut.open();

        List<Booking> result = sut.getBookingFromDriver("Unax");

        assertEquals(1, result.size()); // Debería haber un booking
        sut.close();
    }

}

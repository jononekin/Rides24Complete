package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import data_access.DataAccess;
import domain.Booking;
import domain.Driver;
import domain.Ride;
import domain.Traveler;

public class GetBookingFromDriverDBBlackTest {
		private Date data = new Date();
		private Driver driver = new Driver("Unax", "you");
		private Ride ride = new Ride("Californi", "Cation", data, 123, 14, driver);
		private Traveler traveler = new Traveler("tre", "st");
		private Booking book = new Booking(ride, traveler, 3);
		
		 //sut:system under test
		 static DataAccess sut=new DataAccess();
		 
		 
    // Test Case 1: Excepci�n lanzada (NULL input)
    @Test
    public void test1() {
    	try {
    		sut.open();
    		List<Booking> result = sut.getBookingFromDriver(null);
    		assertEquals(null, result);
    	}finally{
    		sut.close();
    	}
    }
    
    
    // Test Case 4: Ride exists and is active ("Mikel" - active ride)
    @Test
    public void test3() {
    	sut.open();
    	ride.isActive();
        List<Booking> result = sut.getBookingFromDriver("Unax");
        System.out.println(result.size());
        assertEquals(1, result.size());
        sut.close();
    }
}

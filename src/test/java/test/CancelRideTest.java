package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import dataAccess.DataAccess;
import domain.Ride;
import testOperations.TestDataAccess;

public class CancelRideTest {
	private Ride ride;
	static DataAccess sut=new DataAccess();
	
	//additional operations needed to execute the test 
		 static TestDataAccess testDA=new TestDataAccess();
		 
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void nullTest() {
		try {
			//define parameters
			ride=null;
			
			sut.open();
			sut.cancelRide(ride);

		   } catch (NullPointerException e) {
				System.out.println("NullPointerException jaso da, berez ondo dago!");

			}	catch(Exception e) {
				fail();
		}
		finally {
			sut.close();
		}
	}

	@Test
	public void yesDBnullTest() {
		try {
			ArrayList<String> array = new ArrayList<String>();
			array.add("3");
			ride.setBookings(array);
			
			//define parameters
			
			sut.open();
			sut.cancelRide(ride);

		   } catch (NullPointerException e) {
				System.out.println("NullPointerException jaso da, berez ondo dago!");

			}	catch(Exception e) {
				System.out.println("true?");
				fail();
			}
			finally {
				sut.close();
			}
	}

	@Test
	public void testUpdateAlertaAurkituak() {
		fail("Not yet implemented");
	}
	
}

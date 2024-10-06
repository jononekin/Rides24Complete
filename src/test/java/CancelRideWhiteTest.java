import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataAccess.DataAccess;
import domain.Driver;
import domain.Ride;
import domain.Traveler;
import exceptions.RideAlreadyExistException;
import exceptions.RideMustBeLaterThanTodayException;

public class CancelRideWhiteTest {
	//sut:system under test
		 static DataAccess sut=new DataAccess();
		 
		 //additional operations needed to execute the test 

		@SuppressWarnings("unused")
		private Ride ride;
		
		public void test1() {
			
				try {
					
					//define parameters
					ride=null;
					
					sut.cancelRide(ride);
					
				   } catch (Exception e) {
						System.out.println("Ondo frogatu da!");
						
					} finally {
						sut.close();
					}
			}
}

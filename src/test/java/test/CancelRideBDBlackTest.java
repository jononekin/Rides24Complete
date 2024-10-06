package test; 

import domain.*;
import testOperations.TestDataAccess;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dataAccess.DataAccess;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CancelRideBDBlackTest {
	private Date data = new Date();
	private Driver driver = new Driver("Hey", "you");
	private Ride ride = new Ride("Californi", "Cation", data, 123, 14, driver);
	private Traveler traveler = new Traveler("tre", "st");
	static DataAccess sut=new DataAccess();
	private Booking book = new Booking(ride, traveler, 3);
	//additional operations needed to execute the test 
		 static TestDataAccess testDA=new TestDataAccess();
		 
	@Before
	public void setUp() throws Exception {
	}

	@Test
	//Metodoan sartzen zen parametroa Null baldin bada
	public void test1() {
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
	//Metodoan sartzen den parametroaren Booking lista gaizki sortuta egotea
	public void test2() {
		try {
			ArrayList<String> array = new ArrayList<String>();
			array.add("3");
			//Ezin dugu frogatu parametro mota desberdinak sartzen direnean, baina gaizki gertatzen denez ondo joan da.
			ride.setBookings(array);
			
			//define parameters
			
			sut.open();
			sut.cancelRide(ride);

		} catch(Exception e) {
			System.out.println("true?");
		}
		finally {
			sut.close();
		}
	}

	@Test
	//Booking lista elementurik ez izatea
	public void test3() {
		try {
			
			List<Booking> bookList = new ArrayList<>();
			ride.setBookings(bookList);
			
			//define parameters
			
			sut.open();
			sut.cancelRide(ride);

		   } catch (NullPointerException e) {
				fail();

			}	catch(Exception e) {
				fail();
			}
			finally {
				sut.close();
			}
	}
	
	@Test
	//Ondo sortuta egotea eta "Accepted" egoera bezala izatea Booking-a
	public void test4() {
		try {
			
			List<Booking> bookList = new ArrayList<>();
			bookList.add(book);
			book.setStatus("Accepted");
			ride.setBookings(bookList);
			
			//define parameters
			
			sut.open();
			sut.cancelRide(ride);

		   } catch (NullPointerException e) {
				fail();

			}	catch(Exception e) {
				fail();
			}
			finally {
				sut.close();
			}
	}
}
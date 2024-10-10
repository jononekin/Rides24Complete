package test; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data_access.DataAccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import domain.Booking;
import domain.Ride;
import domain.Traveler;
import domain.Driver;
import testOperations.TestDataAccess;

public class CancelRideBDWhiteTest {
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
	
	//Datu-basea hasieratzea baina booklist gaizki egotea
	@Test
	public void test1() {
		try {
			ArrayList<String> array = new ArrayList<String>();
			array.add("3");
			//Ezin dugu frogatu parametro mota desberdinak sartzen direnean, baina gaizkzi gertatzen denez ondo joan da.
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
	
	//Null parametro ematea metodoan
	@Test
	public void test2() {
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
	
	
	//Booklist "Accepted" kasuetan ondo funtzionatzen duela frogatu nahi da
	@Test
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
				System.out.println("NullPointerException jaso da, berez ondo dago!");
				fail();

			}	catch(Exception e) {
				System.out.println("true?");
				fail();
			}
			finally {
				sut.close();
			}
	}
	
	//Booklist "Denied" kasuetan ondo funtzionatzen duela frogatu nahi da
	@Test
	public void test5() {
		try {
			
			List<Booking> bookList = new ArrayList<>();
			bookList.add(book);
			book.setStatus("Denied");
			ride.setBookings(bookList);
			
			//define parameters
			
			sut.open();
			sut.cancelRide(ride);

		   } catch (NullPointerException e) {
				System.out.println("NullPointerException jaso da, berez ondo dago!");
				fail();

			}	catch(Exception e) {
				System.out.println("true?");
				fail();
			}
			finally {
				sut.close();
			}
	}
}

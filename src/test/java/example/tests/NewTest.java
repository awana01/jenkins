package example.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

	@BeforeTest
	public void beforeTest() {
		System.out.println("Executing before test...");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Executing after test...");
	}

	@Test
	public void test1() {
		System.out.println("Executing test...");

	}

	@Test(description="date time strings")
	public void test2() {


		LocalDate localDate = LocalDate.now(); // Create a date object
		// Display the current date
		System.out.println("Showing Local System Date: "+localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("Showing Local System Time: "+localTime);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Showing Local System DateTime: "+localDateTime);

		DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate1 = localDateTime.format(myFormatObj1);
	    System.out.println("Format DateTime After formatting: " + formattedDate1);


	    DateTimeFormatter myFormatObj2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
	    String formattedDate2 = localDateTime.format(myFormatObj2);
	    System.out.println("Format DateTime After formatting: " + formattedDate2);


	    DateTimeFormatter myFormatObj3 = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
	    String formattedDate3 = localDateTime.format(myFormatObj3);
	    System.out.println("Format DateTime After formatting: " + formattedDate3);

	    LocalDate myAnotherDay = LocalDate.of(1983, 8, 14);
	    System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(myAnotherDay));

	    String timeColonPattern = "hh:mm:ss a";
	    DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
	    LocalTime colonTime = LocalTime.now();
	    System.out.println(timeColonFormatter.format(colonTime));

	}









}

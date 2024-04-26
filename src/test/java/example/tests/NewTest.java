package example.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

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
	public void f() {
		System.out.println("Executing test...");
	}

}

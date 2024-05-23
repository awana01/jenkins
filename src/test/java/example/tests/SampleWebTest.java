package example.tests;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SampleWebTest 
{
  WebDriver driver;
	
	
	
    
    @BeforeTest()
    public void before()
    {
      	ChromeOptions options = new ChromeOptions();

    	options.addArguments("--test-type");
    	options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

    	driver = new ChromeDriver(options);
    	driver.get("https://www.google.com/");
        System.out.println("BeforeTest Executing");
    }
    
    
    @AfterTest()
    public void after() {
    	driver.quit();
    }
    
    @Test(invocationCount=1)
    public void test01() throws InterruptedException
    {
    	
    	List<String> givenList = Arrays.asList("Selenium Jenkins pipeline","selenium java azure pipeline","cucumber jenkins pipeline","selenium git allure result");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
    	
    	
    	System.out.println("Test1 executing");
    	
    	WebElement searchbox = driver.findElement(By.name("q"));
    	
    	searchbox.clear();
    	searchbox.sendKeys(randomElement+"\n");
    	Thread.sleep(1500);
    	
    	driver.findElement(By.id("hdtb-tls")).click();
    	
    	Actions action = new Actions(driver);
    //	action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
    	
    	String result_stat = driver.findElement(By.cssSelector("div#result-stats")).getText();
    	System.out.println(String.format("Google Search for: '%s' Result found: %s",randomElement,result_stat));
    	
    	System.out.println("Execution done...");
    	
    	
    	
    }
    
    
    
    
    
    
    
}

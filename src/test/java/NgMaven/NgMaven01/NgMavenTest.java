package NgMaven.NgMaven01;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class NgMavenTest 
{
  WebDriver driver;
	
	
	
    
    @BeforeTest()
    public void before()
    {
    	//System.setProperty("chrome.webdriver.driver","E:/Selenium-3.6/chrome-78/chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--test-type");
    	
    	driver = new ChromeDriver(options);
    	driver.get("https://www.google.com/");
    	
    	
        System.out.println("BeforeTest Executing");
    }
    
    
    @AfterTest()
    public void after() throws InterruptedException
    {
    	//driver.close();
    }
    
    @Test()
    public void test01() throws InterruptedException
    {
    	System.out.println("Main Test1 executing");
    	
    	System.out.println("After Test Executiing");
    	WebElement searchbox = driver.findElement(By.name("q"));
    	searchbox.sendKeys("maven project in jenkins");
    	searchbox.sendKeys(Keys.ESCAPE);
    	Thread.sleep(2500);
    	driver.findElement(By.cssSelector("img#hplogo")).click();
    	
    	Actions action = new Actions(driver);
//    	action.keyDown(Keys.ESCAPE).keyUp(Keys.ESCAPE).build().perform();
    	
    	Thread.sleep(2500);
    	driver.findElement(By.name("btnK")).click();	
    	
    	
    	
    	
    }
    
    
    
    
    
    
    
}

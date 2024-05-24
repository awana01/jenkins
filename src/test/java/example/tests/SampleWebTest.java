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

import example.testutil.AttachmentUtil;


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
    
    @Test(invocationCount=1,priority=1)
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
    	
    	new AttachmentUtil(driver).takeScreenshot();
    	System.out.println("Execution done...");
    	
    	new AttachmentUtil(driver).takeBase64Screenshot();
    	
    	new AttachmentUtil(driver).getScreenshotAsBase64();
    	
    	new AttachmentUtil(driver).attachText("eleeeeeeeeeeeeeeeeee meeeeeeeeeeee nttttttttttt");
    	
    	
    	String jString = "{\"element\":\"ele1\","
    			+ "\"group\":\"Hydra\"}";
    	new AttachmentUtil(driver).attachJsonText(jString);
    	String x = "{\r\n"
    			+ "  \"ele1\":\"erty\",\r\n"
    			+ "  \"ele2\":\"sdsddfdsf\"\r\n"
    			+ "}";
    	
    	new AttachmentUtil(driver).attachJsonText(x);
    	// text/html
    	// Media types: text/csv, 
    	// text/tab-separated-values
    }
    
    
    @Test(description="Take WebElement screenshot",priority=2)
    public void test02() throws InterruptedException {
    	WebElement toolsMenu  = driver.findElement(By.id("hdtbMenus"));
    	
    	By toolsMenuAll = By.cssSelector("div#hdtbMenus.pZvJc.qCqYBc");
    	
    	
    	if(toolsMenu.isDisplayed()) {
    		System.out.println("Element is displayed");
    		new AttachmentUtil(driver).getWebElementScreenshotAsBase64(toolsMenu);
    		
    		
    		
    	}else {
    		System.out.println("Element is not displayed");
    		driver.findElement(By.id("hdtb-tls")).click();
    		new AttachmentUtil(driver).getWebElementScreenshotAsBase64(By.id("hdtbMenus"));
    		Thread.sleep(500);
    		
    		
    	}
    }
    
    @Test(description="Take WebElement screenshot2",priority=3)
    public void test03() throws InterruptedException {
    	By toolsMenuAll = By.cssSelector("div#hdtbMenus.pZvJc.qCqYBc");
    	new AttachmentUtil(driver).AddElementShot(toolsMenuAll);
    }
    
}

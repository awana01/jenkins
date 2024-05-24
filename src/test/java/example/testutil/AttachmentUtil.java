package example.testutil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class AttachmentUtil {

	WebDriver driver;

	public AttachmentUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot() {
		boolean b = false;
		try {
			File screenshotAs = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
			Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshotAs));
			b = true;
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

//	 @Attachment(value = "Screenshot", type = "image/png"
//	 public static byte[] takeBase64Screenshot() {
	public void takeBase64Screenshot() {
		byte[] screenshot = null;
		try {
			Allure.addAttachment("ScreenshotAsBase64",
					((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BASE64));// ,"img/png");
//	    	    TakesScreenshot driver = (TakesScreenshot) new ChromeDriver();
//	            File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
//	            BufferedImage bufferedImage = ImageIO.read(screenshotFile);
//	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	            ImageIO.write(bufferedImage, "png", bos);
//	            screenshot = bos.toByteArray();
//	    	ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
//	    	Allure.addAttachment("ScreenshotAsBase64", ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BASE64),"img/png");

//	    	byte[] screenShot = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.BYTES);
//	    	Allure.addAttachment("ScreenshotAsBase64",screenShot);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return screenshot;
	}

	public void attachText(String text_msg) {
		Allure.addAttachment("TextMessage", "text/plain", text_msg);
	}

	public void attachJsonText(String jsonData) {
		Allure.addAttachment("TextMessage", "text/json", jsonData);
		Allure.addAttachment("TextMessage", "application/json", jsonData);

	}

	@Attachment(value = "Base64-Screenshot", type = "image/png")
	public byte[] getScreenshotAsBase64() {
		byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}


	@Attachment(value = "Base64-WebElementScreenshot", type = "image/png")
	public byte[] getWebElementScreenshotAsBase64(By by) {

		byte[] screenshot = ((TakesScreenshot) this.driver.findElement(by)).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}

	@Attachment(value = "Base64-WebElementScreenshot", type = "image/png")
	public byte[] getWebElementScreenshotAsBase64(WebElement ele) {

		byte[] screenshot = ((TakesScreenshot) ele).getScreenshotAs(OutputType.BYTES);
		return screenshot;
	}


	public void AddElementShot(By by) {
		WebElement we =this.driver.findElement(by);
		byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("EleScreenshotAsBase64", "image/png",screenshot.toString());
	}




}

package demoqa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoqa.commonutils.CommonUtils;

public class Frames {
	
	private WebDriver driver;
	private CommonUtils commonUtils;
	
	public Frames(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	
	public void switchBtwPandFone() throws InterruptedException {
		commonUtils.scrollDown(driver);
		WebElement framesBtn = driver.findElement(By.xpath("(//span[@class=\"text\" and contains(text(),'Frames')])[1]"));
		commonUtils.waitForElementToBeClickable(driver, framesBtn, 10);
		framesBtn.click();
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		
		String parentFrameHandle = driver.getWindowHandle();
		System.out.println(parentFrameHandle);

		// Switch to the target frame
		By iframeLocator = By.id("frame1");
		Thread.sleep(3000);

		commonUtils.waitForElementPresence(driver, iframeLocator, 10);
		WebElement iframeElement = driver.findElement(iframeLocator);
		Thread.sleep(2000);
		driver.switchTo().frame(iframeElement);
		String newFrameHandle = driver.getWindowHandle();
		System.out.println(newFrameHandle);
		WebElement h1Element = driver.findElement(By.id("sampleHeading"));
	    String h1Text = h1Element.getText();
	    System.out.println("Text inside the frame1: " + h1Text);
		// Retrieve the handle of the current frame again
		//String newFrameHandle = driver.getWindowHandle();
	    commonUtils.scrollDown(driver);
		// Compare the handles to verify if there is a switch
		if (parentFrameHandle.equals(newFrameHandle)) {
		    System.out.println("Successfully switched frames.");
		} else {
		    System.out.println("Failed to switch frames.");
		}
	}
	
	public void switchBtwPandFtwo() throws InterruptedException {
		commonUtils.scrollDown(driver);
		WebElement framesBtn = driver.findElement(By.xpath("(//span[@class=\"text\" and contains(text(),'Frames')])[1]"));
		commonUtils.waitForElementToBeClickable(driver, framesBtn, 10);
		framesBtn.click();
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		
		String parentFrameHandle = driver.getWindowHandle();
		System.out.println(parentFrameHandle);

		// Switch to the target frame
		By iframeLocator = By.id("frame2");
		Thread.sleep(3000);

		commonUtils.waitForElementPresence(driver, iframeLocator, 10);
		WebElement iframeElement = driver.findElement(iframeLocator);
		Thread.sleep(2000);
		driver.switchTo().frame(iframeElement);
		Thread.sleep(2000);
		commonUtils.scrollDown(driver);
		commonUtils.scrollUp(driver);
		String newFrameHandle = driver.getWindowHandle();
		System.out.println(newFrameHandle);
		WebElement h2Element = driver.findElement(By.id("sampleHeading"));
	    String h2Text = h2Element.getText();
	    System.out.println("Text inside the frame2: " + h2Text);
		// Retrieve the handle of the current frame again
		//String newFrameHandle = driver.getWindowHandle();
	    commonUtils.scrollDown(driver);
		// Compare the handles to verify if there is a switch
		if (parentFrameHandle.equals(newFrameHandle)) {
		    System.out.println("Successfully switched frames.");
		} else {
		    System.out.println("Failed to switch frames.");
		}
	}
		
		public void switchBtwFoneandFtwo() throws InterruptedException {
			commonUtils.scrollDown(driver);
			WebElement framesBtn = driver.findElement(By.xpath("(//span[@class=\"text\" and contains(text(),'Frames')])[1]"));
			commonUtils.waitForElementToBeClickable(driver, framesBtn, 10);
			framesBtn.click();
			commonUtils.scrollDown(driver);
			Thread.sleep(2000);
			
			String parentFrameHandle = driver.getWindowHandle();
			System.out.println("P :"+parentFrameHandle);
			
			By iframeLocator1 = By.id("frame1");
			Thread.sleep(3000);
			commonUtils.waitForElementPresence(driver, iframeLocator1, 10);
			WebElement iframeElement1 = driver.findElement(iframeLocator1);
			Thread.sleep(2000);
			driver.switchTo().frame(iframeElement1);
			Thread.sleep(2000);
			String newFrameHandle1 = driver.getWindowHandle();
			System.out.println("F1: "+newFrameHandle1);
			WebElement h1Element = driver.findElement(By.id("sampleHeading"));
		    String h1Text = h1Element.getText();
		    System.out.println("Text inside the frame1: " + h1Text);
		    if (parentFrameHandle.equals(newFrameHandle1)) {
			    System.out.println("Successfully switched frames(parent to frame1).");
			} else {
			    System.out.println("Failed to switch frames.");
			}
		    
		    driver.switchTo().window(parentFrameHandle);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 400);");
			Thread.sleep(1000);
			// Switch to the target frame
			By iframeLocator2 = By.id("frame2");
			Thread.sleep(3000);

			commonUtils.waitForElementPresence(driver, iframeLocator2, 10);
			WebElement iframeElement2 = driver.findElement(iframeLocator2);
			Thread.sleep(2000);
			driver.switchTo().frame(iframeElement2);
			
			Thread.sleep(2000);
			commonUtils.scrollDown(driver);
			commonUtils.scrollUp(driver);
			String newFrameHandle2 = driver.getWindowHandle();
			System.out.println("F2: "+newFrameHandle2);
			WebElement h2Element = driver.findElement(By.id("sampleHeading"));
		    String h2Text = h2Element.getText();
		    System.out.println("Text inside the frame2: " + h2Text);
			// Retrieve the handle of the current frame again
			//String newFrameHandle = driver.getWindowHandle();
		    commonUtils.scrollDown(driver);
			// Compare the handles to verify if there is a switch
			if (newFrameHandle1.equals(newFrameHandle2)) {
			    System.out.println("Successfully switched frames(frame1 to frame2).");
			} else {
			    System.out.println("Failed to switch frames.");
			}
	}
	
	
}

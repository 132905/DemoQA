package demoqa.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demoqa.commonutils.CommonUtils;

public class NestedFrames {
	
	WebDriver driver;
	CommonUtils commonUtils;
 	
	

	public NestedFrames(WebDriver driver) {
		super();
		this.driver = driver;
	}



	public void switchBtwCandP() throws InterruptedException {
		commonUtils.scrollDown(driver);
		WebElement nstedFramesBtn = driver.findElement(By.xpath("//span[@class=\"text\" and contains(text(),'Nested Frames')]"));
		commonUtils.waitForElementToBeClickable(driver, nstedFramesBtn, 10);
		nstedFramesBtn.click();
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		
		String parentFrameHandle = driver.getWindowHandle();
		System.out.println("DefaultHandle :"+parentFrameHandle);
		
		driver.switchTo().frame("frame1");
		Thread.sleep(2000);
		String newFrameHandle1 = driver.getWindowHandle();
		System.out.println("ParentHandle: "+newFrameHandle1);
		WebElement bodyElement = driver.findElement(By.tagName("body"));
	    System.out.println("Text inside the frame1: " + bodyElement.getText());
	    if (parentFrameHandle.equals(newFrameHandle1)) {
		    System.out.println("Successfully switched frames(default to frame1(Parent frame)).");
		} else {
		    System.out.println("Failed to switch frames.");
		}
	    
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc=\"<p>Child Iframe</p>\"]"));
		driver.switchTo().frame(childFrame);
		Thread.sleep(2000);
		String newFrameHandle2 = driver.getWindowHandle();
		System.out.println("ChildHandle: "+newFrameHandle2);
		WebElement paraElementChild = driver.findElement(By.tagName("p"));
	    System.out.println("Text inside the frame2: " + paraElementChild.getText());
	    commonUtils.scrollDown(driver);
		// Compare the handles to verify if there is a switch
		if (newFrameHandle1.equals(newFrameHandle2)) {
		    System.out.println("Successfully switched frames(Parent frame to Child Iframe)).");
		} else {
		    System.out.println("Failed to switch frames.");
		}
		
		String defFrameHandle = driver.getWindowHandle();
		System.out.println("DefaultHandle :"+defFrameHandle);
		 driver.switchTo().defaultContent();
		 System.out.println("Back to default");
}
}

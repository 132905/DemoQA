package demoqa.pageobject;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import demoqa.commonutils.CommonUtils;

public class ModalDialogs {
	
	WebDriver driver;
	CommonUtils commonUtils;
	
	public ModalDialogs(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
//	@FindBy(how = How.XPATH, using = "//button[@id='showSmallModal'] ")
//	private WebElement smallModalBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='modal-body'] ")
	private WebElement smallModalContent;

//	@FindBy(how = How.XPATH, using = "//button[@id='closeSmallModal']")
//	private WebElement smallModalCloseBtn;

	@FindBy(how = How.XPATH, using = "//button[@id='showLargeModal']")
	private WebElement largeModalBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='modal-body'] ")
	private WebElement largeModalContent;

	@FindBy(how = How.XPATH, using = "//button[@id='closeLargeModal']")
	private WebElement largeModalCloseBtn;



	public void modalElement() throws InterruptedException {
		
		commonUtils.scrollDown(driver);
		WebElement modalDBtn = driver.findElement(By.xpath("//span[@class=\"text\" and contains(text(),'Modal Dialogs')]"));
		commonUtils.waitForElementToBeClickable(driver, modalDBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", modalDBtn);
		Thread.sleep(1000);
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		
		WebElement smallModalBtn = driver.findElement(By.xpath("//button[@id=\"showSmallModal\" and @type=\"button\" ]"));
		commonUtils.waitForElementToBeClickable(driver, smallModalBtn, 10);
		smallModalBtn.click();
		Thread.sleep(2000);
//		WebElement modal = driver.findElement(By.xpath("//div[@class=\"modal-content\"]"));
//		driver.switchTo().frame(smallModalBtn);
		try {
		WebElement modalContent = driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
		String modalText = modalContent.getText();
		System.out.println("Text from the small modal dialog: \n" + modalText);
		}catch(NoSuchElementException e) {
			
		}
		WebElement smallModalCloseBtn = driver.findElement(By.xpath("//button[@id=\"closeSmallModal\"]"));
		commonUtils.waitForElement(driver, smallModalCloseBtn, 2);
		smallModalCloseBtn.click();
		System.out.println("Small modal dialog closed.");
		Thread.sleep(1000);
		
		WebElement largeModalBtn = driver.findElement(By.xpath("//button[@id=\"showLargeModal\" and @type=\"button\" ]"));
		commonUtils.waitForElement(driver, largeModalBtn, 2);
		largeModalBtn.click();
		Thread.sleep(1000);
		WebElement largeModalContent = driver.findElement(By.xpath("//div[@class=\"modal-body\"]"));
		commonUtils.waitForElement(driver, largeModalContent, 2);
		if(largeModalContent.getText().contains("Lorem Ipsum is simply dummy text")){
			System.out.println("\n Large modal opened successfully");
		}
		else{
			System.out.println("\n Large modal didnt open");
		}
		System.out.println("Large modal dialog closed.");
		WebElement largeModalCloseBtn = driver.findElement(By.xpath("//button[@id=\"closeLargeModal\"]"));
		commonUtils.waitForElement(driver, largeModalCloseBtn, 2);
		largeModalCloseBtn.click();
	
	}
}

package demoqa.pageobject;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demoqa.commonutils.CommonUtils;

public class Alerts {
	
	private WebDriver driver;
	private CommonUtils commonUtils;
	
	public Alerts(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public void clickOne() throws InterruptedException {
		
		WebElement alertsBtn = driver.findElement(By.xpath("//span[@class='text' and contains(text(),\"Alerts\")]"));
		commonUtils.waitForElementToBeClickable(driver, alertsBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertsBtn);
		
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement clickOneBtn = driver.findElement(By.xpath("//button[@id='alertButton' and @type='button' and  @class='btn btn-primary']"));
		commonUtils.waitForElementToBeClickable(driver, clickOneBtn, 10);
		clickOneBtn.click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
	    System.out.println("Alert text: " + alertText);
	    alert.accept();
		
	}

	public void clickTwo() throws InterruptedException {
		
		WebElement alertsBtn = driver.findElement(By.xpath("//span[@class='text' and contains(text(),\"Alerts\")]"));
		commonUtils.waitForElementToBeClickable(driver, alertsBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertsBtn);
		
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement clickTwoBtn = driver.findElement(By.xpath("//button[@id='timerAlertButton' and @type='button' and  @class='btn btn-primary']"));
		commonUtils.waitForElementToBeClickable(driver, clickTwoBtn, 10);
		clickTwoBtn.click();
		Thread.sleep(6000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
	    System.out.println("Alert text: " + alertText);
	    alert.accept();
		 }

	public void clickThree() throws InterruptedException {
		
		WebElement alertsBtn = driver.findElement(By.xpath("//span[@class='text' and contains(text(),\"Alerts\")]"));
		commonUtils.waitForElementToBeClickable(driver, alertsBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertsBtn);
		
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement clickThreeBtn = driver.findElement(By.xpath("//button[@id='confirmButton' and @type='button' and  @class='btn btn-primary']"));
		commonUtils.waitForElementToBeClickable(driver, clickThreeBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickThreeBtn);
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
	    System.out.println("Alert text: " + alertText);
	    alert.accept();
	    WebElement txtField = driver.findElement(By.xpath("//span[@id=\"confirmResult\" and @class=\"text-success\"]"));
	    String msg = txtField.getText();
	    System.out.println("Message displayed is: "+msg);
	}

	
	
	public  String generateRandomName() {


		String[] NAMES = {
	            "John", "Emma", "Michael", "Sophia", "William", "Olivia", "James", "Ava", "Benjamin", "Isabella"
	            
	    };
        Random random = new Random();
        int randomIndex = random.nextInt(NAMES.length);
        return NAMES[randomIndex];
    }
	
	public void clickFour() throws InterruptedException {
	
		WebElement alertsBtn = driver.findElement(By.xpath("//span[@class='text' and contains(text(),\"Alerts\")]"));
		commonUtils.waitForElementToBeClickable(driver, alertsBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertsBtn);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400);");
		Thread.sleep(1000);
		WebElement clickFourBtn = driver.findElement(By.xpath("//button[@id=\"promtButton\" and @type=\"button\" and @class=\"btn btn-primary\"]"));
		commonUtils.waitForElementToBeClickable(driver, clickFourBtn, 10);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickFourBtn);
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
	    System.out.println("Alert text: " + alertText);
	    alert.sendKeys(generateRandomName());
	    alert.accept();
	    WebElement txtField = driver.findElement(By.xpath("//span[@id=\"promptResult\" and @class=\"text-success\"]"));
	    String msg = txtField.getText();
	    System.out.println("Message displayed is: "+msg);
	}

}

package demoqa.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
	
	public String clickOne() throws InterruptedException {
		commonUtils.scrollDown(driver);
		Thread.sleep(2000);
		WebElement alertsBtn = driver.findElement(By.xpath("//span[@class='text' and contains(text(),\"Alerts\")]"));
		alertsBtn.click();
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement clickOneBtn = driver.findElement(By.xpath("//button[@id='alertButton' and @type='button' and  @class='btn btn-primary']"));
		commonUtils.waitForElementToBeClickable(driver, clickOneBtn, 10);
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
	    System.out.println("Alert text: " + alertText);
	    alert.accept();
		return "Clicked button to see alert";
	}

}

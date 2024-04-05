package demoqa.pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import demoqa.commonutils.CommonUtils;



public class BrowserWindow {
	
	private WebDriver driver;
	private CommonUtils commonUtils;
	
	public BrowserWindow(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "(//span[@class=\"pr-1\" ] ) [3]")
	private WebElement alertsFWBtn;
	
	@FindBy(how = How.XPATH, using = "//span[@class=\"text\" and contains(text(),'Browser Windows')]")
	private WebElement browserWindowBtn;
	
//	@FindBy(how = How.XPATH, using = "//*[@id=\"tabButton\"]")
//	private WebElement newTabBtn; 
	
//	@FindBy(how = How.XPATH, using = "//button[@id=\"windowButton\" and @type=\"button\"]")
//	private WebElement newWindowBtn; 
	
//	@FindBy(how = How.XPATH, using = "//button[@id=\"messageWindowButton\" and @type=\"button\"]")
//	private WebElement newWindowMsgBtn; 

	public void closeBrowser() {
		try {
			if(driver != null) {
			driver.quit();}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void openBWPage() throws InterruptedException{
		commonUtils.scrollDown(driver);
		commonUtils.waitForElement(driver, alertsFWBtn, 10);
		alertsFWBtn.click();
		Thread.sleep(500);
		commonUtils.waitForElement(driver, browserWindowBtn, 10);
		browserWindowBtn.click();
		Thread.sleep(1000);
	}
		
	public void newTab() throws InterruptedException {
		String originalWindowHandle = driver.getWindowHandle();
		System.out.println(originalWindowHandle);
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement newTabBtn = driver.findElement(By.xpath("//*[@id=\"tabButton\"]"));
		CommonUtils.waitForElementToBeClickable(driver, newTabBtn, 10);
		newTabBtn.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(2000);
                String newWindowTitle = driver.getTitle();
                String newTabContent = driver.getPageSource();
                System.out.println("New window title: " + newWindowTitle);
                System.out.println("Content of new window: " + newTabContent);
                driver.close();
                break;
            }
        }
		driver.quit();
		
	}
	
	public void newWindow() throws InterruptedException {
		String originalWindowHandle = driver.getWindowHandle();
		System.out.println(originalWindowHandle);
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement newWindowBtn = driver.findElement(By.xpath("//*[@id=\"windowButton\"]"));
		CommonUtils.waitForElementToBeClickable(driver, newWindowBtn, 10);
		newWindowBtn.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(2000);
                String newWindowTitle = driver.getTitle();
                String newTabContent = driver.getPageSource();
                System.out.println("New window title: " + newWindowTitle);
                System.out.println("Content of new window: " + newTabContent);
                driver.close();
                break;
            }
        }
		driver.quit();
		
	}

	public void newWindowMsg() throws InterruptedException {
		String originalWindowHandle = driver.getWindowHandle();
		System.out.println(originalWindowHandle);
		commonUtils.scrollDown(driver);
		Thread.sleep(500);
		WebElement newWindowMsgBtn = driver.findElement(By.xpath("//*[@id=\"messageWindowButton\"]"));
		CommonUtils.waitForElementToBeClickable(driver, newWindowMsgBtn, 10);
		newWindowMsgBtn.click();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                Thread.sleep(2000);
                String newWindowTitle = driver.getTitle();
                String newTabContent = driver.getPageSource();
                System.out.println("New window title: " + newWindowTitle);
                System.out.println("Content of new window: " + newTabContent);
                driver.close();
                break;
            }
        }
		driver.quit();
		
	}
}

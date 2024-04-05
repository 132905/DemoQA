package demoqa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import demoqa.commonutils.CommonUtils;
import demoqa.pageobject.Alerts;
import demoqa.pageobject.BrowserWindow;

public class BaseTest {
	

	protected WebDriver driver;
	private CommonUtils commonUtils;
	public BrowserWindow browserWindow;
	public Alerts alerts;
	
	@BeforeMethod
	public void setUp() throws IOException {
		driver = commonUtils.createDriver(commonUtils.loadProperties());
		browserWindow = new BrowserWindow(driver);
		alerts=new Alerts(driver);
		
		commonUtils.browserSetup(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		 
		browserWindow.closeBrowser();
	}
}

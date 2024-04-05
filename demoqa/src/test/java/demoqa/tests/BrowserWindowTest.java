package demoqa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoqa.commonutils.CommonUtils;
import demoqa.pageobject.BrowserWindow;



public class BrowserWindowTest extends BaseTest{
	
	@Test
	public void testNewTab() throws InterruptedException {
		browserWindow.newTab();
	}
	
	
	@Test
	public void testNewWindow() throws InterruptedException {
		browserWindow.newWindow();
	}
	
	
	@Test
	public void testNewWindowMsg() throws InterruptedException {
		browserWindow.newWindowMsg();
	}
																						
	

}

package demoqa.tests;

import org.testng.annotations.Test;

public class AlertsTest extends BaseTest {
	@Test(priority=1)
	public void testAlertsOne() throws InterruptedException {
	  alerts.clickOne();
	 
	}
	
	
	@Test(priority=2)
	public void testAlertsTwo() throws InterruptedException {
	  alerts.clickTwo();
	 
	}
	
	
	@Test(priority=3)
	public void testAlertsThree() throws InterruptedException {
	  alerts.clickThree();
	 
	}
	
	
	@Test(priority=4)
	public void testAlertsFour() throws InterruptedException {
	  alerts.clickFour();
	 
	}


}

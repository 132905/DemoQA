package demoqa.tests;

import org.testng.annotations.Test;

public class FramesTest extends BaseTest{
	
	@Test(priority=1)
	public void pToFoneTest() throws InterruptedException {
		frames.switchBtwPandFone();
	}
	
	@Test(priority=2)
	public void pToFtwoTest() throws InterruptedException {
		frames.switchBtwPandFtwo();
	}
	
	@Test(priority=3)
	public void FoneToFtwoTest() throws InterruptedException {
		frames.switchBtwFoneandFtwo();
	}
}

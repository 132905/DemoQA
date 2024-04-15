package demoqa.tests;

import org.testng.annotations.Test;

public class NestedFramesTest extends BaseTest {
	

	@Test
	public void pToFoneTest() throws InterruptedException {
		nestedFrames.switchBtwCandP();
	}

}

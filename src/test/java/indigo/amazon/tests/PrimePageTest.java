package indigo.amazon.tests;

import org.testng.annotations.Test;

import indigo.amazon.base.BaseClass;

public class PrimePageTest extends BaseClass {
	@Test
	public void primePageTest() {
		primePage.primeSteps("test@test.som", "123456", "Sign in");
		
		
	}

	
}

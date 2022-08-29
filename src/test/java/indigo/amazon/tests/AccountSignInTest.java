package indigo.amazon.tests;

import org.testng.annotations.Test;

import indigo.amazon.base.BaseClass;

public class AccountSignInTest extends BaseClass{
	@Test
	public void test() {
		homePage.signInSteps();
		signInPage.continueSteps("test@test.com");
		signInPage.secondSignInSteps("Abc2022");
	}
	
}
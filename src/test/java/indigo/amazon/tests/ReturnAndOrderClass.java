package indigo.amazon.tests;

import org.testng.annotations.Test;

import indigo.amazon.base.BaseClass;

public class ReturnAndOrderClass extends BaseClass {

	@Test
	public void getAReturnAndOrderQuote() {
		homePage.homePageReturnAndOrderSteps();
		retAndOrderSignInWithCreateAccountPage.returnAndOrderSignInPageSteps();
		createAccountPage.createAccountPageSteps("Adriana Flores","test@test.com","Abcd123","Abcd123");
	}

}

 package indigo.amazon.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import indigo.amazon.common.CommonFunctions;

public class RetAndOrderSignInWithCreateAccountPage {

	WebDriver driver;
	CommonFunctions commons;

	public RetAndOrderSignInWithCreateAccountPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;

	}

	@FindBy(id = "createAccountSubmit")
	WebElement createYourAmazonAccountElement;

	private void createYourAmazonAccountElement() {
		commons.click(createYourAmazonAccountElement);
	}

	public void returnAndOrderSignInPageSteps() {
		createYourAmazonAccountElement();

	}

}

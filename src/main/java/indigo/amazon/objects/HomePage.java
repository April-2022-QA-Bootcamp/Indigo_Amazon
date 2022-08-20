package indigo.amazon.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import indigo.amazon.common.CommonFunctions;

public class HomePage {

	CommonFunctions commons;

	public HomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
	}

	@FindBy(xpath = "//span[text()= 'Returns']")
	WebElement returnAndOrderElement;

	private void returnAndOrderElement() {
		commons.click(returnAndOrderElement);
	}

	public void homePageReturnAndOrderSteps() {
		returnAndOrderElement();
	}

}

package indigo.amazon.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import indigo.amazon.common.CommonFunctions;

public class CreateAccountPage {
	
	WebDriver driver;
	CommonFunctions commons;
	
	public CreateAccountPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		
	}
	
	@FindBy(css = ".a-input-text.a-span12.auth-autofocus.auth-required-field")
	WebElement firstAndLastNamElement;
	
	@FindBy(css = ".a-input-text.a-span12.a-spacing-micro.auth-required-field.auth-require-claim-validation")
	WebElement mobNumOrEmailElement;
	
	@FindBy(css = ".a-input-text.a-span12.auth-required-field.auth-require-fields-match.auth-require-password-validation")
	WebElement passWordElement;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement reEnterPassWordElement;
	
	@FindBy(className = "a-button-input")
	WebElement continuElement;
	
	
	private void inputFirstAndLastName(String firstAndLastName) {
		commons.inputValue(firstAndLastNamElement, firstAndLastName);
	}
	
	private void inputMobNumOrEmail(String mobNumOrEmail) {
		commons.inputValue(mobNumOrEmailElement, mobNumOrEmail);
	}
	
	private void inputPassWord(String passWord) {
		commons.inputValue(passWordElement, passWord);
	}
	
	private void inputReEnterPassWord(String reEnterPassWord) {
		commons.inputValue(reEnterPassWordElement, reEnterPassWord);
	}
	
	private void continueElement() {
		commons.click(continuElement);
	}
	
	public void createAccountPageSteps(String firstAndLastName, String mobNumOrEmail, String passWord, String reEnterPassWord) {
		inputFirstAndLastName(firstAndLastName);
		inputMobNumOrEmail(mobNumOrEmail);
		inputPassWord(passWord);
		inputReEnterPassWord(reEnterPassWord);
		continueElement();
	}

}
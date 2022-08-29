package indigo.amazon.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import indigo.amazon.common.CommonFunctions;

public class SignInPage {
	WebDriver driver;
	CommonFunctions commons;
	
	public SignInPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		
	}
	@FindBy(css = ".a-input-text.a-span12.auth-autofocus.auth-required-field")
	WebElement emailOrMobileElement;
	
	@FindBy(css = ".a-button.a-button-span12.a-button-primary")
	WebElement continueElement;
	
	@FindBy(css = ".a-input-text.a-span12.auth-autofocus.auth-required-field")
	WebElement PasswordElement;
	@FindBy(id = "signInSubmit")
	WebElement clickSignInElement;
	
	private void inputEmailOrMobileNo(WebElement element, String value1) {
		commons.inputValue(emailOrMobileElement, value1);
		}
	
	private void clickContinue(WebElement element) {
		commons.click(continueElement);
		}
	private void inputPass(WebElement element, String value2) {
		commons.inputValue(PasswordElement, value2);
	}
	
	private void clickSignInButton(WebElement element) {
		commons.click(clickSignInElement);
	}
	
	public void continueSteps(String value1) {
		inputEmailOrMobileNo(emailOrMobileElement, value1);
		clickContinue(continueElement );
			
	}
	
	public void secondSignInSteps(String value2) {
		inputPass(PasswordElement, value2);
		clickSignInButton(clickSignInElement);
	}
}
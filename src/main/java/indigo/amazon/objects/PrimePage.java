package indigo.amazon.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import indigo.amazon.common.CommonFunctions;

public class PrimePage {
	WebDriver driver;
	CommonFunctions commons;

	public PrimePage(WebDriver driver, CommonFunctions commons) {
		
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}
	
	@FindBy(xpath = "//span[text()='Prime']")
	WebElement primeElement;
	

	@FindBy(xpath = "(//input[@class='prime-signup-button-input paragraph'])[2]")
	WebElement startFreeTrialElement;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement emailAddressElement;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	WebElement passwordElement;
	
	@FindBy(id = "signInSubmit")
	WebElement signInElement;
	
	@FindBy(xpath = " //h1[normalize-space(text())='Sign in'] ")
	WebElement titleElement;
	
	private void clickPrime() {
		commons.click(primeElement);
	}
	

	
	private void clickFreeTrial() {
		commons.click(startFreeTrialElement);
	}
	
	private void inputEmail(String address) {
		commons.inputValue(emailAddressElement, address);
	}
	
	private void inputPassword(String password) {
		commons.inputValue(passwordElement, password);
	}
	
	private void clickSignIn() {
		commons.click(signInElement);
	}
	
	private void getTitle2(String expectedTitle) {
		assertEquals(commons.getText(titleElement), expectedTitle);
		
	}
	
	public void primeSteps(String address,String password,String expectedTitle) {
		clickPrime();
		clickFreeTrial();
		inputEmail(address);
		inputPassword(password);
		clickSignIn();
		getTitle2(expectedTitle);
		
	}
	


}

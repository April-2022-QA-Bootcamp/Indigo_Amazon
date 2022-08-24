package indigo.amazon.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import indigo.amazon.common.CommonFunctions;
import indigo.amazon.common.CommonWaits;
import indigo.amazon.objects.CreateAccountPage;
import indigo.amazon.objects.HomePage;
import indigo.amazon.objects.PrimePage;
import indigo.amazon.objects.RetAndOrderSignInWithCreateAccountPage;
import indigo.amazon.utils.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Configuration configuration = new Configuration(null);

	WebDriver driver;
	WebDriverWait wait;
	CommonWaits waits;

	protected CommonFunctions commons;
	protected HomePage homePage;
	protected RetAndOrderSignInWithCreateAccountPage retAndOrderSignInWithCreateAccountPage;
	protected CreateAccountPage createAccountPage;
	protected PrimePage primePage;

	@BeforeMethod
	public void setUp() {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.get(configuration.getConfiguration("url"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("pageLoadWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("implicitWait"))));
		wait = new WebDriverWait(driver,
				Duration.ofSeconds(Integer.parseInt(configuration.getConfiguration("explicitWait"))));
		initClasses();

	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		retAndOrderSignInWithCreateAccountPage = new RetAndOrderSignInWithCreateAccountPage(driver, commons);
		createAccountPage = new CreateAccountPage(driver, commons);
		primePage = new PrimePage(driver, commons);

	}

	protected WebDriver getDriver() {
		return driver;

	}

	// @AfterMethod
	public void terminate() {
		driver.quit();
	}

}
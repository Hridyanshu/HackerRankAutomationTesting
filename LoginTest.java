import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	
	WebDriver driver;
	
	static ExtentReports report = new ExtentReports("C:\\Users\\Hridyanshu\\Desktop\\Study Material\\Semester 6\\Test Automation Lab\\Project\\Reports\\login.html");
	static ExtentTest test; 
	
	@BeforeClass
	public void openHackerrank() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hridyanshu\\Desktop\\Study Material\\Semester 6\\Test Automation Lab\\ChromeDriver\\chromedriver.exe");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hackerrank.com/");
	}
	
	@BeforeMethod
	public static void startReport(Method result) {
		test = report.startTest(result.getName());
	}
	
	@Test(priority=0)
	public void clickOnLoginButton() {
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"menu-item-2887\"]/a"));
		test.log(LogStatus.INFO, "Checking for the presence of Login Button");
		if(loginButton.isEnabled()) {
			test.log(LogStatus.PASS, "Login button is present.");
			test.log(LogStatus.INFO, "Clicking on loggin button.");
			loginButton.click();
		}
		else {
			test.log(LogStatus.ERROR, "Problem with the login button element.");
		}
	}
	
	@Test(priority=1)
	public void seperateButtonCheck() {
		List<WebElement> loginButtons = driver.findElements(By.className("fl-button-text"));
		test.log(LogStatus.INFO, "Checking for the presence of two login buttons.");
		if(loginButtons.size()==2) {
			test.log(LogStatus.PASS, "Two login buttons are present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the login buttons.");
		}
	}
	
	@Test(priority=2)
	public void developerLoginClick() {
		WebElement developerLoginButton = driver.findElement(By.cssSelector("#post-175 > div > div > div.fl-row.fl-row-full-width.fl-row-bg-none.fl-node-5bd106f71c93d.hr__header-form-section.hr__header-form-section--sign-up > div > div > div.fl-col-group.fl-node-5bd106f71c9ec.fl-col-group-custom-width > div.fl-col.fl-node-5bd106f71cd43 > div > div.fl-module.fl-module-button.fl-node-5bd106f71cbed.hr__builder-button.hr__builder-button--primary.hr__builder-button--primary--halo.hr__builder-button--lg > div > div > a"));
		test.log(LogStatus.INFO, "Clicking on Developer Login Button.");
		if(developerLoginButton.isEnabled()) {
			developerLoginButton.click();
			test.log(LogStatus.PASS, "Redirecting to developer login page...");
		}
		else {
			test.log(LogStatus.FATAL, "Something wrong with developer login button.");
		}
	}
	
	@Test(priority=3)
	public void inputFieldsPresent() {
		WebElement usernameField = driver.findElement(By.name("username"));
		WebElement passwordField = driver.findElement(By.name("password"));
		test.log(LogStatus.INFO, "Checking for the presence of input fields.");
		if(usernameField.isDisplayed() && passwordField.isDisplayed()) {
			test.log(LogStatus.INFO, "Input fields are present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with input fields.");
		}
	}
	
	@Test(priority=4)
	public void inputCredentials() {
		test.log(LogStatus.INFO, "Entering credentials for login.");
		driver.findElement(By.name("username")).sendKeys("hridyanshusharma@gmail.com");
		driver.findElement(By.name("password")).sendKeys("********");
		driver.findElement(By.xpath("//*[@id=\"tab-1-content-1\"]/div[1]/form/div[4]/button")).click();
		test.log(LogStatus.PASS, "Redirecting to dashboard...");
	}
	
	@AfterClass
	public void closeChromeWindow() {
		driver.close();
    }
	
	@AfterMethod
	public void EndReport() {
		report.endTest(test);
		report.flush();
	}
}

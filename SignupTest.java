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

public class SignupTest {
	
WebDriver driver;
	
	static ExtentReports report = new ExtentReports("/home/atishay/Test Automation Lab/TA_project/signup.html");
	static ExtentTest test; 
	
	@BeforeClass
	public void openHackerrank() {
		System.setProperty("webdriver.chrome.driver", "/home/atishay/Test Automation Lab/chromedriver");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hackerrank.com/");
	}
	
	@BeforeMethod
	public static void startReport(Method result) {
		test = report.startTest(result.getName());
	}
	
	@Test(priority=0)
	public void clickOnSignupButton() {
		test.log(LogStatus.INFO,"Checking for the presence of SignUp Button.");
		WebElement signupButton = driver.findElement(By.partialLinkText("Sign Up"));
		if(signupButton.isEnabled()) {
			test.log(LogStatus.PASS, "SignUp button is present.");
			test.log(LogStatus.INFO, "Clicking on signup button.");
			signupButton.click();
		}
		else {
			test.log(LogStatus.ERROR, "Problem with the signup button element.");
		}
	}
	
	@Test(priority=1)
	public void seperateButtonCheck() {
		List<WebElement> signupButtons = driver.findElements(By.className("fl-button-text"));
		test.log(LogStatus.INFO, "Checking for the presence of three seperate sign up buttons.");
		if(signupButtons.size()==3) {
			test.log(LogStatus.PASS, "Three signup buttons are present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the signup buttons.");
		}
	}
	
	@Test(priority=2)
	public void developerSignupClick() {
		WebElement developerSignupButton = driver.findElement(By.xpath("//*[@id=\"post-153\"]/div/div/div[1]/div/div/div[2]/div[2]/div/div[4]/div/div/a"));
		test.log(LogStatus.INFO, "Clicking on Developer Signup Button.");
		if(developerSignupButton.isEnabled()) {
			developerSignupButton.click();
			test.log(LogStatus.PASS, "Redirecting to developer sign-up page...");
		}
		else {
			test.log(LogStatus.FATAL, "Something wrong with developer sign-up button.");
		}
	}
	
	@Test(priority=3)
	public void inputFieldsPresent() {
		WebElement nameField = driver.findElement(By.name("name"));
		WebElement emailField = driver.findElement(By.name("email"));
		WebElement passwordField = driver.findElement(By.name("password"));
		test.log(LogStatus.INFO, "Checking for the presence of input fields.");
		if(nameField.isDisplayed() && emailField.isDisplayed() && passwordField.isDisplayed()) {
			test.log(LogStatus.PASS, "Input fields are present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with input fields.");
		}
	}
	
	@Test(priority=4)
	public void inputDetails() {
		test.log(LogStatus.INFO, "Entering the details");
		driver.findElement(By.name("name")).sendKeys("Atishay Jain");
		driver.findElement(By.name("email")).sendKeys("atishayjain3107@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		test.log(LogStatus.PASS, "Details entered successfully.");
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

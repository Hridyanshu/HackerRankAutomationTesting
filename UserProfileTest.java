
import java.lang.reflect.Method;
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

public class UserProfileTest {
	
	WebDriver driver;
	
	static ExtentReports report = new ExtentReports("/home/atishay/Test Automation Lab/TA_project/profile.html");
	static ExtentTest test; 
	
	@BeforeClass
	public void openHackerrank() {
		System.setProperty("webdriver.chrome.driver", "/home/atishay/Test Automation Lab/chromedriver");  
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hackerrank.com/Hridyanshu");
	}
	
	@BeforeMethod
	public static void startReport(Method result) {
		test = report.startTest(result.getName());
	}
	
	@Test(priority=0)
	public void usernameCheck() {
		test.log(LogStatus.INFO, "Checking for the presence of username field.");
		WebElement username = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/article/div/div[1]/div/p[1]"));
		if(username!=null) {
			test.log(LogStatus.PASS, "Username is present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the username attribute.");
		}
	}
	
	@Test(priority=1)
	public void aboutSectionCheck() {
		test.log(LogStatus.INFO, "Checking for the presence of About section.");
		WebElement about = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/article/div/div[1]/section/section/h2"));
		if(about!=null) {
			test.log(LogStatus.PASS, "About section field is present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the about section.");
		}
	}
	
	@Test(priority=2)
	public void badgesCheck() {
		test.log(LogStatus.INFO, "Checking for the presence of Badges field.");
		WebElement badges = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/article/div/div[2]/section[2]/header/h2"));
		if(badges!=null) {
			test.log(LogStatus.PASS, "Badges field is present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the Badges Field.");
		}
	}
	
	@Test(priority=3)
	public void verifiedSkillsCheck() {
		test.log(LogStatus.INFO, "Checking for the presence of Verified Skills field.");
		WebElement skills = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/article/div/div[2]/section[1]/header/h2"));
		if(skills!=null) {
			test.log(LogStatus.PASS, "Verified Skills field is present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the Verified Skills Field.");
		}
	}
	
	@Test(priority=4)
	public void submissionsCheck() {
		test.log(LogStatus.INFO, "Checking for the presence of Submissions field.");
		WebElement submissions = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[3]/article/div/div[2]/section[6]/header/h2"));
		if(submissions!=null) {
			test.log(LogStatus.PASS, "Submissions field is present.");
		}
		else {
			test.log(LogStatus.FAIL, "Something wrong with the Submissions Field.");
		}
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
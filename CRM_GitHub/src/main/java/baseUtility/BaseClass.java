package baseUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import genericUtility.PropertyFileUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver= null;
	public static WebDriver sdriver;// this is only for listeners
	
	PropertyFileUtility putil= new PropertyFileUtility();
	@BeforeSuite(groups = {"Smoke Test","Regresstion Test"})
	public void configBS() {
		System.out.println("Database connection, Report config");
	}
	@AfterSuite(groups = {"Smoke Test","Regresstion Test"})
	public void configAS() {
		System.out.println("Disconnect Database connection, Report Back up");
	}
	@BeforeTest(groups = {"Smoke Test","Regresstion Test"})
	public void configBT() {
		System.out.println("Pre-condition");
	}
	@AfterTest(groups = {"Smoke Test","Regresstion Test"})
	public void configAT() {
		System.out.println("Post-condition");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke Test","Regresstion Test"})
	public void configBC(/*String browser*/) throws IOException {
		//String BROWSER= browser;
		String BROWSER = putil.readDataFromProperties("Browser");
		String URL = putil.readDataFromProperties("Url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		sdriver= driver; //re-initializing
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod(groups = {"Smoke Test","Regresstion Test"})
	public void configBM() throws IOException {
		String UNAME = putil.readDataFromProperties("Username");
		String PWD = putil.readDataFromProperties("Password");
		LoginPage lp= new LoginPage(driver);
		lp.login(UNAME, PWD);
	}
	
	@AfterMethod(groups = {"Smoke Test","Regresstion Test"})
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups = {"Smoke Test","Regresstion Test"})
	public void configAC() {
		driver.quit();
	}

}

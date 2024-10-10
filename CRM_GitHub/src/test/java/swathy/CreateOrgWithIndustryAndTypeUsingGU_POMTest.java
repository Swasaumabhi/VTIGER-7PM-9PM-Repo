package swathy;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.WebDriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.NewOrgPage;
import objectRepository.OrgInfoPage;
import objectRepository.OrganizationPage;

public class CreateOrgWithIndustryAndTypeUsingGU_POMTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		WebDriver driver= null;
		PropertyFileUtility putil= new PropertyFileUtility();
		ExcelFileUtility eutil= new ExcelFileUtility();
		JavaUtility jutil= new JavaUtility();
		WebDriverUtility wutil= new WebDriverUtility();
		//Read the common data from properties file
				String BROWSER = putil.readDataFromProperties("Browser");
				String URL = putil.readDataFromProperties("Url");
				String UNAME = putil.readDataFromProperties("Username");
				String PWD = putil.readDataFromProperties("Password");
				
				//Generate Random Number
				int randomNum = jutil.getRandomNumber();
				
				//Read the Test script data from excel file
				String orgName = eutil.readDataFromExcelFile("Org", 1, 2)+randomNum;
				String industry= eutil.readDataFromExcelFile("Org", 1, 5);
				String type= eutil.readDataFromExcelFile("Org", 1, 6);
				
				//Cross Browser Testing / launch empty browser
				
				if(BROWSER.equalsIgnoreCase("chrome")) {
					driver= new ChromeDriver();
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
					driver= new FirefoxDriver();
				}else if(BROWSER.equalsIgnoreCase("edge")) {
					driver= new EdgeDriver();
				}else {
					driver= new ChromeDriver();
				}
				
				//Enter the URL
				driver.get(URL);
				driver.manage().window().maximize();
				wutil.waitForPageToLoad(driver);
				
				//Login to application
				LoginPage lp= new LoginPage(driver);
				lp.login(UNAME, PWD);
				
				//Navigate to organization module
				HomePage hp= new HomePage(driver);
				hp.getOrglink().click();
								
				//Click on "Create Org" lookup image
				OrganizationPage op= new OrganizationPage(driver);
				op.getNewOrg().click();
				
				//Create org with mandatory details
				NewOrgPage nop= new NewOrgPage(driver);
				nop.createOrg(orgName, industry, type);
				
				
				//Verification
				OrgInfoPage oip= new OrgInfoPage(driver);
				String headerInfo =oip.getHeaderText().getText();
				if(headerInfo.contains(orgName)) {
					System.out.println(orgName+" created successfully");
				}else {
					System.out.println("Failed to create "+orgName);
				}
				
				//Verifying Industry and Type
				String actIndustry = oip.getIndustryHeader().getText();
				if(actIndustry.equals(industry)) {
					System.out.println(industry+" info is verified successfully");
				}else {
					System.out.println(industry+" info failed to verify");
				}
				String actType = oip.getTypeHeader().getText();
				if(actType.equals(type)) {
					System.out.println(type+" info is verified successfully");
				}else {
					System.out.println(type+" info failed to verify");
				}
				//Logout
				hp.logout();
				
				//close the browser
				driver.quit();
				

	}

}
}
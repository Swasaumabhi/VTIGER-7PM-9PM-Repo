package objectRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactPage {
	WebDriver driver;

	public NewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name= "lastname")
	private WebElement lastname;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement newOrgInContact;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getNewOrgInContact() {
		return newOrgInContact;
	}

	public WebElement getSave() {
		return save;
	}
	
	@FindBy(name = "support_start_date")
	private WebElement startDate;
	
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	@FindBy(name = "support_end_date")
	private WebElement endDate;
	
	public void getSupportSystemDate(String start, String end) {
		startDate.clear();
		startDate.sendKeys(start);
		endDate.clear();
		endDate.sendKeys(end);
	        
	}
	@FindBy(name = "search_text")
	private WebElement searchBar;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgIncontact;

	public WebElement getOrgIncontact() {
		return orgIncontact;
	}

	public void addContactWithOrg(String orgName) {
		String parentWindow = driver.getWindowHandle();
		orgIncontact.click();
			// switch to child window to add org
		Set<String> allWin = driver.getWindowHandles();
		allWin.remove(parentWindow);
		for (String currWIn : allWin) {
			driver.switchTo().window(currWIn);
			searchBar.sendKeys(orgName);
			searchBtn.click();
			driver.findElement(By.linkText(orgName)).click();
		}
		driver.switchTo().window(parentWindow);

	}
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement actualStartDate;
	
	public WebElement getActualStartDate() {
		return actualStartDate;
	}

	public WebElement getActualEndDate() {
		return actualEndDate;
	}

	@FindBy(id = "dtlview_Support End Date")
	private WebElement actualEndDate;
	
}





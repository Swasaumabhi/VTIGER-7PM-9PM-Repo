package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewOrgPage {
	WebDriver driver;

	public NewOrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name  ="accountname")
	private WebElement orgName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save;
	
	@FindBy(name= "industry")
	private WebElement industryDD;
	
	@FindBy(name = "accounttype")
	private WebElement typeDD;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}
	
	public void createOrg(String org) {
		orgName.sendKeys(org);
		save.click();
	}
	public void createOrg(String org, String industry) {
		orgName.sendKeys(org);
		Select sel= new Select(industryDD);
		sel.selectByVisibleText(industry);
		save.click();
	}
	public void createOrg(String org, String industry, String type) {
		orgName.sendKeys(org);
		Select sel1= new Select(industryDD);
		sel1.selectByVisibleText(industry);
		Select sel2= new Select(typeDD);
		sel2.selectByVisibleText(type);
		save.click();
	}
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	@FindBy(name= "search_field")
	private WebElement searchDD;
	
	@FindBy(name= "submit")
	private WebElement searchButton;
	
	@FindBy(id = "phone")
	private WebElement phNumber;

	public WebElement getPhNumber() {
		return phNumber;
	}
	



}




package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;

		public HomePage(WebDriver driver) {
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(linkText = "Contacts")
		private WebElement contactlink;
		
		@FindBy(linkText = "Organizations")
		private WebElement orglink;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement administrator;
		
		@FindBy(linkText = "Sign Out")
		WebElement signout;
		
		@FindBy(linkText = "Campaigns")
		private WebElement campaign;

		@FindBy(linkText = "More")
		private WebElement more;
		
		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getContactlink() {
			return contactlink;
		}

		public WebElement getOrglink() {
			return orglink;
		}

		public WebElement getAdministrator() {
			return administrator;
		}

		public WebElement getCampaign() {
			return campaign;
		}

		public WebElement getMore() {
			return more;
		}
		
		public WebElement getSignout() {
			return signout;
		}
		
			
		public void logout() {
			Actions action= new Actions(driver);
			action.moveToElement(administrator).click().perform();
			signout.click();
		}

		public void navigateToCampaign() {
			Actions action= new Actions(driver);
			action.moveToElement(more).perform();
			campaign.click();
		}
}




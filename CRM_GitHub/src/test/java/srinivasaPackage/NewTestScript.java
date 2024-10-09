
package srinivasaPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTestScript 
{
	public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://demowebshop.tricentis.com/register");
	Thread.sleep(4000);
	
	//WebElement genderButton = driver.findElement(By.xpath("//input[@id='gender-male']"));
	//genderButton.click();
	//Thread.sleep(4000);
	
	driver.quit();


}
}

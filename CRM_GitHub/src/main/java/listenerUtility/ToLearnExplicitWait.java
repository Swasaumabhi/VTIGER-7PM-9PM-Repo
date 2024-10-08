package listenerUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToLearnExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.shoppersstack.com/products_page/19");
		driver.findElement(By.id("Check Delivery")).sendKeys("560075");
		WebElement checkBtn = driver.findElement(By.id("Check"));
		//explicit wait
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(checkBtn));
		checkBtn.click();
		Thread.sleep(2000);
		driver.quit();

	}

}

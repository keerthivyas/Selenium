package selenium.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ajio {

	private int size;

	@Test
	public void orderAjioProduct() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver85.exe");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

		driver.get("https://www.ajio.com/shop/women/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement women = driver.findElementByXPath("//a[text()='WOMEN']");
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(women).perform();
		
		driver.findElementByLinkText("Kurtas").click();
		
		driver.findElementByXPath("//span[text()='brands']").click();
		
		driver.findElementByXPath("//label[@class='facet-linkname facet-linkname-brand facet-linkname-AJIO']").click();
		
		List<WebElement> brand = driver.findElementsByXPath("//div[@class='brand']");
		
		List<String> allBrand = new ArrayList<String>();
		
		for (WebElement eachBrand : brand) {
			
			allBrand.add(eachBrand.getText());
			
		}
		
		System.out.println(allBrand);
		
		size = allBrand.size();
		
		System.out.println("Total Number of AJIO Products : "+size);
		
		driver.findElementByXPath("//div[@class='filter-dropdown']").click();
		
		driver.findElementByXPath("//option[text()='Discount']").click();
		
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//div[@class='item rilrtl-products-list__item item'])[1]").click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		List<String> listWindow = new ArrayList<String>(allWindow);
		
		System.out.println(driver.switchTo().window(listWindow.get(0)).getTitle());
		
		System.out.println(driver.switchTo().window(listWindow.get(1)).getTitle());
		
		driver.switchTo().window(listWindow.get(1));
		
		driver.findElementByXPath("//span[@class='ic-pdp-add-cart']").click();
		
		Thread.sleep(2000);
		
		String errorMsg = driver.findElementByXPath("//span[@class='msg-content']").getText();
		
		System.out.println("Error message : "+errorMsg);
		
		driver.findElementByXPath("//div[text()='M']").click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='edd-pincode-msg-container']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='edd-pincode-modal-text']"))).sendKeys("603103");
		
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		
		Thread.sleep(2000);
		
		String expectedDate = driver.findElementByXPath("//span[@class='edd-message-success-details-highlighted']").getText();
		
		System.out.println("Expected Delivery date : "+expectedDate);

		driver.findElementByXPath("//span[@class='ic-pdp-add-cart']").click();
		
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ic-pdp-add-cart']"))).click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//button[@class='rilrtl-button button shipping-button']").click();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}

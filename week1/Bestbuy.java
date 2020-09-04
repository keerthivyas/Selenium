package selenium.week1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Bestbuy {

	@Test
	public void bestBuy() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.bestbuy.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.manage().window().maximize();
		
		driver.findElementByXPath("(//h4)[2]").click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[19]"))).click();
		
		driver.findElementByXPath("(//button[@type='button'])[3]").click();
		
		driver.findElementByXPath("//button[@class='menu-item-button-61 ']").click();
		
		driver.findElementByXPath("//div[text()='iPhone']").click();
		
		driver.findElementByXPath("//a[text()='iPhone SE']").click();
		
		driver.findElementByXPath("//button[@data-rtb-selected-sku='6389069']").click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Continue']"))).click();
		
		if(driver.findElementByXPath("//button[@id='SignInToastCloseButton']").isDisplayed()) {
			
			driver.findElementByXPath("//button[@id='SignInToastCloseButton']").click();
			
		}
		
		driver.findElementByXPath("//button[@id='variaton-dropdown-Cell_Phones_Internal_Memory']").click();
		
		//driver.findElementById("variations-dropdown-item-Cell_Phones_Internal_Memory-128GB").click();
		
		//driver.findElementByXPath("//a[@id='variations-dropdown-item-Cell_Phones_Internal_Memory-128GB']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//a[@id='variations-dropdown-item-Cell_Phones_Internal_Memory-128GB']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//button[@data-plan-id='6389075-retail-1-STANDARD-standard-SPR']").click();
		
		Thread.sleep(5000);
		
		String price1 = driver.findElementByXPath("(//span[@aria-hidden='true'])[5]").getText().trim();
		
		System.out.println(price1);
		
		driver.findElementByXPath("//button[@Class='btn btn-primary btn-lg btn-block btn-leading-ficon add-to-cart-button']").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//a[text()='Go to Cart']").click();
		
	//	driver.findElementByXPath("//button[@Class='carriers-page__carrier-choice-button carriers-page__carrier-choice-button--selected']").click();
		
	//	driver.findElementByXPath("//button[@Class='btn btn-secondary btn-lg carriers-page__continue']").click();
		
		
		
	}

}

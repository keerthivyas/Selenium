package selenium.week1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SalesForce {
	
	public String email = "keerthivyask@gmail.com";
	
	@Test
	public void createUser() throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
			
	    options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver1.exe");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		driver.findElementById("username").sendKeys("samdavid@testleaf.com");
		
		driver.findElementById("password").sendKeys("samchennai92");
		
		driver.findElementById("Login").click();
		
		Thread.sleep(5000);
		
		driver.findElementByXPath("//a[@title=\"Create Menu\"]").click();
		
		driver.findElementByXPath("(//span[text()=\"User\"])[1]").click();
		
		Thread.sleep(5000);
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("name_lastName"))).sendKeys("Kishore");
		
		driver.switchTo().frame(0);
		
		driver.findElementByXPath("//input[@id=\"name_lastName\"]").clear();
		
		driver.findElementByXPath("//input[@id=\"name_lastName\"]").sendKeys("Kishore");
		
		driver.findElementById("Alias").clear();
		
		driver.findElementById("Alias").sendKeys("Mr");
		
		driver.findElementById("Email").clear();
		
		driver.findElementById("Email").sendKeys(email);
		
		driver.findElementById("Username").clear();
		
		driver.findElementById("Username").sendKeys(email);
		
		driver.findElementById("CommunityNickname").clear();
		
		driver.findElementById("CommunityNickname").sendKeys("Kishore");
		
		driver.findElementByXPath("//select[@id=\"role\"]").click();
		
		driver.findElementByXPath("//option[text()=\"CEO\"]").click();
		
		driver.findElementById("user_license_id").click();
		
		driver.findElementByXPath("//option[text()='Salesforce Platform']").click();
		
		//driver.findElementById("Profile").click();
		
		//driver.findElementByXPath("//option[text()='Chatter Free User']").click();
		
		driver.findElementByXPath("//img[@alt=\"Delegated Approver Lookup (New Window)\"]").click();
		
		driver.switchTo().defaultContent();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(allWindows);
		
		driver.switchTo().window(windows.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame(1);
		
		driver.findElementByXPath("(//a[@class=' dataCell '])[1]").click();
		
		Thread.sleep(5000);
		
		//driver.switchTo().defaultContent();
		
        driver.switchTo().window(windows.get(0));
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame(0);
		
        driver.findElementByXPath("//img[@alt=\"Manager Lookup (New Window)\"]").click();
		
		//driver.switchTo().defaultContent();
		
		Set<String> allWindows2 = driver.getWindowHandles();
		
		List<String> windows2 = new ArrayList<String>(allWindows2);
		
		driver.switchTo().window(windows2.get(1));
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().frame(1);
		
		driver.findElementByXPath("(//a[@class=' dataCell '])[1]").click();
		
		Thread.sleep(5000);
		
		driver.switchTo().window(windows2.get(0));
		
		//driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		
		driver.findElementByXPath("(//input[@name=\"save\"])[2]").click();
		
		Thread.sleep(5000);
		
		driver.switchTo().frame(0);
		
		System.out.println(driver.findElementByXPath("//div[@id='errorTitle']").getText());
		
	}

}

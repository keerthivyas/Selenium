package selenium.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon {

	@Test
	public void orderinAmazon() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver85.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://amazon.in/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 15);

		driver.manage().window().maximize();

		driver.findElementById("twotabsearchtextbox").clear();

		driver.findElementById("twotabsearchtextbox").sendKeys("outslayer");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='suggestions']/div[1]")).click();

		Thread.sleep(2000);

		// List<WebElement> price =
		// driver.findElements(By.xpath("//a[@class=\"a-size-base a-link-normal
		// s-no-hover a-text-normal\"]//span[@class=\"a-price\"]//span"));

		List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		List<Integer> newPrice = new ArrayList<Integer>();

		int size = price.size();

		System.out.println(size);

		for (WebElement eachPrice : price) {

			// String text = eachPrice.getText().trim();

			// text = text.replaceAll("[^0-9]"," ");

			String text = eachPrice.getText().replaceAll("[^0-9]", "");

			// System.out.println(text);

			// newPrice.add(Integer.parseInt(text));
			try {
				newPrice.add(Integer.parseInt(text));
			} catch (NumberFormatException nfe) {
				// System.out.println("Eror");
			}

		}

		System.out.println(newPrice);

		Integer max = Collections.max(newPrice);

		System.out.println("Maximum Price needs to select : " + max);

		price.get(newPrice.indexOf(Collections.max(newPrice))).click();

		Thread.sleep(5000);

		System.out.println("Price after sorting :");

		Collections.sort(newPrice);

		System.out.println(newPrice);

		Set<String> allWindow = driver.getWindowHandles();

		List<String> window = new ArrayList<String>(allWindow);

		driver.switchTo().window(window.get(1));

		driver.findElementById("add-to-cart-button").click();

		Thread.sleep(2000);

		driver.findElementById("hlb-ptc-btn-native").click();

		Thread.sleep(2000);

		driver.findElementById("continue").click();

		Thread.sleep(2000);

		String text = driver.findElementByXPath("(//div[@class=\"a-alert-content\"])[2]").getText();

		System.out.println("Error message : " + text);

	}

}

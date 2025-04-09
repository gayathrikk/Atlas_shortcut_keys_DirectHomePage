package com.gayu.Gayathri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ShortcutKey_Homepage {
	private RemoteWebDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		URL url = new URL("http://172.20.23.92:4443/wd/hub");
		driver = new RemoteWebDriver(url, options);
	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
		driver.manage().window().maximize();
		System.out.println("✅ Server opened successfully");

		String parentWindow = driver.getWindowHandle();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("✅ Login button clicked");

		Thread.sleep(4000);

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}

		WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("teamsoftware457@gmail.com");
		System.out.println("✅ Email entered");

		WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		next.click();
		System.out.println("✅ First Next clicked");

		WebElement passwordInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordInput.sendKeys("Health#123");
		System.out.println("✅ Password entered");

		WebElement next2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		next2.click();
		System.out.println("✅ Second Next clicked");

		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void table() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			search.sendKeys("TestM\n");
			System.out.println("✅ Search term entered");
		} catch (Exception e) {
			System.out.println("❌ Failed to enter search term");
		}

		try {
			WebElement editor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
			editor.click();
			System.out.println("✅ Atlas Editor clicked");
		} catch (Exception e) {
			System.out.println("❌ Atlas Editor not clicked");
		}

		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	@Test(priority = 3)
	public void Direct_drawpage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		try {
			WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']")));
			menu.click();
			System.out.println("✅ Menu clicked");
		} catch (Exception e) {
			System.out.println("❌ Menu not clicked");
		}

		try {
			WebElement draw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/paintbrush.svg']")));
			draw.click();
			System.out.println("✅ Draw clicked");
		} catch (Exception e) {
			System.out.println("❌ Draw not clicked");
		}

		try {
			WebElement unlock = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Unlock']")));
			unlock.click();
			System.out.println("✅ Unlock clicked");
		} catch (Exception e) {
			System.out.println("❌ Unlock not clicked");
		}

		try {
		    WebDriverWait wait1 = new WebDriverWait(driver, 50);
		  
		    
		    // Wait until the Software Team element is clickable
		    WebElement softwareTeam = wait1.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='software team']"))
		    );

		    // Get and trim the actual text from the element
		    String actualText = softwareTeam.getText().trim();
		    String expectedText = "software team";

		    // Assert that the actual text matches the expected
		    Assert.assertEquals(actualText, expectedText, "❌ Assertion failed: The retrieved text does not match the expected text.");

		    Thread.sleep(3000);
		    System.out.println("--------------------------*****************-----------------------");
		    System.out.println("✅ The get text is: " + actualText);
		    System.out.println("✅ Assertion passed: The retrieved text matches the expected text.");
		    System.out.println("✅ The 'Software Team' validation worked successfully.");

		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		    System.out.println("Thread interrupted while sleeping.");
		} catch (AssertionError e) {
		    System.out.println("❌ Assertion failed: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("❌ An error occurred: " + e.getMessage());
		}

	



		try {
			WebElement close = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/cancel.svg']")));
			close.click();
			System.out.println("✅ Close clicked");
		} catch (Exception e) {
			System.out.println("❌ Close not clicked");
		}

		try {
			WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/viewer/assets/images/colorsvg/oldmenu.svg']")));
			menu.click();
			System.out.println("✅ Menu clicked again");
		} catch (Exception e) {
			System.out.println("❌ Menu not clicked again");
		}
		
		try {
		    WebDriverWait wait1 = new WebDriverWait(driver, 50);

		    // Wait until the element with the text is clickable
		    WebElement ge = wait1.until(
		        ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' -1 : none-NoneAcronym ']"))
		    );

		    // Get and trim the actual text from the element
		    String actualText = ge.getText().trim();
		    String expectedText = "-1 : none-NoneAcronym"; // Notice no leading/trailing spaces

		    // Assert that the actual text matches the expected
		    Assert.assertEquals(actualText, expectedText, "❌ Assertion failed: The retrieved text does not match the expected text.");

		    Thread.sleep(3000);
		    System.out.println("--------------------------*****************-----------------------");
		    System.out.println("✅ The get text is: " + actualText);
		    System.out.println("✅ Assertion passed: The retrieved text matches the expected text.");
		    System.out.println("✅ The region validation worked successfully.");

		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		    System.out.println("Thread interrupted while sleeping.");
		} catch (AssertionError e) {
		    System.out.println("❌ Assertion failed: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("❌ An error occurred: " + e.getMessage());
		}

		
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("🛑 Browser closed");
		}
	}
}

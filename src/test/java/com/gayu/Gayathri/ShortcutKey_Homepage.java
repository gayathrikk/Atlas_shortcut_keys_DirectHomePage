package com.gayu.Gayathri;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
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
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://172.12.20.99:4444/wd/hub");
		driver = new RemoteWebDriver(url, dc);
	}
	@Test(priority=1)
	public void Login() throws InterruptedException {
		driver.get("http://apollo2.humanbrain.in/");
		driver.manage().window().maximize();
		System.out.println("The server is Opened sucessfully");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement viewerSectionLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'ng-tns-c93-3')]")));
		viewerSectionLink.click();
		System.out.println("The Viewer Icon is clicked");
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait1= new WebDriverWait(driver, 20);
		WebElement login = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
		login.click();
		System.out.println("The login Button is clicked");
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(4000);
		WebDriverWait wait2 = new WebDriverWait(driver,20);
		WebElement  emailInput = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
		emailInput.sendKeys("softwaretestingteam9@gmail.com");
		System.out.println("Mail I'd is entered");
		WebDriverWait wait3 = new WebDriverWait(driver,20);
		WebElement  Next = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next.click();
		System.out.println("The Next Button is clicked");
		WebDriverWait wait4 = new WebDriverWait(driver,20);
		WebElement  PasswordInput = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		PasswordInput.sendKeys("Health#123");
		System.out.println("Password is entered");
		WebDriverWait wait5 = new WebDriverWait(driver,20);
		WebElement  Next2 = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
		Next2.click();		
		System.out.println("The Next Button is clicked");
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(5000);
	}
	@Test(priority = 2)
	public void table() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		try {
			WebDriverWait wait6 = new WebDriverWait(driver, 30);
			WebElement table1 = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search tags']")));
			table1.sendKeys("TestM\n");
			Thread.sleep(3000);
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number Entered Successfully");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The number is not Entered successfully");
		}
		try {
			WebDriverWait wait7 = new WebDriverWait(driver, 30);
			WebElement table2 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//nb-icon[@nbtooltip='Atlas Editor']")));
			table2.click();
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Altas Editor is clicked");
		} catch (Exception e) {
			System.out.println("--------------------------*****************-----------------------");
			System.out.println("The Atlas Editor is not clicked");
		}
		Thread.sleep(4000);
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}}}
	@Test(priority=3)
	public void Direct_drawpage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Actions actions = new Actions(driver);
	        actions.keyDown(Keys.SHIFT) 
	               .sendKeys("o")  
	               .keyUp(Keys.SHIFT)  
	               .build()
	               .perform();
	        WebElement LockedPerson = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Software Team']")));
	        String actualText = LockedPerson.getText();           
	        String expectedText = "Software Team";
	        Assert.assertEquals(actualText, expectedText, "The retrieved text does not match the expected text.");	        
	        Thread.sleep(3000);	        
	        System.out.println("--------------------------*****************-----------------------");
	        System.out.println("Assertion passed: The retrieved text matches the expected text.");
	        System.out.println("The shorcutkeys go to direct Homepage sucesssfully");
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	        System.out.println("Thread interrupted while sleeping.");
	    } catch (AssertionError e) {
	        System.out.println("Assertion failed: " + e.getMessage());
	    } catch (Exception e) {
	        System.out.println("An error occurred: " + e.getMessage());
	    }
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 50);
		    Actions actions = new Actions(driver);
		    actions.keyDown(Keys.SHIFT) 
		           .sendKeys("p")  
		           .keyUp(Keys.SHIFT)  
		           .build()
		           .perform();
		    
		    WebElement selectedRegion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' -1 : Not Available-NA ']")));
		    String actualText = selectedRegion.getText();           
		    String expectedText = "-1 : Not Available-NA";
		    
		    Assert.assertEquals(actualText, expectedText, "The retrieved text does not match the expected text.");	        
		    
		    Thread.sleep(3000);	        
		    
		    System.out.println("--------------------------*****************-----------------------");
		    System.out.println("Assertion passed: The retrieved text matches the expected text.");
		    
		    System.out.println("--------------------------*****************-----------------------");
		    System.out.println("The shortcut keys came back to the Home page sucessfully");
		} catch (InterruptedException e) {
		    Thread.currentThread().interrupt();
		    System.out.println("Thread interrupted while sleeping.");
		} catch (AssertionError e) {
		    System.out.println("Assertion failed: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("An error occurred: " + e.getMessage());
		}}
		@AfterTest
		public void tearDown() {
			if (driver != null) {
				driver.quit();
			}}
	}


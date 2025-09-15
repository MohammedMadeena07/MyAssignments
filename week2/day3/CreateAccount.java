package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {
	public static void main(String[] args) throws InterruptedException {
		// Initialize the WebDriver (ChromeDriver).
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL http://leaftaps.com/opentaps/.
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Enter a username and password.
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		// Click the "Login" button.
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on the "CRM/SFA" link.
		driver.findElement(By.partialLinkText("CRM")).click();
		// Click on the "Accounts" tab.
		driver.findElement(By.linkText("Accounts")).click();
		// Click on the "Create Account" button.
		driver.findElement(By.linkText("Create Account")).click();
		// Enter an account name.
		driver.findElement(By.id("accountName")).sendKeys("Maddy01");
		// Enter a description as "Selenium Automation Tester."
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		// Enter a Number Of Employees.
		driver.findElement(By.id("numberEmployees")).sendKeys("2");
		// Enter a Site Name as “LeafTaps”
		driver.findElement(By.name("officeSiteName")).sendKeys("LeafTaps");
		// Click the "Create Account" button.
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(2000);
		// Verify that the Title is displayed correctly
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		String expectedTitle = "Account Details | opentaps CRM";
		if (title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is displayed correctly");
		} else {
			System.out.println("Incorrect Title");
		}
		// Close the browser window
		driver.close();
	}
}

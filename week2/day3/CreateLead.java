package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {
	public static void main(String[] args) {
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
		// Click on the "Leads" tab.
		driver.findElement(By.linkText("Leads")).click();
		// Click on the "Create Lead" button.
		driver.findElement(By.linkText("Create Lead")).click();
		// Enter a FirstName.
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Maddy");
		// Enter a LastName.
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("B");
		// Enter a CompanyName.
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("LeafTaps");
		// Enter a Title .
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Senior");
		// Click the "Create Lead" button.
		driver.findElement(By.className("smallSubmit")).click();
		// Verify that the Title is displayed correctly.
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		String expectedTitle = "View Lead | opentaps CRM";
		if (title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is displayed correctly");
		} else {
			System.out.println("Incorrect Title");
		}
		// Close the browser window.
		driver.close();
	}
}

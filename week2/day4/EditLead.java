package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
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
		// Enter the CompanyName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("LeafTaps");
		// Enter the FirstName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Madyy");
		// Enter the LastName Field Using Xpath.
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("MB");
		// Enter the FirstName (Local) Field Using Xpath.
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("MB");
		// Enter the Department Field Using any Locator of Your Choice.
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("HR");
		// Enter the Description Field Using any Locator of your choice.
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Lead");
		// Enter your email in the E-mail address Field using the locator of your
		// choice.
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@xyz.com");
		// Select State/Province as NewYork Using Visible Text.
		Select state = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		state.selectByVisibleText("New York");
		// Click the "Create Lead" button.
		driver.findElement(By.className("smallSubmit")).click();
		// Click on the edit button.
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		// Clear the Description Field.
		driver.findElement(By.id("updateLeadForm_description")).clear();
		// Fill the Important Note Field with Any text.
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Updated");
		// Click on the update button.
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		// Get the Title of the Resulting Page.
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		// Close the browser window.
		driver.close();
	}
}

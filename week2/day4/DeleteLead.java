package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {
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
		// Click on the "Leads" tab.
		driver.findElement(By.linkText("Leads")).click();
		// Click "Find leads."
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Click on the "Phone" tab.
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		// Enter the phone number.
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("123456789");
		// Click the "Find leads" button.
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		// Capture the lead ID of the first resulting lead.
		String leadID = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-col-partyId')]")).getText();
		System.out.println("First Lead ID: " + leadID);
		// Click the first resulting lead.
		driver.findElement(By.xpath("//a[text()='" + leadID + "']")).click();
		// Click the "Delete" button.
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		// Click "Find leads" again.
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Enter the captured lead ID.
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
		// Click the "Find leads" button.
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// Verify the presence of the message "No records to display" in the Lead List.
		// This message confirms the successful deletion.
		Thread.sleep(4000);
		String identifiedMessage = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		String expectedMessgae = "No records to display";
		if (identifiedMessage.equals(expectedMessgae)) {
			System.out.println("Verification Successful");
		} else {
			System.out.println("Verification Failed");
		}
		// Close the browser window.
		driver.close();
	}
}

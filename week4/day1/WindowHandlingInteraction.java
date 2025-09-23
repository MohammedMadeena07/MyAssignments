package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingInteraction {
	public static void main(String[] args) {
		// Initialize ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL (http://leaftaps.com/opentaps/control/login)
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Enter the username and password.
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		// Click on the Login button.
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		// Click on the CRM/SFA link.
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		// Click on Merge Contacts.
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// Click on the widget of the "From Contact".
		driver.findElement(By.xpath("//img[@alt='Lookup']/parent::a")).click();
		// Click on the first resulting contact.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowId = new ArrayList<>(windowHandles);
		String firstContactId = windowId.get(1);
		String parentWindowId = windowId.get(0);
		driver.switchTo().window(firstContactId);
		driver.findElement(By.xpath("//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a")).click();
		driver.switchTo().window(parentWindowId);
		// Click on the widget of the "To Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup']/parent::a)[2]")).click();
		// Click on the second resulting contact.
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<>(windowHandles1);
		String secondContactId = windowIds.get(1);
		driver.switchTo().window(secondContactId);
		driver.findElement(By.xpath("(//div[@class=\"x-grid3-cell-inner x-grid3-col-partyId\"]/a)[2]")).click();
		driver.switchTo().window(parentWindowId);
		// Click on the Merge button.
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// Accept the alert.
		Alert alert = driver.switchTo().alert();
		alert.accept();
		// Verify the title of the page.
		String title = driver.getTitle();
		System.out.println("Page Title is: " + title);
		driver.quit();
	}
}

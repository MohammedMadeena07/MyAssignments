package week2.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	public static void main(String[] args) throws InterruptedException {
		// Initialize the WebDriver (ChromeDriver).
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Click on the Create new account button.
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(2000);
		// Enter the First name.
		driver.findElement(By.name("firstname")).sendKeys("Maddy");
		// Enter the Surname.
		driver.findElement(By.name("lastname")).sendKeys("B");
		// Enter the Mobile number or email address.
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		// Enter the New password.
		driver.findElement(By.id("password_step_input")).sendKeys("abc123@123");
		// Handle all three dropdowns in Date of birth
		Select day = new Select(driver.findElement(By.id("day")));
		day.selectByVisibleText("5");
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByValue("5");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("2005");
		// Select the radio button in Gender.
		driver.findElement(By.xpath("//input[@value='2']")).click();
	}
}

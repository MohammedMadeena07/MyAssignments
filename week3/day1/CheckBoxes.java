package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {
	public static void main(String[] args) throws InterruptedException {
		// Initialize ChromeDriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL https://leafground.com/checkbox.xhtml
		driver.get("https://leafground.com/checkbox.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the web page elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Click on the "Basic Checkbox.”
		driver.findElement(By.xpath("(//span[text()='Basic']/preceding-sibling::div)[2]")).click();
		// Click on the "Notification Checkbox."
		driver.findElement(By.xpath("(//span[text()='Ajax']/preceding-sibling::div)[2]")).click();
		// Verify that the expected message is displayed.
		String checkboxNotification = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		String expectedCheckboxNotification = "Checked";
		if (checkboxNotification.equals(expectedCheckboxNotification)) {
			System.out.println("Expected message is displayed as: " + checkboxNotification);
		} else {
			System.out.println("Invalid expected message as: " + checkboxNotification);
		}
		// Click on your favorite language (assuming it's related to checkboxes).
		driver.findElement(
				By.xpath("//label[text()='Python']/preceding-sibling::div[contains(@class, 'ui-chkbox ui-widget')]"))
				.click();
		// Click on the "Tri-State Checkbox."
		driver.findElement(By.xpath(
				"//h5[text()='Tri State Checkbox']/following-sibling::div//div[contains(@class, 'ui-chkbox-box')]"))
				.click();
		// Verify which tri-state option has been chosen.
		String stateNotification = driver
				.findElement(By.xpath("//span[text()='State has been changed.']/following-sibling::p")).getText();
		if (stateNotification.equals("State = 1")) {
			System.out.println("State 1 is chosen");
		} else if (stateNotification.equals("State = 2")) {
			System.out.println("State 2 is chosen");
		} else {
			System.out.println("No State is chosen");
		}
		// Click on the "Toggle Switch."
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		// Verify that the expected message is displayed.
		String toggleNotification = driver.findElement(By.xpath("//div[@class='ui-growl-message']/span")).getText();
		String expectedToggleNotification = "Checked";
		if (toggleNotification.equals(expectedToggleNotification)) {
			System.out.println("Expected message is displayed as: " + toggleNotification);
		} else {
			System.out.println("Invalid expected message as: " + toggleNotification);
		}
		// Verify if the Checkbox is disabled.
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt102_input']"));
		if (checkbox.isEnabled()) {
			System.out.println("Checkbox is enabled");
		} else {
			System.out.println("Checkbox is disabled");
		}
		// Select multiple options on the page (details may be needed).
		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Miami']/div")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Rome']/div")).click();
		driver.findElement(By.xpath("//li[@data-item-value='Amsterdam']/div")).click();

		// Perform any additional actions or verifications required.
		driver.findElement(By.xpath("//a[@class='ui-selectcheckboxmenu-close ui-corner-all']")).click();
		Thread.sleep(2000);
		// Close the web browser when done.
		driver.close();
	}
}

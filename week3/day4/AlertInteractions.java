package week3.day4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertInteractions {
	public static void main(String[] args) {
		// Initialize ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// Load the URL (https://www.leafground.com/alert.xhtml)
		driver.get("https://www.leafground.com/alert.xhtml");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Click on the "Prompt Box" button to trigger the alert.
		driver.findElement(By.xpath("//h5[contains(text(), ' Alert (Prompt Dialog)')]/following::span")).click();
		// Switch to the alert and type a message in the alert box.
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello");
		// Dismiss the alert.
		alert.dismiss();
		// Retrieve the typed text from the alert and verify it.
		String text = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		if (text.equals("Hello")) {
			System.out.println("Text verification matched");
		} else {
			System.out.println("Text Verification failed\nDisplayed Text: " + text);
		}
	}
}

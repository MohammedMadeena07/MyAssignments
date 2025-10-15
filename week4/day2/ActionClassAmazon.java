package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClassAmazon {
	public static void main(String[] args) {
		// Initialize the Chrome browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the url(https://www.amazon.in/)
		driver.get("https://www.amazon.in/");
		// Maximize the browser
		driver.manage().window().maximize();
		// Add an implicitly wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String title = driver.getTitle();
		if(title.equals("Amazon.in")) {
			driver.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		}		
		// Search for "oneplus 9 pro".
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")), "oneplus 9 pro")
				.keyDown(Keys.ENTER).perform();
		// Get the price of the first product.
		String firstProductPrice = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		System.out.println("Price of First Product: " + firstProductPrice);
		// Print the number of customer ratings for the first displayed product.
		String firstProductCustomerRatings = driver
				.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of customer ratings for first displayed product: " + firstProductCustomerRatings);
		// Click the first text link of the first image.
		driver.findElement(By.xpath(
				"//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']"))
				.click();
		// Take a screenshot of the product displayed.
		// Click the 'Add to Cart' button.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowId = new ArrayList<>(windowHandles);
		String newWindow1 = windowId.get(1);
		driver.switchTo().window(newWindow1);
		driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]")).click();
		// Get the cart subtotal and verify if it is correct.
		String cartSubtotal = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		if (cartSubtotal.equals(firstProductPrice)) {
			System.out.println("Price verified successfuly");
		} else {
			System.out.println("Price Verification fails! Mismatch found");
		}
		// Close the browser
		driver.quit();
	}
}

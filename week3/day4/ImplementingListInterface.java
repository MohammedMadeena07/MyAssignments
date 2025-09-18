package week3.day4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ImplementingListInterface {
	public static void main(String[] args) {
		// Initialize ChromeDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Launch the URL https://www.ajio.com/
		driver.get("https://www.ajio.com/");
		driver.findElement(By.id("closeBtn")).click();
		// In the search box, type as "bags" and press enter
		driver.findElement(By.xpath("//input[@name='searchVal']")).sendKeys("bags", Keys.ENTER);
		// To the left of the screen under "Gender" click on "Men"
		driver.findElement(By.xpath("//label[@for='Men']")).click();
		// Under "Category" click "Fashion Bags"
		driver.findElement(By.xpath("//label[@for='Men - Fashion Bags']")).click();
		// Print the count of the items found
		WebElement count = driver.findElement(By.xpath("//div[@class='length']"));
		System.out.println("Count: " + count.getText());
		// Get the list of brand of the products displayed in the page and print the
		// list.
		List<WebElement> brandElement = driver.findElements(By.xpath("//div[@class='brand']/strong"));
		List<String> brandList = new ArrayList<String>();
		for (WebElement brand : brandElement) {
			String brandNames = brand.getText();
			brandList.add(brandNames);
		}
		// Get the list of names of the bags and print it
		Collections.sort(brandList);
		System.out.println("Brand names: ");
		brandList.forEach(System.out::println);
	}
}

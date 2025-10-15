package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class WebTableInteractionErail {
	public static void main(String[] args) {
		// Initialize ChromeDriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL (https://erail.in/)
		driver.get("https://erail.in/");
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		// Enter "MAS" as the "From" station.
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		action.sendKeys(from, "MAS").keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		// Enter "MDU" as the "To" station.
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		action.sendKeys(to, "MDU").keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		// Uncheck the "Sort on Date" checkbox.
		driver.findElement(By.id("chkSelectDateOnly")).click();
		// Retrieve the train names from the web table.
		By tableElement = By.xpath("(//div[@id='divTrainsList']/table)[1]/tbody/tr");
		int rowCount = driver.findElements(tableElement).size();
		List<String> trainNames = new ArrayList<>();
		for (int i = 2; i <= rowCount; i++) {
			String trainName = driver
					.findElement(By.xpath("(//div[@id='divTrainsList']/table)[1]/tbody/tr[" + i + "]/td[2]")).getText();
			trainNames.add(trainName);
		}
		// trainNames.forEach(System.out::println);
		// Verify if there are any duplicate train names in the web table.
		Set<String> uniqueNames = new HashSet<>();
		Set<String> duplicateNames = new HashSet<>();
		for (String name : trainNames) {
			if (!uniqueNames.add(name)) {
				duplicateNames.add(name);
			}
		}
		if (duplicateNames.isEmpty()) {
			System.out.println("All train names are unique");
		} else {
			System.out.println("Duplicate train names are identified");
			System.out.println("Duplicate train names:");
			duplicateNames.forEach(System.out::println);
		}
		driver.quit();
	}
}

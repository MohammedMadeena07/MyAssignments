package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinanceYahoo {
	public static void main(String[] args) {
		// Initialize the Chrome browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the url
		driver.get("https://finance.yahoo.com/");
		// Add an implicitly wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// click on “Crypto” tab
		By more = By.xpath("//span[text()='More']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(more));
		action.moveToElement(driver.findElement(more)).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(text(),'Crypto')])[3]")));
		action.moveToElement(driver.findElement(By.xpath("(//a[contains(text(),'Crypto')])[3]"))).click().perform();
		// Identify the table in the dom using <table> tag (//table)
		String table = "//table[@class='yf-1bwepqw bd']";
		// To access the row values, identify the row using <tr> to travel through the
		// table //table[@class='yf-1bwepqw bd']/tbody/tr[1]/td
		int rowCount = driver.findElements(By.xpath(table + "/tbody/tr")).size();
		System.out.println("Row Count: " + rowCount);
		// To access the column values of the table, identify the column using <th>/<td>
		int columnCount = driver.findElements(By.xpath(table + "/tbody/tr[1]/td")).size();
		System.out.println("Column Count: " + columnCount);
		// Act on the elements in the table using WebElement function by iterating
		// through the rows and columns
		List<String> names = new ArrayList<>();
		for (int i = 1; i <= rowCount; i++) {
			String crypto = driver.findElement(By.xpath(table + "/tbody/tr[" + i + "]/td[2]")).getText();
			names.add(crypto);
		}
		// Print the cryptocurrency names from table
		System.out.println("Cryptocurrency names: ");
		names.forEach(System.out::println);
		driver.quit();
	}
}

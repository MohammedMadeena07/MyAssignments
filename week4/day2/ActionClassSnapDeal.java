package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClassSnapDeal {
	public static void main(String[] args) throws IOException, InterruptedException {
		// Initialize ChromeDriver
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL (https://www.snapdeal.com/)
		driver.get("https://www.snapdeal.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Launch (https://www.snapdeal.com/)
		driver.navigate().refresh();
		driver.findElement(By.id("pushDenied")).click();
		// Go to "Men's Fashion".
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]")))
				.pause(Duration.ofSeconds(3)).perform();
		// Go to "Sports Shoes".
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Sports Shoes']"))).pause(Duration.ofSeconds(2))
				.click().perform();
		// Get the count of sports shoes.
		String sportsShoeCount = driver
				.findElement(By.xpath("//div[text()='Sports Shoes for Men']/following-sibling::div")).getText();
		System.out.println("Count of sports shoe: " + sportsShoeCount);
		// Click on "Training Shoes".
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		// Sort the products by "Low to High".
		driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		// Check if the displayed items are sorted correctly.
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(5000);
		By price = By.xpath("//span[@class='lfloat product-price']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(price));
		List<WebElement> priceElements = driver.findElements(price);
		List<Integer> actualPrices = new ArrayList<>();
		for (WebElement priceElement : priceElements) {
			String priceText = priceElement.getText().replaceAll("[^0-9]", "");
			actualPrices.add(Integer.parseInt(priceText));
		}
		List<Integer> expectedPrices = new ArrayList<>(actualPrices);
		Collections.sort(expectedPrices);
		if (actualPrices.equals(expectedPrices)) {
			System.out.println("Prices are sorted correctly");
		} else {
			System.out.println("Prices are not sorted correctly");
		}
		// Select any price range ex:(500-700).
		action.scrollToElement(driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[1]"))).perform();
		WebElement fromPrice = driver.findElement(By.name("fromVal"));
		fromPrice.clear();
		fromPrice.sendKeys("500");
		WebElement toPrice = driver.findElement(By.name("toVal"));
		toPrice.clear();
		toPrice.sendKeys("700");
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		// Filter by any colour.
		By color = By.xpath("(//div[@class='filter-type-name lfloat'])[3]");
		wait.until(ExpectedConditions.visibilityOfElementLocated(color));
		action.scrollToElement(driver.findElement(color)).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'White & Blue')]")));
		WebElement whiteBlueColor = driver.findElement(By.xpath("//a[contains(text(),'White & Blue')]"));
		driver.executeScript("arguments[0].click();", whiteBlueColor);
		// Verify all the applied filters.
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filters']")));
		String sortByDataFilter = driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::div"))
				.getText();
		System.out.println(sortByDataFilter);
		String priceFilter = driver.findElement(By.xpath("//div[text()='Price: ']/a")).getText();
		System.out.println(priceFilter);
		String colorFilter = driver.findElement(By.xpath("//div[text()='Color: ']/a")).getText();
		System.out.println(colorFilter);
		if (sortByDataFilter.equals("Price Low To High") && priceFilter.equals("Rs. 500 - Rs. 700")
				&& colorFilter.equals("White & Blue")) {
			System.out.println("Filters are applied correctly");
		} else {
			System.out.println("Filters are not applied correctly");
		}
		// Mouse hover on the first resulting "Training Shoes".
		WebElement firstProduct = driver.findElement(By.xpath("(//div[@class='product-tuple-description '])[1]"));
		action.moveToElement(firstProduct).perform();
		// Click the "Quick View" button.
		action.click(driver.findElement(By.xpath("(//div[@class='clearfix row-disc']/div)[1]"))).perform();
		// Print the cost and the discount percentage.
		String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Cost: " + cost);
		String discountPercentage = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discount Percentage: " + discountPercentage);
		// Take a snapshot of the shoes.
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snap/snapDeal/shoeSnapshot.png");
		FileUtils.copyFile(src, target);
		// Close the current window.
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		// Close the main window.
		driver.quit();
	}
}

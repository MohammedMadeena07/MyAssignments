package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClassBigBasket {
	public static void main(String[] args) throws IOException {
		// Initialize ChromeDriver
//		ChromeOptions option = new ChromeOptions();
//		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver();
		// Load the URL (https://www.bigbasket.com/)
		driver.get("https://www.bigbasket.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Navigate to https://www.bigbasket.com/.
		driver.navigate().to("https://www.bigbasket.com/");
		// Click on "Shop by Category".
		driver.findElement(By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']")).click();
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Mouse over "Foodgrains, Oil & Masala".
		WebElement foodGrains = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]")));
		action.moveToElement(foodGrains).pause(3).perform();
		// Mouse over "Rice & Rice Products".
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"))).pause(3).perform();
		// Click on "Boiled & Steam Rice".
		action.click(driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"))).pause(3).perform();
		// Filter the results by selecting the brand "bb Royal".
		WebElement brands = driver.findElement(By.xpath(
				"(//input[@class='flex-1 min-w-0 leading-md lg:text-sm xl:text-md placeholder-silverSurfer-700'])[1]"));
		action.sendKeys(brands, "bb royal").perform();
//		action.click(driver.findElement(By.xpath("//input[@id='i-bbRoyal']"))).perform();
		// Click on "Tamil Ponni Boiled Rice".
		WebElement tamilPonniRice = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Tamil Ponni Boiled')]")));
		action.click(tamilPonniRice).perform();
		// Select the 5 Kg bag.
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowId = new ArrayList<>(windowHandles);
		String parentWindow = windowId.get(0);
		String newWindow = windowId.get(1);
		driver.switchTo().window(newWindow);
		WebElement kg5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='5 kg']")));
		action.click(kg5).perform();
		// Check and note the price of the rice.
		WebElement price = driver.findElement(By
				.xpath("//tr[@class='flex items-center justify-start mb-1 text-base font-bold text-darkOnyx-800']/td"));
		action.scrollToElement(price).perform();
		String priceOfRice = price.getText();
		System.out.println(priceOfRice);
		// Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		// Verify the success message that confirms the item was added to your cart.
		By toastMessage = By.xpath("//p[@class='mx-4 flex-1']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
		String successMessage = driver.findElement(toastMessage).getText();
		String ActualMessage = "An item has been added to your basket successfully";
		if (successMessage.equals(ActualMessage)) {
			System.out.println("Success Message verification: Pass");
		} else {
			System.out.println("Success Message verification: Failed");
		}
		// Take a snapshot of the current page
		File src = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snap/currentPage.png");
		FileUtils.copyFile(src, target);
		// Close the current window.
		driver.close();
		// Close the main window.
		driver.switchTo().window(parentWindow);
		driver.quit();
	}
}

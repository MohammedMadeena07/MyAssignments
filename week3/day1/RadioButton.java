package week3.day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {
	public static void main(String[] args) {
		// Launch the Browser
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL https://www.leafground.com/radio.xhtml.
		driver.get("https://www.leafground.com/radio.xhtml");
		// Add the ImplicityWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Select 'Your most favourite browser' from the radio buttons
		WebElement mostFavBrowser = driver.findElement(
				By.xpath("((//h5[text()='Your most favorite browser'])[1]/following-sibling::div//span)[2]"));
		mostFavBrowser.click();
		// Click on a radio button, then click on the same radio button again to verify
		// that it becomes ‘unselected’.
		WebElement unSelectable = driver
				.findElement(By.xpath("((//h5[text()='UnSelectable'])[1]/following-sibling::div//span)[1]"));
		unSelectable.click();
		unSelectable.click();
		if (!unSelectable.isSelected()) {
			System.out.println("Verification Successful, its unselected");
		} else {
			System.out.println("Verification Failed, its still selected");
		}
		// Identify the radio button that is initially selected by default.
		for (int i = 1; i <= 4; i++) {
			WebElement defaultSelectedRadio = driver.findElement(By.xpath(
					"((//h5[text()='Find the default select radio button'])[1]/following-sibling::div//input[@type='radio'])["
							+ i + "]"));
			if (defaultSelectedRadio.isSelected()) {
				WebElement selectedButton = driver.findElement(By.xpath(
						"((//h5[text()='Find the default select radio button'])[1]/following-sibling::div//label)[" + i
								+ "]"));
				System.out.println(selectedButton.getText());
				break;
			}
		}
		// Check and select the age group (21-40 Years) if not already selected.
		WebElement ageGroup = driver
				.findElement(By.xpath("//label[text()='21-40 Years']/preceding-sibling::div//input"));
		if (ageGroup.isSelected()) {
			System.out.println("Correct Age group is already selected");
		} else {
			ageGroup.click();
			System.out.println("Correct Age group is selected");
		}
	}
}

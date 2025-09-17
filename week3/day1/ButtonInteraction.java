package week3.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ButtonInteraction {
	public static void main(String[] args) {
		// Initialize the WebDriver (ChromeDriver)
		ChromeOptions option = new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(option);
		// Load the URL https://leafground.com/button.xhtml .
		driver.navigate().to("https://leafground.com/button.xhtml");
		// Maximize the browser window.
		driver.manage().window().maximize();
		// Add the ImplicityWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Click on the button with the text ‘Click and Confirm title.’
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		// Verify that the title of the page is ‘dashboard.’
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("dashboard")) {
			System.out.println("Title is correct");
		} else {
			System.out.println("Title is wrong");
		}
		// Check if the button with the text ‘Confirm if the button is disabled’ is
		// disabled.
		driver.navigate().back();
		WebElement disabledButton = driver.findElement(By.xpath("(//span[text()='Disabled']/parent::button)"));
		if (disabledButton.isEnabled()) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
		// Find and print the position of the button with the text ‘Submit.’
		WebElement submitButton = driver.findElement(By.xpath("(//span[text()='Submit']/parent::button)[1]"));
		Point location = submitButton.getLocation();
		int x = location.getX();
		int y = location.getY();
		System.out.println("Submit button is @ Position(x, y): (" + x + ", " + y + ")");
		// Find and print the background color of the button with the text ‘Find the
		// Save button color.’
		WebElement saveButton = driver.findElement(By.xpath("(//span[text()='Save']/parent::button)"));
		String backgroundColor = saveButton.getCssValue("background-color");
		System.out.println("Save button color is: " + backgroundColor);
		// Find and print the height and width of the button with the text ‘Find the
		// height and width of this button.’
		WebElement dimensions = driver.findElement(By.xpath("(//span[text()='Submit']/parent::button)[2]"));
		Dimension size = dimensions.getSize();
		int height = size.height;
		System.out.println("Height of button is: " + height);
		int width = size.width;
		System.out.println("Width of button is: " + width);
		// Close the browser window.
		driver.close();
	}
}

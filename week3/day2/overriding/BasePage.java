package week3.day2.overriding;

public class BasePage {
	public void findElement() {
		System.out.println("Element is located");
	}

	public void clickElement() {
		System.out.println("Located elemesnt as been clicked");
	}

	public void enterText() {
		System.out.println("Text has been entered");
	}

	public void performCommonTasks() {
		String text = "Base Page";
		System.out.println(text + " is loaded");
	}

	public static void main(String[] args) {
		BasePage basepage = new BasePage();
		basepage.findElement();
		basepage.enterText();
		basepage.clickElement();
		basepage.performCommonTasks();
	}
}

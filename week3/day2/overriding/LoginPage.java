package week3.day2.overriding;

public class LoginPage extends BasePage {
	@Override
	public void performCommonTasks() {
		String text = "Login Page";
		System.out.println(text + " is loaded");
	}

	public static void main(String[] args) {
		LoginPage loginpage = new LoginPage();
		loginpage.findElement();
		loginpage.enterText();
		loginpage.clickElement();
		loginpage.performCommonTasks();
	}
}

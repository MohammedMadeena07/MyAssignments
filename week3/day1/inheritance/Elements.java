package week3.day1.inheritance;

public class Elements extends Button {
	public static void main(String[] args) {
		Elements elements = new Elements();
		System.out.println("*****Execution class*****");
		elements.click();
		elements.setText("Enter Element name");
		elements.submit();
		System.out.println("");

		Button button = new Button();
		System.out.println("*****Sub-class 1*****");
		button.click();
		button.setText("Click Button");
		button.submit();
		System.out.println("");

		CheckBoxButton checkBox = new CheckBoxButton();
		System.out.println("*****Super sub-class 1*****");
		checkBox.click();
		checkBox.setText("Check Checkbox");
		checkBox.submit();
		checkBox.clickCheckButton();
		System.out.println("");

		RadioButton radio = new RadioButton();
		System.out.println("*****Super sub-class 2*****");
		radio.click();
		radio.setText("Select Radio button");
		radio.submit();
		radio.selectRadioButton();
		System.out.println("");

		TextField textField = new TextField();
		System.out.println("*****Sub-class 2*****");
		textField.click();
		textField.setText("Enter Text in text field");
		textField.getText();
	}
}

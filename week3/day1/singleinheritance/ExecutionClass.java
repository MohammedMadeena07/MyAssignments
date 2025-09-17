package week3.day1.singleinheritance;

public class ExecutionClass {

	public static void main(String[] args) {

		// Accessing methods from Test Data class file
		System.out.println("******Super class *****");
		TestData testdata = new TestData();
		testdata.enterCredentials();
		testdata.navigateToHomePage();
		System.out.println("");

		// Accessing methods from Login Test Data 1 class file
		System.out.println("******Sub class 1*****");
		LoginTestData1 loginTestData1 = new LoginTestData1();
		loginTestData1.enterCredentials();
		loginTestData1.enterUsername();
		loginTestData1.enterPassword();
		loginTestData1.navigateToHomePage();
		System.out.println("");

		// Accessing methods from Login Test Data 2 class file
		System.out.println("******Sub class 2*****");
		LoginTestData1 loginTestData2 = new LoginTestData1();
		loginTestData2.enterCredentials();
		loginTestData2.enterUsername();
		loginTestData2.enterPassword();
		loginTestData2.navigateToHomePage();
	}
}

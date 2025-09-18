package week3.day2.abstraction;

public abstract class MySqlConnection implements DatabaseConnection {
	abstract void executeQuery();
	public void verified() {
		System.out.println("Verified DB Query execution status");
	}
}

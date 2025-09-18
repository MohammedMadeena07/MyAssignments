package week3.day2.abstraction;

public interface DatabaseConnection {

	void connect();

	void disconnect();

	void executeUpdate();
}

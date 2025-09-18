package week3.day2.abstraction;

public class JavaConnection extends MySqlConnection {

	@Override
	public void connect() {
		System.out.println("Connected to DB");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnected from DB");
	}

	@Override
	public void executeUpdate() {
		System.out.println("DB Update in-progress...");
	}

	@Override
	void executeQuery() {
		System.out.println("Executed DB Query");
	}

	public void updated() {
		System.out.println("DB Update completed");
	}

	public static void main(String[] args) {
		JavaConnection javaConnection = new JavaConnection();
		javaConnection.connect();
		javaConnection.executeQuery();
		javaConnection.executeUpdate();
		javaConnection.updated();
		javaConnection.verified();
		javaConnection.disconnect();
	}
}

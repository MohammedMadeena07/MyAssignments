package week3.day2.interfac;

public class JavaConnection implements DatabseConnection {

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
		System.out.println("DB update is in-progress...");
	}

	public void updated() {
		System.out.println("DB Update completed");
	}

	public static void main(String[] args) {
		JavaConnection javaConnection = new JavaConnection();
		javaConnection.connect();
		javaConnection.executeUpdate();
		javaConnection.updated();
		javaConnection.disconnect();
	}
}

package week3.day2.overloading;

public class APIClient {
	public void sendRequest(String endpoint) {
		System.out.println("*****Same Method with One Attribute*****");
		System.out.println("Request End Point: " + endpoint);
	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("*****Same Method with Three Attributes*****");
		System.out.println("Request Body: " + requestBody);
		System.out.println("Request End point: " + endpoint);
		System.out.println("Request Status: " + requestStatus);
	}

	public static void main(String[] args) {
		APIClient apiClient = new APIClient();
		apiClient.sendRequest("Home");
		System.out.println("");
		apiClient.sendRequest("https://www.facebook.com/", "Login button", true);
	}
}

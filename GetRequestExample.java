import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequestExample {

	public static void main(String[] args) throws IOException, JSONException {
		String url = "https://jsonplaceholder.typicode.com/posts/1";
		doGetReqeust(url);
	}

	private static void doGetReqeust(String url) throws IOException, JSONException {
		URL urlForGet = new URL(url);
		String readLine = null;
		HttpURLConnection connection = (HttpURLConnection) urlForGet.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();
		System.out.println(responseCode);
		if(responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while((readLine = in.readLine())!=null) {
				response.append(readLine);
			} in.close();
			System.out.println("JSON String Result "+ response.toString());
			JSONObject object = new JSONObject(response.toString());
			System.out.println(object.get("userId"));	
			System.out.println(object.getString("title"));
		} else {
			System.out.println("GET FAILED");
		}
	}

}

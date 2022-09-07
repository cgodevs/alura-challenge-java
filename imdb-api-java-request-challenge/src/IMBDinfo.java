import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class IMBDinfo {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		String apiKey = "k_yl3x6k1u";
		URI apiIMDB = URI.create("https://imdb-api.com/en/API/Top250TVs/" + apiKey);
		
		HttpClient client = HttpClient.newHttpClient();		
		HttpRequest request = HttpRequest
	            .newBuilder()
	            .uri(apiIMDB)
	            .GET()
	            .build();   
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		System.out.println("Resposta: " + json.substring(0,1000));       			

	}

}

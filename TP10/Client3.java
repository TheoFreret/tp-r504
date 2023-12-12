import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import javax.json.*;

public class Client3
{
	public static void main(String[] args)
	{
		try {
			System.out.println("http://omdbapi.com?apikey=751ea6aa&t=" + args[0]);
			CloseableHttpClient client = HttpClients.createDefault();
			String url = "http://omdbapi.com?apikey=751ea6aa&t=" + args[0];
			HttpGet request = new HttpGet (url);
			System.out.println("Executing request " + request.getRequestLine());
			CloseableHttpResponse resp = client.execute(request);
			System.out.println("Response Line: " + resp.getStatusLine());
			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());
			InputStreamReader isr = new InputStreamReader(resp.getEntity().getContent());
			JsonReader reader = Json.createReader(isr);
			JsonObject jsonObject = reader.readObject();
			JsonArray tab = jsonObject.getJsonArray("Ratings");
			reader.close();
			for( int i = 0; i < tab.size(); i++ )
			{
				JsonObject ji = tab.getJsonObject(i);
				String Source = ji.getString("Source");
				if (Source.equals("Rotten Tomatoes"))
				{
					System.out.println("Source=" + Source);
					String Value = ji.getString("Value");
					System.out.println("Value=" + Value);
				}				
			}
			isr.close();
			System.out.println("duree=" + jsonObject.getString("Runtime"));
//			getInt (String name);
		}
		catch ( Exception ex ) {
			System.out.println("erreur !");
			ex.printStackTrace();
		}
	}
}

//apikey=751ea6aa

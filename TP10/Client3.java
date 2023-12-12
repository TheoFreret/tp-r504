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
					if (Value != null && Value.length() > 0 && Value.charAt(Value.length() - 1) == '%')
					{
						Value = Value.substring(0, Value.length() -1);
					}
					if (Value <= 20){
						System.out.println("nul");
					}
					else if(Value > 20 && Value <= 50){
						System.out.println("bof");
					}
					else if(Value > 50 && Value <= 70){
						System.out.println("bien");
					}
					else if(Value > 70){
						System.out.println("très bien");
					}
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
//String Number = CharMatcher.inRange('0', '9').retainFrom(Value);

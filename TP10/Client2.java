import java.io.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import javax.json.*;

public class Client2
{
	public static void main(String[] args)
	{
		try {
			System.out.println("http://" + args[0] );
			CloseableHttpClient client = HttpClients.createDefault();
			String url = "http://" + args[0];
			HttpGet request = new HttpGet (url);
			System.out.println("Executing request " + request.getRequestLine());
			CloseableHttpResponse resp = client.execute(request);
			System.out.println("Response Line: " + resp.getStatusLine());
			System.out.println("Response Code: " + resp.getStatusLine().getStatusCode());

			InputStreamReader isr = new InputStreamReader(resp.getEntity().getContent());
			JsonReader reader = Json.createReader(isr);
			JsonObject jsonObject = reader.readObject();
			reader.close();
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

import java.net.*;
import java.io.*;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class urlTest {
	
	
	public urlTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args){
		URL meSteam;
		JsonReader reader;
		
		try {
			meSteam = new URL("http://api.steampowered.com/ISteamUser/" +
					"GetFriendList/v0001/?key=26A0BE6F08077299B964BBEFBAEE5AA0" +
					"&relationship=friend&format=json&steamid=76561197968613153");
			try {
				reader = new JsonReader(new InputStreamReader(meSteam.openStream()));
				
				reader.beginObject();
				System.out.println(reader.nextName());
				
				reader.beginObject();
				System.out.println(reader.nextName());
				
				reader.beginArray();
				
				while(reader.hasNext()){
					reader.beginObject();
					
					while (reader.hasNext()){
						System.out.print(reader.nextName() + ":");
						System.out.println(reader.nextString());
					};
					System.out.println();
					reader.endObject();
				};
			}
			
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



	}

}

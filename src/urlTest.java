import java.net.*;
import java.io.*;

import com.google.gson.stream.JsonReader;

public class urlTest {
	;
	
	public urlTest() {	}

	
	public static void main(String[] args){
		getFriends(76561197968613153L);
	}
	/**
	 * @param args
	 */
	public static void getFriends(Long toGetSteam){
		URL meSteam;
		JsonReader reader;
		SteamUser test = new SteamUser(toGetSteam);
		try {
			meSteam = new URL("http://api.steampowered.com/ISteamUser/" +
					"GetFriendList/v0001/?key=26A0BE6F08077299B964BBEFBAEE5AA0" +
					"&relationship=friend&format=json&steamid=" + test.getID());
			try {
				reader = new JsonReader(new InputStreamReader(meSteam.openStream()));
				
				reader.beginObject();
				System.out.println(reader.nextName());
				
				reader.beginObject();
				System.out.println(reader.nextName());
				
				reader.beginArray();
				
				while(reader.hasNext()){
					reader.beginObject();
					System.out.print(reader.nextName() + ":");
					test.addFriend(reader.nextString());
					System.out.println("Stored");
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

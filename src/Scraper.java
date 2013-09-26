package src;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

import com.google.gson.stream.JsonReader;



public class Scraper {
	
	public Scraper(){}
	
	/**
	 * @param <steamFriend>
	 * @param args
	 */
	public ArrayList<SteamUser> scrapeUser(SteamUser u){
		SteamUser su = u;
		URL meSteam;
		JsonReader reader;
		ArrayList<SteamUser> sf = new ArrayList<SteamUser>();
		
		try {
			meSteam = new URL("http://api.steampowered.com/ISteamUser/" +
					"GetFriendList/v0001/?key=26A0BE6F08077299B964BBEFBAEE5AA0" +
					"&relationship=friend&format=json&steamid=" + su.getID());
			try {
				byte status = 1;
				
				reader = new JsonReader(new InputStreamReader(meSteam.openStream()));
				
				reader.beginObject();//JSON Object
				System.out.println(reader.nextName());
				
				reader.beginObject();//FriendList Object
				System.out.println(reader.nextName());
				
				reader.beginArray();//FriendList Array
				
				
				while(reader.hasNext()){//Read Objects from Array
				//	reader.beginObject(); //for each steam id get the 3 objects
					String id = null;
					String relationship = null;
					int friend_since = 0;
					while (reader.hasNext()){//Read Fields from Object
						reader.beginObject();
						reader.nextName();
						id = reader.nextString();
						reader.nextName();
						relationship = reader.nextString();
						reader.nextName();
						friend_since =Integer.parseInt(reader.nextString());
					
					System.out.println("steamid: "+ id);
					System.out.println("relationship: "+relationship);
					System.out.println("friend_since: "+friend_since);
					
					System.out.println();
					SteamUser data = new SteamUser(Long.parseLong(id));
					sf.add(data);
					reader.endObject();
					};	
				};
				reader.close();
			}
			
			catch (IOException e) {
				
				System.out.println(e.getMessage());
				System.out.println(e.hashCode());
				//e.printStackTrace();
			}
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//want a finnaly statement
		
		
		return sf;



	}

}

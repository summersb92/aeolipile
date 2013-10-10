package src;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

import com.google.gson.stream.JsonReader;

public class Scraper {
	
	public Scraper(){}
	
	private void connect(){
		
	}
	/**
	 * @param <steamFriend>
	 * @param args
	 */
	public ArrayList<SteamUser> scrapeUser(SteamUser u){
		SteamUser su = u;
		URL meSteam;
		JsonReader reader;
		ArrayList<SteamUser> sf = new ArrayList<SteamUser>();
		SteamGetter get = new SteamGetter();
		
		try {
			/*
			 * "http://api.steampowered.com/ISteamUser/" +
					"GetFriendList/v0001/?key=26A0BE6F08077299B964BBEFBAEE5AA0" +
					"&relationship=friend&format=json&steamid="
			 */
			meSteam = new URL(Global.FRIENDLISTURL + su.getID());
			try {
				//byte status = 1;
				//TODO use the new SteamGetter class to read through JSON
				
				
				reader = new JsonReader(new InputStreamReader(meSteam.openStream()));
				reader.beginObject();//JSON Object
				System.out.println(reader.nextName());
				
				reader.beginObject();//FriendList Object
				System.out.println(reader.nextName());
				
				reader.beginArray();//FriendList Array
				
				while(reader.hasNext()){//Read Objects from Array
				//	reader.beginObject(); //for each steam id get the 3 objects
					get.userFriendData(reader.hasNext(), reader, sf);
						
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

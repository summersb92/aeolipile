package src;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import sun.util.calendar.LocalGregorianCalendar.Date;

import com.google.gson.stream.JsonReader;

public class SteamGetter {

	//TODO Need an interpriter of PersonaState
	//TODO Need to implement an ArrayList to store all of the data
	//TODO Need to implement the friendlist getter
	String SteamID;
	String personaname;
	String profileURL;
	String avatar32;
	String avatar64;
	String avatar184;
	int personaState;
	JsonReader reader;
	
	ArrayList<SteamProfile> friends;
	
	public SteamGetter(){
		
	}	
	public void getSteamUser(long id) throws IOException {		
		playerSummary(reader = new JsonReader(new InputStreamReader(
				connect(Global.USERDATAURL,id).openStream())));
	}
	private URL connect(String URL, long id) throws MalformedURLException{
		URL url = new URL(URL+id);
		return url;
	}
	public void playerSummary(JsonReader reader) throws IOException{
		//TODO set up to handle private information
		//TODO clean up to improve efficiency.	
		/**
		 * Gets only public variables at this point
		 */
		reader.beginObject();
		//Gets all public data
			reader.nextName();
			reader.beginObject();
			reader.nextName();
			reader.beginArray();
			//gets Player Object
			reader.beginObject();
			System.out.println("New User");
			reader.nextName();
			SteamID = reader.nextString();
			System.out.print("ID: ");
			System.out.println(SteamID);
			System.out.println(reader.nextName());
			reader.nextString();
			System.out.println(reader.nextName());
			reader.nextString();
			reader.nextName();
			personaname = reader.nextString();
			System.out.print("Name: ");
			System.out.println(personaname);
			//Lastlog off time in unix
			System.out.println(reader.nextName());
			System.out.println(reader.nextString());
			//Gets profile URL
			reader.nextName();
			profileURL = reader.nextString();
			System.out.print("URL: ");
			System.out.println(profileURL);
			/*
			 * Gets all the avatars
			 */
			reader.nextName();
			avatar32 = reader.nextString();
			System.out.print("32x32 Avatar: ");
			System.out.println(avatar32);
			reader.nextName();
			avatar64 = reader.nextString();
			System.out.print("64x64 Avatar: ");
			System.out.println(avatar64);
			reader.nextName();
			avatar184 = reader.nextString();
			System.out.print("184x184 Avatar: ");
			System.out.println(avatar184);
			//Personna State
			System.out.print(reader.nextName()+": ");
			personaState = Integer.parseInt(reader.nextString());
			System.out.println(personaState);
			/**
			 * Any additional information is private
			 */
			//THESE ARE PRIVATE VARIABLES FROM HERE ON OUT
//		reader.endObject();
	}
	/**
	 * Gets a user's friends list and saves to an arraylist
	 * @param b 
	 * @param reader 
	 * @param sf 
	 * 
	 * @param id - the user id
	 * @throws IOException 
	 */
	//TODO Impliment this method to work properly
	public void userFriendData(boolean hasNext, JsonReader reader, ArrayList<SteamUser> sf) throws IOException {
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
		System.out.println("friend_since: "+friend_since+"\n");
		
		SteamUser data = new SteamUser(Long.parseLong(id));
		sf.add(data);
		reader.endObject();
		
		};
	}
	/**
	 * Gets the steam user's game data
	 * 
	 * @param userID
	 * @param gameID
	 */
	//TODO Impliment the method
	public void getSteamUserGameData(long userID, long gameID){
		
	}

	/**
	 * sets a unix system date to gregorian date
	 * @return
	 */
	//TODO Low priority shift unix date to gregorian Date
	private Date toDate(){
		return null;
	}




}

package gamesOwned;

import global.Global;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import userProfile.SteamUser;

public class GameScraper {
	int gameCount;

	public GameScraper() {
		// TODO Auto-generated constructor stub
	}
	public SteamUser GameScraper(SteamUser su){
		JsonReader reader;
		try {
			reader = new JsonReader(new InputStreamReader(
					connect(Global.USERGAMEURL,su.getID()).openStream()));
			//"response:"
			reader.beginObject(); 
			//"gameCount"
			System.out.println("Game Scraper: ");
			reader.nextName(); //response
			reader.beginObject(); //"{" 
			if(reader.peek()!= JsonToken.END_OBJECT){
				System.out.println("countgames");
				su = gameCountReader(reader, su);
			}
			if(reader.peek() != JsonToken.END_OBJECT){ //has no games
				
				reader.nextName();//"games":
					reader.beginArray();
						su = gameAppReader(reader, su);
					reader.endArray();
				System.out.println("finish");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("private");
		}
		su.setGameCount(gameCount);
		return su;
	}
	/**
	 * 
	 * @param reader
	 * @param su
	 * @return 
	 * @throws IOException
	 */
	private SteamUser gameCountReader(JsonReader reader, SteamUser su) throws IOException{
		reader.nextName();
	//	System.out.println(reader.nextInt());
		int a = reader.nextInt();
		gameCount = a;
		su.setGameCount(a);
		return su;
		//su.setGameCount(a);
		//su.setGameCount(reader.nextInt());
	}
	/**
	 * Reads in either 4 or 6 elements of a game
	 * 
	 * @param reader
	 * @param su 
	 * @return 
	 * @throws IOException
	 */
	private SteamUser gameAppReader(JsonReader reader, SteamUser su) throws IOException{
		while(reader.peek() == JsonToken.BEGIN_OBJECT){
			reader.beginObject();
				int appID, PT2 = 0 , PTF ;
				reader.nextName(); //app id
				appID = reader.nextInt(); //app id int
				reader.nextName(); // "playtime_2weeks or playtime forever"
				PTF = reader.nextInt(); //time played							
				//if there are 6 elements
				if(reader.peek()!=JsonToken.END_OBJECT){
					PT2 = PTF; //swap playtime forever with playtime_2 weeks
					reader.nextName(); //playtime_forever
					PTF = reader.nextInt(); //playtime_int
				}
				//addGame(appID,PT2,PTF);
				//TODO: <!--- HERE IT IS
				AppID data = new AppID(appID, PT2, PTF);
				su.insertGame(data);
				//su.addGame(appID, PT2, PTF);
				reader.endObject();
		} // end of while look
		return su; //TODO<!--- su isn't keeping data
	}
	/**
	 * Establishes a connection
	 * 
	 * @param URL
	 * @param id
	 * @return
	 * @throws MalformedURLException
	 */
	private URL connect(String URL, long id) throws MalformedURLException{
		URL url = new URL(URL+id+"&format=json");
		System.out.println(url);
		return url;
	}
}

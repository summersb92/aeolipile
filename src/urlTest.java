import java.net.*;
import java.util.ArrayList;
import java.io.*;

import com.google.gson.stream.JsonReader;

public class urlTest {
	;
	
<<<<<<< HEAD
	public urlTest() {	}

	
	public static void main(String[] args){
		getFriends(76561197968613153L);
	}
	/**
	 * @param args
	 */
	public static void getFriends(Long toGetSteam){
=======
	ArrayList<SteamFriend> friend;
	SteamFriend data;
	//SteamFriend obj;
	public urlTest() {
		// TODO Auto-generated constructor stub
		friend = new ArrayList<SteamFriend>();
	}
	private void stream(){
>>>>>>> upstream/master
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
				
				String steamID = null, relationship = null;
				int i = 0, j = 0,friendSince = 0;
				
				while(reader.hasNext()){
					reader.beginObject();
<<<<<<< HEAD
					System.out.print(reader.nextName() + ":");
					test.addFriend(reader.nextString());
					System.out.println("Stored");
					while (reader.hasNext()){
						System.out.print(reader.nextName() + ":");
						System.out.println(reader.nextString());
						
=======
					//obj = new MyObject();
					while (reader.hasNext()){
						i = j % 3;
						//System.out.print(reader.nextName() + ":");
						String item, name;
						name = reader.nextName();
						System.out.print(name + " : ");
						item = reader.nextString();
						System.out.println(item);
						switch(i){
						case 0:
							steamID = item;
							break;
						case 1:
							relationship = item;
							break;
						case 2:
							friendSince = Integer.parseInt(item);
							break;
						}
						//System.out.println(reader.nextString());
						
						j++;
>>>>>>> upstream/master
					};
					System.out.println();
					reader.endObject();
					data = new SteamFriend(steamID, relationship, friendSince);
					friend.add(data);
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
	/**
	 * @param args
	 */
	public static void main(String[] args){
		urlTest test = new urlTest();
		test.stream();
	}

}

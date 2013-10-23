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

	public SteamGetter(){}

	private URL connect(String URL, long id) throws MalformedURLException{
		URL url = new URL(URL+id);
		return url;
	}


	public SteamUser getPlayerSummary( SteamUser su) throws IOException{
		reader = new JsonReader(new InputStreamReader(
				connect(Global.USERDATAURL,su.getID()).openStream()));

		//"response"
		reader.beginObject(); 

		//"Players"
		reader.nextName();
		reader.beginObject(); 
		reader.nextName();

		//"["
		reader.beginArray();

		//"{" Player Object
		reader.beginObject(); 
		System.out.println("New User");

		while(reader.hasNext()){
			switch (reader.nextName()){

			case "steamid":
				SteamID = reader.nextString();
				if(Global.DEBUG){
					System.out.print("ID: ");
					System.out.println(SteamID);
				}
				break;

			case "personaname": 
				personaname = reader.nextString(); //PersonaName Value
				su.setPersonaname(personaname);
				if(Global.DEBUG){
					System.out.print("Name: ");
					System.out.println(personaname);
				}
				break;

			case "profileurl":
				profileURL = reader.nextString(); //ProfileURL Value
				su.setProfileURL(profileURL);
				if(Global.DEBUG){
					System.out.print("URL: ");
					System.out.println(profileURL);
				}
				break;

			case "avatar":
				avatar32 = reader.nextString(); //"Avatar Value
				su.setAvatar32(avatar32);
				if(Global.DEBUG){
					System.out.print("32x32 Avatar: "); 
					System.out.println(avatar32);
				}
				break;

			case "avatarmedium":
				avatar64 = reader.nextString();//AvatarMedium Value
				su.setAvatar64(avatar64);
				if(Global.DEBUG){
					System.out.print("64x64 Avatar: ");
					System.out.println(avatar64);
				}
				break;

			case "avatarfull":
				avatar184 = reader.nextString(); //AvatarFull Value
				su.setAvatar184(avatar184);
				if(Global.DEBUG){
					System.out.print("184x184 Avatar: ");
					System.out.println(avatar184);
				}
				break;

			case "personastate":
				personaState = Integer.parseInt(reader.nextString());
				su.setPersonaState(personaState);
				if(Global.DEBUG){
					System.out.print("PersonaState: ");
					System.out.println(personaState);
				}
				break;

			default:
				reader.skipValue();
			}
		}
		reader.close();
		return su;
	}


	/**
	 * Gets a user's friends as an ArrayList
	 * 
	 * @param id - the user id
	 * @throws IOException 
	 */
	public ArrayList<SteamUser> userFriendData(SteamUser u) throws IOException {

		SteamUser su = u;
		URL meSteam;
		JsonReader reader;
		ArrayList<SteamUser> sf = new ArrayList<SteamUser>();

		try {
			meSteam = new URL(Global.FRIENDLISTURL + su.getID());
			try {
				reader = new JsonReader(new InputStreamReader(meSteam.openStream()));
				reader.beginObject();//JSON Object
				reader.nextName();
				reader.beginObject();//FriendList Object
				reader.nextName();
				reader.beginArray();//FriendList Array
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
					friend_since = Integer.parseInt(reader.nextString());

					//					System.out.println("steamid: "+ id);
					//					System.out.println("relationship: "+relationship);
					//					System.out.println("friend_since: "+friend_since+"\n");

					SteamUser data = new SteamUser(Long.parseLong(id));
					sf.add(data);
					reader.endObject();
				};
				reader.close();
			}catch (IOException e){
				System.out.println(e.getMessage());
				System.out.println(e.hashCode());
				//e.printStackTrace();
			} 
		}catch (MalformedURLException e1){
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}//want a finnaly statement
		return sf;
	}


	/**
	 * Gets the steam user's game data
	 * 
	 * @param userID
	 * @param gameID
	 */
	//TODO Impliment the method
	public void getSteamUserGameData(long userID, long gameID){}

	/**
	 * sets a unix system date to gregorian date
	 * @return
	 */
	//TODO Low priority shift unix date to gregorian Date
	private Date toDate(){
		return null;
	}




}

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class SteamUser {
	long steamID;
	ArrayList<SteamUser> friends;
	
	public SteamUser(long id) {
		steamID = id;
		friends = new ArrayList<SteamUser>();
	}
	
	public void addFriend(SteamUser toAdd){
		friends.add(toAdd);
	}
	
	public long getID(){
		return steamID;
	}
	
	public URL getUserURL(){
		URL profileURL = null;
		
		
		try {
			profileURL = new URL("http://steamcommunity.com/profiles/" + steamID);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return profileURL;
		
	}

	public void addFriend(String nextString) {
		friends.add(new SteamUser(Long.parseLong(nextString)));
		
	}
}

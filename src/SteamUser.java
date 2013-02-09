import java.util.ArrayList;


public class SteamUser {
	int steamID;
	ArrayList<SteamFriend> friends;
	
	public SteamUser(int id) {
		steamID = id;
		friends = new ArrayList<SteamFriend>();
	}
	
	public void addFriend(SteamFriend toAdd){
		
	}
}

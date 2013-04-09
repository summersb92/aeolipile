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
	
	public long getID() {
		return steamID;
		
	}
}

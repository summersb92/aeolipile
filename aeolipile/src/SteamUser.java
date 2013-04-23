import java.util.ArrayList;


public class SteamUser {
	long steamID;
	ArrayList<SteamUser> friends;
	byte status; //either 1 - public 0-private
	
	public SteamUser(long id) {
		steamID = id;
		friends = new ArrayList<SteamUser>();
		status = 1;
	}
	
	public void addFriend(SteamUser toAdd){
		friends.add(toAdd);
	}
	
	public long getID() {
		return steamID;
		
	}
	public void setStatus(byte i){
		status = i;
	}
	public byte getStatus(){
		return status;
	}
}

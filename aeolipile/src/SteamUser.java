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
	
	public String printFriends(){
		String to_ret = "" + steamID + ":";
		
		for (SteamUser x:friends){
			to_ret += x.getID() + ",";
		}
		
		return to_ret.substring(0,to_ret.length()-2) + "\n";
	}
}

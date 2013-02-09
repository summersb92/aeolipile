
public class SteamFriend {
	private String ID;
	private String relation;
	private int dateOfFriend;
	
	public SteamFriend(String steamID, String relationship, int friendSince) {
		ID = steamID;
		relation = relationship;
		dateOfFriend = friendSince;
	}
	
	public String getID(){
		return ID;
	}
	
	public String getRelation(){
		return relation;
	}
	
	public int getFriendSince(){
		return dateOfFriend;
	}

}

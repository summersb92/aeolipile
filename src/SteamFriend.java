import java.io.Serializable;


public class SteamFriend implements Serializable{
	private String ID;
	private String relation;
	private int dateOfFriend;
	
	
	
	public SteamFriend(String steamID, String relationship, int friendSince) {
		this.ID = steamID;
		this.relation = relationship;
		this.dateOfFriend = friendSince;
	}
	public void setID(String steamID){
		ID = steamID;
	}
	public void setRelation(String relationship){
		relation = relationship;
	}
	public void setFriendSince(int friendSince){
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
	public String toString(){
		return "steamid : "+ID +"\n"+
				"relation : "+relation+"\n"+
				"friend_since : "+dateOfFriend+"\n";
	}
}

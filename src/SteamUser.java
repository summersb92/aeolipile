package src;

import java.util.ArrayList;

public class SteamUser {
	long steamID;
	String personaname;
	String profileURL;
	String avatar32;
	String avatar64;
	String avatar184;
	int personaState;
	ArrayList<SteamUser> friends;
	byte status; //either 1 - public 0-private

	//	int friend_since;
	/**
	 * Creates a steam User
	 * 
	 * @param id - Uses the id of the user found as the key
	 * @param friend_since 
	 */
	public SteamUser(long id) {
		steamID = id;
		personaname = null;
		avatar32 = null;
		avatar64 = null;
		avatar184 = null;
		personaState = 0;
	}
	
	public SteamUser(long id,String name,String url,
			String av32,String av64,String av184,int state){
		steamID = id;
		personaname = name;
		avatar32 = av32;
		avatar64 = av64;
		avatar184 = av184;
		personaState = state;
		friends = new ArrayList<SteamUser>();
		status = 1;
	}
	
	
	/**
	 * Add's the user found to a friends list
	 * 
	 * @param toAdd
	 */
	public void addFriend(SteamUser toAdd){
		friends.add(toAdd);
	}
	

	/**
	 * Get the ID of the steam user
	 * @return - steam user ID
	 */
	public long getID() {
		return steamID;

	}
	
	
	/**
	 * Set's the Status of a user
	 * @param i - either 1(public) or 0(private)
	 */
	public void setStatus(byte i){
		status = i;
	}
	
	
	/**
	 * Gets the status of a user
	 * @return - return either 1(public) or 0(private)
	 */
	public byte getStatus(){
		return status;
	}
	

	public String toSAS_ID(){
		return steamID +","+ status+";\n";
	}
	
	public String toSASProfile(){
		return steamID +","+ personaname+", "+avatar32+", "+avatar64+
				", "+avatar184+", "+personaState+";\n";
	}
	
	
	//TODO Player Summaries
	//implement variables for
	// SteamID, personal Name, ProfileURL
	//Avatar (URL), visiblity state
	/**
	 * Player Summary generates a txt file that is SAS readable
	 * giving data about a steam user making a new line.
	 * 
	 * @return - returns a comma delimited string of the Steam ID,
	 * the users alias, profileURL, avatarURL, and privacy status.
	 */
	public String getPlayerSummary(){
		String privacy = "public";
		if(status==0){
			privacy="private";
		}
		return steamID+","+privacy+";\n";
	}
	
	
	//TODO Friends List
	//an array of friend ID's - need to know how SAS will read this.
	/**
	 * Get's a given players Friends List and makes it a string.
	 * Makes a new line at the end.
	 * @return
	 */
	public String getPlayerFriendsList(){
		String friendOutput = null;
		for(int i=0; i<friends.size(); i++){
			friendOutput = friendOutput+","+friends.get(i).getID(); 
		}
		return friendOutput+";\n";
	}
	
	
	//TODO GetOwnedGames
	//Need a sparce matrix
	//appID, name, play_time_2_week, pay_time_total
	public String getPlayerOwnedGames(){
		return null;
	}
	//TODO FromFile method, need to read from a file

	
	//	public String printFriends(){
	//		String to_ret = "" + steamID + ":";
	//		
	//		for (SteamUser x:friends){
	//			to_ret += x.getID() + ",";
	//		}
	//		
	//		return to_ret.substring(0,to_ret.length()-2) + "\n";
	//	}
}

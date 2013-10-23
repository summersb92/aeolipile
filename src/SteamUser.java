package src;

import java.util.ArrayList;

public class SteamUser {
	private long steamID;
	private String personaname;
	private String profileURL;
	private String avatar32;
	private String avatar64;
	private String avatar184;
	private int personaState;
	private ArrayList<SteamUser> friends;
	private byte status; //either 1 - public 0-private

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
		friends = new ArrayList<SteamUser>();
		status = 1;
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
	public String getPlayerFriendsListString(){
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

	public long getSteamID() {
		return steamID;
	}
	
	public String getPersonaname() {
		return personaname;
	}

	public void setPersonaname(String personaname) {
		this.personaname = personaname;
	}

	public String getProfileURL() {
		return profileURL;
	}

	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}

	public String getAvatar32() {
		return avatar32;
	}

	public void setAvatar32(String avatar32) {
		this.avatar32 = avatar32;
	}

	public String getAvatar64() {
		return avatar64;
	}

	public void setAvatar64(String avatar64) {
		this.avatar64 = avatar64;
	}

	public String getAvatar184() {
		return avatar184;
	}

	public void setAvatar184(String avatar184) {
		this.avatar184 = avatar184;
	}

	public int getPersonaState() {
		return personaState;
	}

	public void setPersonaState(int personaState) {
		this.personaState = personaState;
	}

	public ArrayList<SteamUser> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<SteamUser> friends) {
		this.friends = friends;
	}

	
}

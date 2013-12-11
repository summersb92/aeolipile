package userProfile;

import gamesOwned.AppID;
import gamesOwned.GamesList;

import java.util.ArrayList;

public class SteamUser {
	private long steamID;
	private String personaname;
	private String profileURL;
	private String avatar32;
	private String avatar64;
	private String avatar184;
	private int personaState;
	private int hoursPlayed;
	private int gamesOwned;
	private ArrayList<SteamUser> friends;
	private ArrayList<AppID> games;
	private int game_count;
	//private GamesList games;
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
		games = new ArrayList<AppID>();
		status = 1;
		game_count = 0;
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
		games = new ArrayList<AppID>();
		status = 1;
		game_count = 0;
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
		//player'sID, friendID1, friendID2,....
		String friendString="";
		for(int i=0; i<friends.size(); i++){
			friendString+=", "+friends.get(i).getSteamID();
		}
		return steamID+friendString+"\n";
	}
	public String toGameProfile() {
		// TODO Auto-generated method stub
		//player'sID, total#GamesOwned, 1,12,1,40,0,0,0,0
		String gameString="";
		for(int i=0; i<games.size(); i++){
			gameString+=games.get(i).output();
		}
		return steamID+", "+game_count+gameString+"\n";
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
	/***Methods being changed ***/
	public void insertGame(AppID addGame){
		games.add(addGame);
	}
	public void setGameCount(int nextInt) {
		// TODO Auto-generated method stub
		game_count = nextInt;
	}
	public long getGamesCount() {
		// TODO Auto-generated method stub
		System.out.println("Returned game count:"+game_count);
		return game_count;
	}
	public ArrayList<AppID> getGameList(){
		return games;
	}
	/**These Methods need to be redone**/



//	insertGame(int appID, int playtime_2weeks, int playtime_forever){
//		gameList.add(new AppID(appID,playtime_2weeks,playtime_forever));
//	}




	/**
	 * 
	 * @param game_count
	 */

	
}

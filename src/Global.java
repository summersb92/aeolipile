package src;


public class Global {

	//Titles for Columns in Header
	
	//Titles for Player Summaries
	public static final String STEAMID = "SteamID";
	public static final String PERSONA = "Personal Name";
	public static final String PROFILEURL = "Profile URL";
	public static final String AVATARURL = "Avatar URL";
	public static final String VISBILITYSTATE = "Privacy";
	//Titles for Friends Summary
	public static final String RELATION = "Relation";
	public static final String FRIENDS_SINCE = "Friends Since";
	
	//File naming conventions
	public static final String ASSETSPWD = "./assets/";
	public static final String AEOLIPILE = "aeolipile";
	
	//base user that we are connecting to
	public static final String URL ="http://api.steampowered.com/ISteamUser/" +
					"GetFriendList/v0001/?key=26A0BE6F08077299B964BBEFBAEE5AA0" +
					"&relationship=friend&format=json&steamid=";
	
	//Counter Coneventions
	public static final int COLLECTED = 100; //for while to set off new thread
	public static final String CounterS = "Entries"; //used in header for # of entries
}

package src;



public class Global {

	//
	
	//Titles for Columns in Header
	
	//Titles for Player Summaries
	public static final String STEAMID = "SteamID";
	public static final String PERSONA = "Personal Name";
	public static final String PROFILEURL = "Profile_URL";
	public static final String AVATARURL = "Avatar_URL";
	public static final String VISBILITYSTATE = "Privacy";
	public static final String PERSONASTATE = "Persona_State";
	
	//Titles for Friends Summary
	public static final String RELATION = "Relation";
	public static final String FRIENDS_SINCE = "Friends Since";
	
	//File naming conventions
	public static final String ASSETSPWD = "./assets/";
	public static final String AEOLIPILE = "aeolipile";
	
	//base user that we are connecting to
	public static final String KEY="26A0BE6F08077299B964BBEFBAEE5AA0";
	public static final String FRIENDLISTURL ="http://api.steampowered.com/ISteamUser/" +
			"GetFriendList/v0001/?key="+KEY+
			"&relationship=friend&format=json&steamid=";
	public static final String USERDATAURL="http://api.steampowered.com/ISteamUser/"+
			"GetPlayerSummaries/v0002/?key="+KEY+"&steamids=";

	
	//Counter Coneventions
	public static final int COLLECTED = 100; //for while to set off new thread
	public static final String CounterS = "Entries"; //used in header for # of entries

	public static final boolean DEBUG = false;
}

package gamesOwned;

public class AppID {
	
	private int appID;
	private int playtime_2weeks;
	private int playtime_forever;
	
	public AppID(int appID, int playtime_2weeks, int playtime_forever){
		super();
		this.appID = appID;
		this.playtime_2weeks = playtime_2weeks;
		this.playtime_forever = playtime_forever;	
	}
	public int[] returnGame(){
		int a[] = {appID, playtime_forever, playtime_2weeks, };
		return a;
	}
	public int getAppID(){
		return appID;
	}
	public int getPlayTimeF(){
		return playtime_forever;
	}
	public int getPlaytime_forever(){
		return playtime_forever;
	}
	//, appid:playtime_forever, appid:playtime_forever,
	public String output(){
		return ", "+appID+", "+playtime_forever;
	}
}

package gamesOwned;

import java.util.ArrayList;
import java.util.List;

public class GamesList {
	
	private List<AppID> gameList;
	private int game_count = 0;
	
	public GamesList(){
		gameList = new ArrayList<AppID>();
	}
	/**
	 * Adds a game to the list
	 * 
	 * @param appID
	 * @param playtime_2weeks
	 * @param playtime_forever
	 */
	public void insertGame(int appID, int playtime_2weeks, int playtime_forever){
		gameList.add(new AppID(appID,playtime_2weeks,playtime_forever));
	}
	/**
	 * Outputs the entire AppID list as String
	 * 
	 * @return ", appid:playtime_forever"
	 */
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		for(AppID games : gameList){
			stringBuilder.append(games.output());
		}
		String finalString = stringBuilder.toString();
		return game_count+" "+finalString +"\n";
	}
	/**
	 * Gets the game count of a game list
	 * 
	 * @return
	 */
	public int getGameCount(){
		return game_count;
	}
	/**
	 * 
	 * @return total hours played over an entire profile
	 */
	public int getTotalHours(){
		int total = 0;
		for (AppID hours : gameList) {
		      total = total + hours.getPlaytime_forever();
		}
		return total;
	}
	public void setGameCount(int game_count){
		System.out.println(game_count);
		this.game_count = game_count;
	}
}

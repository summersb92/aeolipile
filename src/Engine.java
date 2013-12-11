package src;

import gamesOwned.GameScraper;

import java.util.*;
import java.io.*;

import userProfile.SteamUser;

public class Engine {

	Outfile out;
	public static long startID = 76561197968613153l; //Royalaid
	ArrayList<SteamUser> output;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
        Engine engine = new Engine();
        engine.startEngine(startID);
	}
	
	
	//Constructor
	public Engine(){
	}
	
	//Starts the program using a given user ID
	public void startEngine(long startID) throws IOException{
		AppListLoader AppList = new AppListLoader();
	//	AppList.applicationList();
//		BufferedWriter bw;
//		FileWriter fw;
//		File file, gameFile;
//		Calendar now;
		
		List<String> gameList = new ArrayList();
		List<String> friendList = new ArrayList();
		LinkedList<SteamUser> queue = new LinkedList<SteamUser>();
		//TODO Find a better purpose for the HashMap
		HashMap<Long, SteamUser> scrapedUsers = new HashMap<Long, SteamUser>(); 
		SteamGetter getter = new SteamGetter();
		out = new Outfile();
		out.newMasterList(AppList.applicationList());
		try {
//			PrintWriter pw = new PrintWriter(new FileWriter("SteamUsers.txt"));
			queue.add(new SteamUser(startID)); //Add first user
			while(!queue.isEmpty()){
				//TODO all locked up in curUser
				SteamUser curUser = queue.removeFirst();//gets a single individuals Profile info
				if(!scrapedUsers.containsKey(curUser.getID())){
					curUser = getter.getPlayerSummary(curUser); //Data stillholds
					ArrayList<SteamUser> friends = getter.userFriendData(curUser);
					//output = new ArrayList<SteamUser>();
					for(SteamUser freind: friends){
						queue.add(freind);
						curUser.addFriend(freind);
//						output.add(freind);
						//friends.add(freind);
//						pw.println(curUser.getID());
//						pw.flush();
//						out = new Outfile(freind);
						scrapedUsers.put(curUser.getID(), curUser);
						
				//		System.out.println(curUser.getID() + " scraped");
					}
					gameList.add(curUser.toGameProfile());
					friendList.add(curUser.toSASProfile());
					//out.newGameLine(curUser.toSASProfile());
					//out.newProfileLine(curUser.toGameProfile());
					
					scrapedUsers.put(curUser.getID(), curUser);
					System.out.println(curUser.getID() + " scraped");
				}
				out.GameListFile(gameList);
				out.FriendListFile(friendList);
				//PlayerID, totalGames, 4545Owned, 4545THours, 4546Owned, 4546THours, 12Owned, 12THours, 12567Owned, 12567THours
				//player'sID, total#GamesOwned, 1,12,1,40,0,0,0,0
				//player'sID2, total#GamesOwned, 0,0,0,0,1,24,1,52
				out.MasterList(curUser,AppList.applicationList());
				//AppList.applicationList();
				//output.add(0, curUser);
			}
//			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

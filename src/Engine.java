package src;

import java.util.*;
import java.io.*;

public class Engine {

	
	public static long startID = 76561197968613153l; //Royalaid
	/**
	 * @param args
	 */
	public static void main(String[] args) {
        Engine engine = new Engine();
        engine.startEngine(startID);
	}
	//Constructor
	public Engine(){
		
	}
	//Starts the program using a given user ID
	public void startEngine(long startID){
		
		LinkedList<SteamUser> queue = new LinkedList<SteamUser>();
		HashMap<Long, SteamUser> scrapedUsers = new HashMap<Long, SteamUser>(); 
		Scraper scrape = new Scraper();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("SteamUsers.txt"));
			queue.add(new SteamUser(startID)); //Add first user
			
			while(!queue.isEmpty()){
				
				SteamUser curUser = queue.removeFirst();
				if(!scrapedUsers.containsKey(curUser.getID())){ //TODO fix
					//System.out.println("checked");
					ArrayList<SteamUser> friends = scrape.scrapeUser(curUser);
					for(SteamUser freind: friends){
						queue.add(freind);
						curUser.addFriend(freind);
						pw.println(curUser.getID());
						pw.flush();
						scrapedUsers.put(curUser.getID(), curUser);
						System.out.println(curUser.getID() + " scraped");
					} 
					pw.println(curUser.getID());
					pw.flush();
					
					scrapedUsers.put(curUser.getID(), curUser);
					System.out.println(curUser.getID() + " scraped");
					
				}
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}

import java.util.*;
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
		queue.add(new SteamUser(startID));
		while(!queue.isEmpty()){
			
			SteamUser curUser = queue.removeFirst();
			if(!scrapedUsers.containsKey(curUser.getID())){ //TODO fix
				//System.out.println("checked");
				ArrayList<SteamUser> friends = scrape.scrapeUser(curUser);
				for(SteamUser freind: friends){
					queue.add(freind);
					curUser.addFriend(freind);
				}
				
				scrapedUsers.put(curUser.getID(), curUser);
				System.out.println(curUser.getID() + " scraped");
			}
		}
		
	}
	

}

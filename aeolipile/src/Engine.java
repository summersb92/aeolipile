import java.util.*;
public class Engine {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public void startEngine(long startID){
		LinkedList<SteamUser> queue = new LinkedList<SteamUser>();
		HashMap<Long, SteamUser> scrapedUsers = new HashMap<Long, SteamUser>(); 
		Scraper scrape = new Scraper();
		queue.add(new SteamUser(startID));
		while(!queue.isEmpty()){
			SteamUser curUser = queue.removeFirst();
			if(scrapedUsers.containsKey(curUser.getID())){
				ArrayList<SteamUser> friends = scrape.scrapeUser(curUser);
				for(SteamUser freind: friends){
					queue.add(freind);
					curUser.addFriend(freind);
				}
				
				scrapedUsers.put(curUser.getID(), curUser);
				
			}
		}
		
	}
	

}

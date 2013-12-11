package src;

import global.Global;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import userProfile.SteamProfile;
import userProfile.SteamUser;

/***
 * Outfile manages all the output file formats. Needs to be readable
 * by SASS, Excel, and the program itself.
 * 
 * @author summersb
 *
 */


public class Outfile extends Thread{
	BufferedWriter bw,masterbw;
	FileWriter fw, masterFW;
	File friendFile, gameFile, masterFile;
	Calendar now;
	int tempGameTime;
	/**
	 * Constructor for the Outfile class. Generates or edits the
	 * file being used for the day.
	 * 
	 * @throws IOException
	 */
	public Outfile() throws IOException {
		
		
//		now = Calendar.getInstance();
////		File dir = new File (Global.ASSETSPWD);//set the directory address
//		String Date = now.get(Calendar.YEAR)+
//				"_"+now.get(Calendar.MONTH)+
//				"_"+now.get(Calendar.DAY_OF_MONTH);
//		file = new File( 			
//				Global.AEOLIPILE+
//				"_"+Date+".txt");
//		
//		if (!file.exists()) {
//			file.setWritable(true);
//			file.setReadable(true);
//			file.createNewFile();
//			
//		//	editFile(friend);
//		}
//		gameFile = new File(Global.SAVEGAMELIST+"_"+Date+".txt");
//		if (!gameFile.exists()) {
//			gameFile.setWritable(true);
//			gameFile.setReadable(true);
//			gameFile.createNewFile();
//			
//		//	editFile(friend);
//		}
//		fw = new FileWriter(file.getAbsoluteFile());
//		bw = new BufferedWriter(fw);
//	//	generateFile(friend);
//		bw.flush();
//		bw.close();
//		fw = new FileWriter(gameFile.getAbsoluteFile());
//		bw = new BufferedWriter(fw);
//	//	generateGameFile(friend);
//		bw.flush();
//		bw.close();
	}




	/**
	 * Generate file creates the initial header set up of a file if
	 * it has not been created yet.
	 * 
	 * @param friend
	 * @throws IOException
	 */
	//No spaces allowed for sas
	private void generateFile(ArrayList<SteamUser> friend)
			throws IOException{
		
//		bw.write(Global.CounterS+":"+counter+"\n");
		bw.write(Global.STEAMID+","+Global.RELATION+","
			+Global.FRIENDS_SINCE+";\n");
		editFile(friend);
	}
	
	private void generateGameFile() throws IOException {
		// TODO Auto-generated method stub
		bw.write("gamesOwned:\n");
	}
	
	/**
	 * appends to the end of a file.
	 * 
	 * @param friend
	 * @throws IOException
	 */
	private void editFile(ArrayList<SteamUser> friend) throws IOException{
		//Organization of stats are
		//Steam ID, PersonalName, personaState, friends list
		for(int i=0; i<friend.size(); i++){
			bw.append(friend.get(i).toSASProfile()+friend.get(i).getPlayerFriendsListString());
		}
	}
	
	/**
	 * Geneartes the game File
	 * @param friend
	 * @throws IOException
	 */
	private void editGameFile(ArrayList<SteamUser> friend) throws IOException{
		for(int i=0; i<friend.size(); i++){
			//String output = friend.get(i).getID()+", GameCount:"+friend.get(i).getPersonaname()+"\n";
			String output = friend.get(i).getID()+", GameCount:"+friend.get(i).getGamesCount();
			System.out.println(output);
			bw.append(output);
		}
	}



	public void newGameLine(String sasProfile) {
		// TODO Auto-generated method stub
		System.out.println(sasProfile);
	}

	
	public void newProfileLine(String gameProfile) {
		// TODO Auto-generated method stub
		System.out.println(gameProfile);
		
	}
	public void GameListFile(List<String> gameList) throws IOException{

		now = Calendar.getInstance();
//		File dir = new File (Global.ASSETSPWD);//set the directory address
		String Date = now.get(Calendar.YEAR)+
				"_"+now.get(Calendar.MONTH)+
				"_"+now.get(Calendar.DAY_OF_MONTH);
		gameFile = new File(Global.SAVEGAMELIST+"_"+Date+".txt");
		
		if (!gameFile.exists()) {
			gameFile.setWritable(true);
			gameFile.setReadable(true);
			try {
				gameFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
//		end of if
		fw = new FileWriter(gameFile.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		generateGameFile();
		for(int i=0; i<gameList.size();i++ ){
			System.out.println(gameList.get(i).toString());
			bw.append(gameList.get(i).toString());
		}
		bw.flush();
		bw.close();

	}




	public void FriendListFile(List<String> friendList) throws IOException {
		now = Calendar.getInstance();
//		File dir = new File (Global.ASSETSPWD);//set the directory address
		String Date = now.get(Calendar.YEAR)+
				"_"+now.get(Calendar.MONTH)+
				"_"+now.get(Calendar.DAY_OF_MONTH);
		friendFile = new File(Global.AEOLIPILE+"_"+Date+".txt");
		
		if (!friendFile.exists()) {
			friendFile.setWritable(true);
			friendFile.setReadable(true);
			try {
				friendFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
//		end of if
		fw = new FileWriter(friendFile.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		generateFriendFile();
		for(int i=0; i<friendList.size();i++ ){
			System.out.println(friendList.get(i).toString());
			bw.append(friendList.get(i).toString());
		}
		bw.flush();
		bw.close();

		
	}




	private void generateFriendFile() throws IOException {
		bw.write(Global.STEAMID+","+Global.RELATION+","
				+Global.FRIENDS_SINCE+";\n");		
	}




	public void MasterList(SteamUser curUser, List<String> applicationList) throws IOException {
		//player'sID, total#GamesOwned, 1,12,1,40,0,0,0,0
		masterbw.write(String.valueOf(curUser.getID())+", "+String.valueOf(curUser.getGamesCount()));
		
		for(int i=0; i<applicationList.size();i++){		
//			for(int j=0; j<curUser.getGameList().get(j).getAppID();j++){
////				if(Integer.parseInt(applicationList.get(i)) == curUser.getGameList().get(j).getAppID()){
////					
////				}
//			}
			if(gameCheck(applicationList.get(i), curUser)){
				masterbw.append(", 1, "+tempGameTime);
			}else{
				masterbw.append(", 0, 0");
			}
		}
		masterbw.newLine();
		masterbw.flush();
		System.out.println("New Line");
	}



	private boolean gameCheck(String string, SteamUser curUser) {
		// TODO Auto-generated method stub
		for(int i=0; i<curUser.getGameList().size(); i++){
			if(curUser.getGameList().get(i).getAppID() == Integer.parseInt(string)){
				tempGameTime = curUser.getGameList().get(i).getPlaytime_forever();
				return true;
			}
		}
		return false;
	}




	private Object gameCheck(List<String> applicationList) {
		// TODO Auto-generated method stub
		return null;
	}




	public void newMasterList(List<String>  appList) throws IOException {
		now = Calendar.getInstance();
//		File dir = new File (Global.ASSETSPWD);//set the directory address
		String Date = now.get(Calendar.YEAR)+
				"_"+now.get(Calendar.MONTH)+
				"_"+now.get(Calendar.DAY_OF_MONTH);
		masterFile = new File("MasterList"+"_"+Date+".txt");
		
		if (!masterFile.exists()) {
			masterFile.setWritable(true);
			masterFile.setReadable(true);
			try {
				masterFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
//		end of if
		masterFW = new FileWriter(masterFile.getAbsoluteFile());
		masterbw = new BufferedWriter(masterFW);
//		generateFriendFile();
		String AppHeader = "PlayerID, totalGames";
		masterbw.append(AppHeader);
		//PlayerID, totalGames, 4545Owned, 4545THours, 4546Owned, 4546THours, 12Owned, 12THours, 12567Owned, 12567T
		for(int i=0; i<appList.size();i++){
			masterbw.append(", "+appList.get(i)+":Owned, "+appList.get(i)+":Hours");
		}
		masterbw.append("\n");
		//bw.append(AppHeader);
		System.out.println("New Master List");
		masterbw.flush();
		//masterbw.close();
		
	}
	

}

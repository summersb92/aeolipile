package src;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

/***
 * Outfile manages all the output file formats. Needs to be readable
 * by SASS, Excel, and the program itself.
 * 
 * @author summersb
 *
 */
public class Outfile extends Thread{
	BufferedWriter bw;
	FileWriter fw;
	File file;
	Calendar now;
	/**
	 * Constructor for the Outfile class. Generates or edits the
	 * file being used for the day.
	 * 
	 * @param friend - receives an arraylist of SteamFriends
	 * @throws IOException
	 */
	public Outfile(ArrayList<SteamUser> friend) throws IOException {
		now = Calendar.getInstance();
//		File dir = new File (Global.ASSETSPWD);//set the directory address
		file = new File( 			
				Global.AEOLIPILE+
				"_"+now.get(Calendar.YEAR)+
				"_"+now.get(Calendar.MONTH)+
				"_"+now.get(Calendar.DAY_OF_MONTH)+".txt");
//				file = new File(dir, 			
//				Global.AEOLIPILE+
//				"_"+now.get(Calendar.YEAR)+
//				"_"+now.get(Calendar.MONTH)+
//				"_"+now.get(Calendar.DAY_OF_MONTH)+".txt");
		if (!file.exists()) {
			file.setWritable(true);
			file.setReadable(true);
			file.createNewFile();
			
		//	editFile(friend);
		}
		fw = new FileWriter(file.getAbsoluteFile());
		bw = new BufferedWriter(fw);
		generateFile(friend);
		bw.flush();
		bw.close();
	}

	/**
	 * Generate file creates the initial header set up of a file if
	 * it has not been created yet.
	 * 
	 * @param friend
	 * @throws IOException
	 */
	private void generateFile(ArrayList<SteamUser> friend)
			throws IOException{
		
//		bw.write(Global.CounterS+":"+counter+"\n");
		bw.write(Global.STEAMID+","+Global.RELATION+","
			+Global.FRIENDS_SINCE+";\n");
		editFile(friend);
	}
	/**
	 * appends to the end of a file.
	 * 
	 * @param friend
	 * @throws IOException
	 */
	private void editFile(ArrayList<SteamUser> friend) throws IOException{
//Organization of stats are
		//Steam ID, PersonalName, profileurl, avatar(get url for image),visibility status, lastlogoff
		for(int i=0; i<friend.size(); i++){
			bw.append(friend.get(i).toSAS());
		}
		/**Need to look Owned Games **/
		
		//bw.write();
		
		
		
//		 * ID:
//			 * Start date:
//			 * Profile Name:
//			 * Game hrs total:
//			 * Games
//			 * game id_hrs total
//			 * game owned Y/N
//			 * gameId_value - cost at pull(??????)
//			 * Achievements ?????
//			 * 

	}
}

package src;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppListLoader {

	List<String> appIDList = new ArrayList();
	public AppListLoader(){
		try{
			  // Open the file that is the first 
			  // command line parameter
		     
			  FileInputStream fstream = new FileInputStream("listOfApps.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
				  String[] test = strLine.split(",");
				  appIDList.add(test[0]);
			  System.out.println (strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			}
	}

	public List<String> applicationList() {
		// TODO Auto-generated method stub
		return appIDList;
	}
	public String appHeader(){
		String output = "";
		for(int i=0; i<appIDList.size();i++){
			output = output+", "+appIDList.get(i);
		}
		return output;
		
	}
}

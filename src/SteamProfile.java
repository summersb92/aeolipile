package src;

import java.util.ArrayList;

public class SteamProfile {

	long SteamID;
	String personaname;
	String profileURL;
	String avatar32;
	String avatar64;
	String avatar184;
	int personaState;

	public SteamProfile(long id,String name,String url,
			String av32,String av64,String av184,int state){
		SteamID = id;
		personaname = name;
		avatar32 = av32;
		avatar64 = av64;
		avatar184 = av184;
		personaState = state;

	}
	
	
	public String toSaSProfile(){
		return SteamID +","+ personaname+", "+avatar32+", "+avatar64+
				", "+avatar184+", "+personaState+";\n";
	}

}

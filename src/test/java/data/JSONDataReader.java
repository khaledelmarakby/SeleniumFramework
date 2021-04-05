package data;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONDataReader 
{
	public String firstname;
	public String lastname;
	public String email;
	public String password;
	
	public void JsonReader() throws IOException, ParseException
	{
		String filepath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
		
		File srcfile=new File(filepath);
		FileReader read=new FileReader(srcfile);
		JSONParser parser=new JSONParser();
		JSONArray jarray=(JSONArray) parser.parse(read);
		
		for(Object jsonobj:jarray)
		{
			JSONObject person=(JSONObject) jsonobj;
			 firstname=(String) person.get("firstname");
			lastname=(String) person.get("lastname");
			email=(String) person.get("email");
			password=(String) person.get("password");
		}
	}




}



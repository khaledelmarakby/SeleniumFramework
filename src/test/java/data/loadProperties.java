package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class loadProperties {

	public static Properties Userdata = LoadProperties(System.getProperty("user.dir")+
			"/src/main/java/PropertiesFile/Userdata.properties");
	
	private static Properties LoadProperties(String path)
	{
		Properties pro=new Properties();
		try {
			FileInputStream file=new FileInputStream(path);
			pro.load(file);
		} catch (FileNotFoundException e) {
			
			System.out.println("Error file not found  "+e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Error file not found  "+e.getMessage());
		}
		
		return pro;
	}
}
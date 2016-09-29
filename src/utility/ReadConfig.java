package utility;

import java.io.*;
import java.util.Properties;

/**
 * @author Jackson Murrell on Sep 22, 2016
 */
public class ReadConfig
{
	public static final String WIDGETS = "widgetsOn";
	
	private FileInputStream input;
	private Properties properties;
	private static final String	FILE_PATH = "Omnia-Config.properties";

	public ReadConfig() throws IOException
	{
		try
		{
			properties = new Properties();
			input = new FileInputStream(FILE_PATH);
			properties.load(input);
		}
		catch(IOException | NullPointerException exception)
		{
			new ConfigFile(FILE_PATH);
		}
	}
	public boolean readPropertyBool(String propertyToRead)
	{
		String returnedProperty = properties.getProperty(propertyToRead);
		System.out.println(returnedProperty);
		if(returnedProperty.equalsIgnoreCase("true"))
		{
			return true;
		}
		else if(returnedProperty.equalsIgnoreCase("false"))
		{
			return false;
		}
		else
			throw new IllegalArgumentException();
	}
}
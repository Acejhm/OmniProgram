package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

/**
 * @author Jackson Murrell on Jan 24, 2016
 */
public class ConfigurationFile
{
	String fileLocation;
	File file;
	FileInputStream stream;

	public ConfigurationFile(String fileLocation)
	{
		try
		{
			this.fileLocation = fileLocation;
			file = new File(fileLocation);
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param propertyName
	 * @return byte 1 if the given property is true, 0 if it's false, 
	 * 				and -1 if it wasn't found.
	 */
//	public byte getProperty(String propertyName)
//	{
//		try
//		{
//			BinarySearch.binarySearch(filePath, value, configFile, ignoreCase);
//		} catch (FileNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return 0;
//	}
}

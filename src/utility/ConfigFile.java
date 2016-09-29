package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jackson Murrell on Sep 22, 2016
 */
public class ConfigFile
{
	private String filePath;
	private File file;
	private FileOutputStream output;
	private Properties properties;

	public ConfigFile(String filePath) throws IOException
	{
		System.out.println("In configFile constructor");
		this.filePath = filePath;
		properties = new Properties();
		file = new File(filePath);
		file.createNewFile();
		output = new FileOutputStream(filePath);

		properties.setProperty(ReadConfig.WIDGETS, "false");
		properties.store(output, null);
		output.close();
	}
}
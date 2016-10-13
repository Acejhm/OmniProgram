package utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

/**
 * @author Jackson Murrell on Sep 22, 2016
 */
public class ConfigFile
{
	private String filePath;
	private File file;
	private FileOutputStream output;
	private Properties properties;

	public ConfigFile(String filePath)
	{
		try
		{
			this.filePath = filePath;
			properties = new Properties();
			file = new File(filePath);
			file.createNewFile();
			output = new FileOutputStream(filePath);

			properties.setProperty(ReadConfig.WIDGETS, "false");
			properties.store(output, null);
			output.close();	
		}
		catch(IOException exception)
		{
			//This should only happen if the user ran out of space in the folder or something.
			//Basically, this is incredibly unlikely to error.
			exception.printStackTrace();
			JOptionPane.showMessageDialog(null, "Configuration file was unable to be created.\n" + exception.getMessage(), "Severe File Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
package launcher;

import java.awt.event.WindowAdapter;

/**
 * @author Jackson Murrell on Nov 26, 2015
 */
public class WindowListener extends WindowAdapter
{
	 @Override
	 public void windowClosing(java.awt.event.WindowEvent windowEvent)
	 {
		 System.exit(0);
	 }
}

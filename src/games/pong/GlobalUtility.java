package games.pong;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author Jackson Murrell on Mar 19, 2016
 */
public final class GlobalUtility
{
	public static boolean replayQuery(Component panel)
	{
		int answer = JOptionPane.showConfirmDialog(panel, "Would you like to play again?", "Replay?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if(answer == JOptionPane.YES_OPTION)
			return true;
		else
			return false;
	}
}

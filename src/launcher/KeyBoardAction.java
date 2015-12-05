package launcher;

import java.awt.event.ActionEvent;
import javax.swing.*;

import games.pong.Racquet;

public class KeyBoardAction extends AbstractAction
{
	String key;
	Racquet racquetClass;
	
	public KeyBoardAction(String key, Racquet racquetClass)
	{
		this.key = key;
		this.racquetClass = racquetClass;
	}
	
	@Override
	public void actionPerformed(ActionEvent action) 
	{
		if(key.equalsIgnoreCase("leftArrow"))
		{
			racquetClass.changeDirection(key);
		}
		if(key.equalsIgnoreCase("leftArrowReleased"))
		{
			racquetClass.stopMovement();
		}
		if(key.equalsIgnoreCase("rightArrow"))
		{
			racquetClass.changeDirection(key);
		}
		if(key.equalsIgnoreCase("rightArrowReleased"))
		{
			racquetClass.stopMovement();
		}
		
	}

}

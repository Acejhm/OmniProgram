package games.pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet 
{
    private AnimationPanel panel;

    private int xCoordinate = 0;

    //0 = no movement, 1 is right, -1 is left.
    private byte direction = 0;

    //All of the following values are in pixels.
    private final static byte PADDLE_OFFSET = 100;
    private final static byte PADDLE_WIDTH = 120;
    private final static byte PADDLE_HEIGHT = 10;

    public Racquet(AnimationPanel panel) 
    {
        this.panel = panel;
    }
    public void moveRacquet() 
    {
        if (xCoordinate + direction > 0 && xCoordinate + direction < panel.getWidth()-60)
            xCoordinate = xCoordinate + direction;
    }

    public void paint(Graphics2D g) 
    {
        g.fillRect(xCoordinate, getPaddleHeight(), PADDLE_WIDTH, PADDLE_HEIGHT);
        //move();
    }

    public void changeDirection(String key)
    {
    	if(key.equalsIgnoreCase("leftArrow"))
		{
			direction = -1;
		}
		if(key.equalsIgnoreCase("rightArrow"))
		{
			direction = 1;
		}
    }
    
    public void stopMovement()
    {
        direction = 0;
    }

    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            direction = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            direction = 1;
    }

    public Rectangle getBounds() 
    {
        return new Rectangle(xCoordinate, getPaddleHeight(), PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    public int getPaddleHeight()
    {
        return panel.getHeight() - PADDLE_OFFSET;
    }
}

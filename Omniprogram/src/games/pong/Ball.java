package games.pong;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball 
{
    int xCoordinate = 0;
    int yCoordinate = 0;

    //1 = right movement, -1 = left
    int xDirection = 1;
    int yDirection = 1;
    private final static byte ballWidth = 30;
    private final static byte ballHeight = 30;

    private AnimationPanel panel;

    public Ball(AnimationPanel panel)
    {
        this.panel = panel;
    }

    public void paint(Graphics2D g2d)
    {
        //This creates the actual circle with a specified width and height.
        //Because super.paint(g) is called at the start, a new circle is created each time.
        g2d.fillOval(xCoordinate, yCoordinate, ballWidth, ballHeight);
    }
        //What this method does is add 1 to the x and y coordinates each time it's called.  However, getWidth() and getHeight() are used to determine the current panel size, not the frame size.
        //Then, whatever the width and/or height is is subtracted so the circle does not completely disappear from view.
        public void moveBall() 
        {
            if (xCoordinate + xDirection < 0)
            {
                xDirection = 1;
            }
            else if (xCoordinate + xDirection > panel.getWidth() - ballWidth)
            {
                xDirection = -1;
            }

            if (yCoordinate + yDirection < 0)
            {
                yDirection = 1;
            }
            else if (yCoordinate + yDirection > panel.getHeight() - ballHeight)
            {	
            	//Once this gets called the animation timer ends, and the program exits.
                panel.gameOver();
            }

            if (collision() == true)
            {
                yDirection = -1;
                yCoordinate = panel.racquetClass.getPaddleHeight() - ballHeight;
                panel.subtractTime();
            }
            xCoordinate = xCoordinate + xDirection;
            yCoordinate = yCoordinate + yDirection;
        }
        public Rectangle getBounds() 
        {
            return new Rectangle(xCoordinate, yCoordinate, ballWidth, ballHeight);
        }
        private boolean collision() 
        {
            return panel.racquetClass.getBounds().intersects(getBounds());
        }
}
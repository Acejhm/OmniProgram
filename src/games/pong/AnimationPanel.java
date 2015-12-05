package games.pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import launcher.KeyBoardAction;

@SuppressWarnings("serial")
public class AnimationPanel extends JPanel
{   
	private ActionMap actionMap;
    private InputMap inputMap;
    
	private byte animationSpeed;
	public Timer timer;
    private PongMainGUI frame;
    private Ball ballClass;
    public Racquet racquetClass;
    private boolean bool = false;
	private boolean progressiveBool;
	
	private final byte condition = JComponent.WHEN_IN_FOCUSED_WINDOW;

    public AnimationPanel(PongMainGUI frame, byte animationSpeed, boolean progressiveBool)
    {
        this.frame = frame;
        this.animationSpeed = animationSpeed;
        this.progressiveBool = progressiveBool;

        //This is needed to ensure that the keyboard will register properly and receive focus.
        setFocusable(true);
        
        ballClass = new Ball(this);
        racquetClass = new Racquet(this);
        
        actionMap = getActionMap();
        inputMap = getInputMap(condition);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "leftArrowReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightArrow");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "rightArrowReleased");
        actionMap.put("leftArrowReleased", new KeyBoardAction("leftArrowReleased", racquetClass));
        actionMap.put("leftArrow", new KeyBoardAction("leftArrow", racquetClass));
        actionMap.put("rightArrowReleased", new KeyBoardAction("rightArrowReleased", racquetClass));
        actionMap.put("rightArrow", new KeyBoardAction("rightArrow", racquetClass));
        
        timer = new Timer(animationSpeed, new ActionListener()
        {
           public void actionPerformed(ActionEvent action)
           {
        	  repaint();
              move();
           }
        });
        timer.start();
    }

    public void subtractTime()
    {
    	if(progressiveBool == true)
    	{
    		timer.setDelay(timer.getDelay() - 1);
    	}
    	System.out.println("in subtractTime");
    }
    
    public void move()
    {
        ballClass.moveBall();
        racquetClass.moveRacquet();
    }

    @Override
    public void paint(Graphics g) 
    {
        //This method clears the panel so it appears as if the circle is moving.
        super.paint(g);

        //Better version of Graphics.
        Graphics2D g2d = (Graphics2D) g;

        //This method turns antialiasing on, which cleans up the corners.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ballClass.paint(g2d);
        racquetClass.paint(g2d);
    }
    public void gameOver()
    {
    	timer.stop();
        JOptionPane.showMessageDialog(null, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        frame.dispose();
    }

}
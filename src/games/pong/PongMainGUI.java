package games.pong;

import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PongMainGUI extends JFrame implements ActionListener
{	
	private AnimationPanel animationPanel;
	
	private final byte EASY_SPEED = 10;
	private final byte NORMAL_SPEED = 6;
	private final byte HARD_SPEED = 5;

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 600;

    //This value will be the starting speed, but each hit reduces the timer delay by one.
    private byte progressiveSpeed = 10;
    
    public static Timer timer;
    
    //This is set to normal since the normal difficulty is the default option.
	private byte animationSpeed = NORMAL_SPEED;
	
    private boolean progressiveBool = false;
    
    private JLabel text;
    private JButton start, quit;
    private JPanel selectionPanel, difficultyPanel;
    private JRadioButton easy, normal, hard, progressive;
    private ButtonGroup difficultySelection;

    public PongMainGUI()
    {
        //This line sets the title, and, since it calls the super constructor, it calls setTitle().
        super("Pong!");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //This method simply makes the screen appear in the center of whatever size screen you are using.
        setLocationRelativeTo(null);

        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        
        difficultyPanel = new JPanel();
        selectionPanel = new JPanel();
        
        start = new JButton("Start");
        start.addActionListener(this);
        
        quit = new JButton("Quit");
        quit.addActionListener(this);
        
        text = new JLabel("Select your difficulty below:");
        
        easy = new JRadioButton("Easy");
        easy.addActionListener(this);
        
        normal = new JRadioButton("Normal");
        normal.addActionListener(this);
        normal.setSelected(true);
        
        
        hard = new JRadioButton("Hard");
        hard.addActionListener(this);
        
        progressive = new JRadioButton("Progressive");
        progressive.addActionListener(this);
        
        difficultySelection = new ButtonGroup();
        
        difficultySelection.add(easy);
        difficultySelection.add(normal);
        difficultySelection.add(hard);
        difficultySelection.add(progressive);

        difficultyPanel.add(easy);
        difficultyPanel.add(normal);
        difficultyPanel.add(hard);
        difficultyPanel.add(progressive);
        
        selectionPanel.add(text);
        selectionPanel.add(difficultyPanel);
        selectionPanel.add(start);
        selectionPanel.add(quit);
        
        add(selectionPanel);
//add(new AnimationPanel(this, (byte)10, true));
        
        setVisible(true);
        setFocusable(false);
    }
    @Override
	public void actionPerformed(ActionEvent action) 
    {
    	if(action.getSource() == start)
    	{
    		remove(selectionPanel);
    		animationPanel = new AnimationPanel(this, animationSpeed, progressiveBool);
    		add(animationPanel);
    		animationPanel.setFocusable(true);
    		animationPanel.requestFocus();
    		setVisible(true);
    	}
    	else if(action.getSource() == easy)
		{
			animationSpeed = EASY_SPEED;
		}
		else if(action.getSource() == normal)
		{
			animationSpeed = NORMAL_SPEED;
		}
		else if(action.getSource() == hard)
		{
			animationSpeed = HARD_SPEED;
		}
		else if(action.getSource() == progressive)
		{
			animationSpeed = progressiveSpeed;
			progressiveBool = true;
		}
		else if(action.getSource() == quit)
		{
			dispose();
		}
	}
}    
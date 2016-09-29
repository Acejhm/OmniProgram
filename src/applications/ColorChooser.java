package applications;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import applications.menus.ColorChooserMenu;
import utility.MathExtended;

/**
 * @author Jackson Murrell on Jan 1, 2016
 */
public class ColorChooser extends JFrame implements ChangeListener
{
	public JColorChooser advancedChooser;
	public JPanel mainPanel;
	
	private JPanel colorPanel, sliderPanel, infoPanel, controlPanel;
	private JSlider redSlider, blueSlider, greenSlider;
	private JLabel rgb, hexadecimal;
	private short redValue, blueValue, greenValue;
	private GridLayout horizontalLayout, verticalLayout;
	private Dimension dimension;
	private Border lineBorder;
	
	//Define all the constants to be used throughout the program.
	private static final byte GRID_ROWS 		= 1;
	private static final byte GRID_COLUMNS 		= 3;
	private static final byte VERTICAL_SPACING 	= 75;
	private static final byte HORIZAONTAL_SPACING = 10;
	private static final byte DIMENSION_WIDTH 	= 100;
	private static final byte DIMENSION_HEIGHT 	= 100;
	private static final short INITIAL_VALUE 	= 0;
	private static final short MAX_VALUE 		= 255;
	private static final byte MIN_VALUE 		= 0;
	private static final byte MAJOR_TICK_SPACING = 50;
	private static final byte MINOR_TICK_SPACING = 10;
	private static final short WINDOW_LENGTH	= 400;
	private static final short WINDOW_WIDTH		= 800;
	private static final String	TITLE			= "Color Chooser";

	public ColorChooser()
	{
		super(TITLE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_LENGTH);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		horizontalLayout = new GridLayout(GRID_ROWS, GRID_COLUMNS);
		verticalLayout = new  GridLayout(GRID_COLUMNS, GRID_ROWS);
		dimension = new Dimension(DIMENSION_WIDTH, DIMENSION_HEIGHT);
		
		mainPanel = new JPanel();
		sliderPanel = new JPanel();
		colorPanel = new JPanel();
		colorPanel.setPreferredSize(dimension);
		infoPanel = new JPanel();
		controlPanel = new JPanel();
		
		advancedChooser = new JColorChooser();
		redSlider = new JSlider(JSlider.HORIZONTAL, MIN_VALUE, MAX_VALUE, INITIAL_VALUE);
		blueSlider = new JSlider(JSlider.HORIZONTAL, MIN_VALUE, MAX_VALUE, INITIAL_VALUE);
		greenSlider = new JSlider(JSlider.HORIZONTAL, MIN_VALUE, MAX_VALUE, INITIAL_VALUE);
		
		redValue = (short) redSlider.getValue();
		blueValue = (short) blueSlider.getValue();
		greenValue = (short) greenSlider.getValue();
		
		colorPanel.setBackground(new Color(redValue, blueValue, greenValue));
		colorPanel.setBorder(lineBorder);
		
		rgb = new JLabel("Red: " + redValue + " Green: " + greenValue + " Blue: " + blueValue);
		hexadecimal = new JLabel("Hexadecimal: " + String.format("#%02X%02X%02X", redValue, greenValue, blueValue));
		
		redSlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
		redSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
		redSlider.setPaintTicks(true);
		redSlider.setPaintLabels(true);
		
		greenSlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
		greenSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
		greenSlider.setPaintTicks(true);
		greenSlider.setPaintLabels(true);
		
		blueSlider.setMajorTickSpacing(MAJOR_TICK_SPACING);
		blueSlider.setMinorTickSpacing(MINOR_TICK_SPACING);
		blueSlider.setPaintTicks(true);
		blueSlider.setPaintLabels(true);
		
		redSlider.addChangeListener(this);
		blueSlider.addChangeListener(this);
		greenSlider.addChangeListener(this);
		
		sliderPanel.add(redSlider);
		sliderPanel.add(greenSlider);
		sliderPanel.add(blueSlider);
		sliderPanel.setLayout(verticalLayout);
		
		infoPanel.add(rgb);
		infoPanel.add(Box.createHorizontalStrut(HORIZAONTAL_SPACING));
		infoPanel.add(hexadecimal);
		
		controlPanel.add(infoPanel);
		controlPanel.add(Box.createVerticalStrut(VERTICAL_SPACING));
		controlPanel.add(sliderPanel);

		mainPanel.add(controlPanel);
		mainPanel.add(colorPanel);
		mainPanel.setLayout(horizontalLayout);
		
		add(mainPanel);
		setJMenuBar(new ColorChooserMenu(this, false));
		setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ChangeListener#stateChanged(javax.swing.event.ChangeEvent)
	 */
	@Override
	public void stateChanged(ChangeEvent action)
	{
		redValue = (short) redSlider.getValue();
		blueValue = (short) blueSlider.getValue();
		greenValue = (short) greenSlider.getValue();
		rgb.setText("Red: " + redValue + " Green: " + greenValue + " Blue: " + blueValue);
		hexadecimal.setText("Hexadecimal: " + String.format("#%02X%02X%02X", redValue, greenValue, blueValue));
		colorPanel.setBackground(new Color(redValue, blueValue, greenValue));
	}
}

package applications;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

import utility.BinarySearch;
import utility.Quicksort;

/**
 * @author Jackson Murrell on Oct 16, 2015
 */
public class Sorter extends JFrame implements ActionListener
{
	//Declaring variables
	JFileChooser fileChooser;
	
	private JPanel mainPanel, buttonPanel, textPanel;
	private JLabel text;
	private JButton sort, next, chooseFile, exit, search;
	
	private final int WINDOW_WIDTH = 500;
	private final int WINDOW_HEIGHT = 400;
	
	ArrayList<String> arrayList = new ArrayList<String>();
	Quicksort sorter = new Quicksort();
	BinarySearch searcher = new BinarySearch();
	File file;
	PrintWriter outputFile;
	Scanner inputFile;
	
	String[] array, temp;
	
	public Sorter() throws FileNotFoundException
	{
		//Same as set title
		super("Sort and Search");
		
		//Set initial values for the frame.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//Initialize all the various components and panels.
		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		textPanel = new JPanel();
		
		fileChooser = new JFileChooser();
		
		text = new JLabel("<html>Click the button below to choose the file you wish to sort and then click \"Sort\".<br>If you already have a file that is sorted, " +
						   "choose the file and click \"Continue\"</html>");
		
		//Disable the two buttons, next and sort, so that the user HAS to chose a file before continuing.  Otherwise, NullPointerExceptions get thrown everywhere.
		sort = new JButton("Sort");
		sort.setEnabled(false);
		sort.addActionListener(this);
		
		next = new JButton("Continue");
		next.setEnabled(false);
		next.addActionListener(this);
		
		chooseFile = new JButton("Choose File...");
		chooseFile.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);
		
		search = new JButton("Search");
		search.addActionListener(this);
		
		//Add components to panels.
		buttonPanel.add(chooseFile);
		buttonPanel.add(sort);
		buttonPanel.add(next);
		buttonPanel.add(exit);
		
		textPanel.add(text);
		
		mainPanel.add(textPanel);
		mainPanel.add(buttonPanel);
		
		//Add the mainPanel to  the frame.
		add(mainPanel);
		
		//Make sure everything is visible.
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent action) 
	{
		//Get the file the user wants to use and store it.
		if(action.getSource() == chooseFile)
		{
			//*sigh* I spent like 10 minutes trying to figure out why my if statement was not working
			//and then I found a semicolon on the end...noob mistake...
			//I had written a paragraph about it to send you too.
			if(fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				try
				{
					System.out.println("File: " + fileChooser.getSelectedFile() + "\nInt: " + fileChooser.showOpenDialog(this));
					file = fileChooser.getSelectedFile();
					inputFile = new Scanner(file);
					if(JOptionPane.showConfirmDialog(this, "Overwrite orginal file?", "Overwrite Confimration", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					{
						outputFile = new PrintWriter(file);
					}
					else
					{
						fileChooser.showOpenDialog(this);
						outputFile = new PrintWriter(fileChooser.getSelectedFile());
					}
					//Enable the buttons now that a file has been chosen.
					sort.setEnabled(true);
					next.setEnabled(true);
				} 
				catch (FileNotFoundException exception) 
				{
					JOptionPane.showMessageDialog(this, "Error: Could not find or open file.");
					exception.printStackTrace();
				}
				//Just in case something weird happens and all those files don't get linked correctly,
				//this will get called and prevent the buttons from being enabled.  Essentially, the user won't see anything.
				catch (NullPointerException exception)
				{
					sort.setEnabled(false);
					next.setEnabled(false);
					exception.printStackTrace();
				}
			}
		}
		else if(action.getSource() == sort)
		{
			//Call the quicksort method to sort, and handle the file writing.
			while(inputFile.hasNextLine())
			{
				arrayList.add(inputFile.nextLine());
			}
			inputFile.close();
			temp = new String[arrayList.size()];
			array = arrayList.toArray(temp);
			sorter.quicksort(array, 0, array.length-1);

			for(int i = 0; i < array.length; i++)
			{
				outputFile.println(array[i]);
			}
			outputFile.close();
			JOptionPane.showMessageDialog(this, "List successfully sorted.");
		}
		else if(action.getSource() == next)
		{
			//Go to the search options.
			buttonPanel.remove(chooseFile);
			buttonPanel.remove(sort);
			buttonPanel.add(search);
			repaint();
			setVisible(true);
		}
		else if(action.getSource() == exit)
		{
			//Exit, obviously.
			dispose();
		}
		else if(action.getSource() == search)
		{
			//Call the binarySearch method and display the result.
			String searchValue = JOptionPane.showInputDialog("Enter the value to search for:");
			boolean ignoreCase;
			int result;
			if(JOptionPane.showConfirmDialog(this,"Case-sensitive search?", "Case-sensitive", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
			{
				ignoreCase = false;
			}
			else
			{
				ignoreCase = true;
			}
			result = searcher.binarySearch(array, searchValue, ignoreCase) + 1;
			if(result == 0)
			{
				text.setText("The value, " + searchValue + ", was not found.");
			}
			else
			{
				text.setText("The value, " + searchValue + ", was found on line: " + result + ".");
			}
		}
	}
}
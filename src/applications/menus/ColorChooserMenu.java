package applications.menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import applications.ColorChooser;

/**
 * @author Jackson Murrell on Jan 1, 2016
 */
public class ColorChooserMenu extends JMenuBar implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MOTIF_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	private static final String GTK_LOOK_AND_FEEL = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
	private static final String NIMBUS_LOOK_AND_FEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	
	private ColorChooser chooser;
	private ButtonGroup group;
	private JMenuItem exit, simplified, advanced;
	
	private JMenu file, settings, appearance;
	private JRadioButtonMenuItem javaDefault, systemDefault, motif, gtk, nimbus;
	
	public ColorChooserMenu(ColorChooser chooser, boolean advancedOn)
	{
		this.chooser = chooser;
		group = new ButtonGroup();
		
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		
		if(advancedOn)
		{
			advancedMode();
		}
		else
		{
			simplifiedMode();
		}
		appearance = new JMenu("Appearance");
		file = new JMenu("File");
		settings= new JMenu("Settings");
		advanced = new JMenuItem("Advanced Mode");
		simplified = new JMenuItem("Simplified Mode");
		
		javaDefault = new JRadioButtonMenuItem("Java Default (\"Metal\")");
		javaDefault.setSelected(true);
		systemDefault = new JRadioButtonMenuItem("System Default (\"" + System.getProperty("os.name") + "\")");
		motif = new JRadioButtonMenuItem("Motif");
		gtk = new JRadioButtonMenuItem("GTK+");
		nimbus = new JRadioButtonMenuItem("Nimbus");
		
		group.add(javaDefault);
		group.add(systemDefault);
		group.add(gtk);
		group.add(motif);
		group.add(nimbus);
		
		javaDefault.addActionListener(this);
		systemDefault.addActionListener(this);;
		motif.addActionListener(this);
		gtk.addActionListener(this);
		nimbus.addActionListener(this);
		advanced.addActionListener(this);
		simplified.addActionListener(this);
		
		appearance.add(javaDefault);
		appearance.add(systemDefault);
		appearance.addSeparator();
		appearance.add(gtk);
		appearance.add(motif);
		appearance.add(nimbus);
		
		file.add(exit);
		settings.add(simplified);
		settings.add(advanced);
		settings.add(appearance);
		
		add(file);
		add(settings);
	}

	/**
	 * 
	 * @return void
	 */
	private void simplifiedMode()
	{
		chooser.remove(chooser.advancedChooser);
		chooser.add(chooser.mainPanel);
		SwingUtilities.updateComponentTreeUI(chooser);
        chooser.repaint();
	}

	/**
	 * 
	 * @return void
	 */
	private void advancedMode()
	{
		chooser.remove(chooser.mainPanel);
		chooser.add(chooser.advancedChooser);
		SwingUtilities.updateComponentTreeUI(chooser);
        chooser.repaint();
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent action)
	{
		if(action.getSource() == javaDefault)
		{
			try 
			{
		        UIManager.setLookAndFeel(
		        		UIManager.getCrossPlatformLookAndFeelClassName());
		        SwingUtilities.updateComponentTreeUI(chooser);
		        chooser.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == systemDefault)
		{
			try 
			{
		        UIManager.setLookAndFeel(
		        		UIManager.getSystemLookAndFeelClassName());
		        SwingUtilities.updateComponentTreeUI(chooser);
		        chooser.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == motif)
		{
			try 
			{
		        UIManager.setLookAndFeel(MOTIF_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(chooser);
		        chooser.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == gtk)
		{
			try 
			{
		        UIManager.setLookAndFeel(GTK_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(chooser);
		        chooser.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == nimbus)
		{
			try 
			{
		        UIManager.setLookAndFeel(NIMBUS_LOOK_AND_FEEL);
		        SwingUtilities.updateComponentTreeUI(chooser);
		        chooser.repaint();
		    } 
		    catch (UnsupportedLookAndFeelException e) 
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" is not supported for your operating system.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
		    	e.printStackTrace();
		    } catch (ClassNotFoundException e)
			{
		    	JOptionPane.showMessageDialog(null, "Sorry, but that \"Look and Feel\" was not found in the Java Library.", "Exception Caught", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (InstantiationException e)
			{
				e.printStackTrace();
			} catch (IllegalAccessException e)
			{
				e.printStackTrace();
			}
		}
		else if(action.getSource() == exit)
		{
			byte option = (byte)JOptionPane.showConfirmDialog(this, "Exit all programs?", "Exit Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(option == JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
			else if(option == JOptionPane.NO_OPTION)
			{
				chooser.dispose();
			}
		}
		else if(action.getSource() == advanced)
		{
			advancedMode();
		}
		else if(action.getSource() == simplified)
		{
			simplifiedMode();
		}
	}
}
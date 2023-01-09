package com.raman.file_encryption.privacy_provider;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Label;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
/**
 * Hello world!
 *
 */
public class DirectoryBrowser extends JFrame 
{

	private static final long serialVersionUID = 1L;
	
	public DirectoryBrowser(Path directory)
	{
		//Create a list model to hold the directory contents
		DefaultListModel<File> listModel = new DefaultListModel<>();
		
		//Populate the list model with the contents of the directory
		File[] files = directory.toFile().listFiles();
		for (File file : files)
		{
			listModel.addElement(file);
		}
	
		//Create a list to display the directory contents in.
		JList<File> list = new JList<>(listModel);
		list.setBackground(Color.WHITE);
		list.setForeground(Color.BLACK);
		//Set a cell renderer to display the icon for each file or directory
		list.setCellRenderer(new ListCellRenderer<File>() 
		{
			private final JLabel label = new JLabel();
			

			@Override
			public Component getListCellRendererComponent(JList<? extends File> list, File file, int index,
					boolean isSelected, boolean cellHasFocus) 
			{
				//Set the text and icon for the cell
				label.setText(file.getName());
				label.setIcon(getIcon(file));
				//Make the label opaque to have the ability on setting its background colour.
				//If true the component paints every pixel within its bounds.Otherwise, the component
				//may not paint some or all of its pixels, allowing the underlying pixels to show through.
				label.setOpaque(true);
				
				//Set the background and foreground colours based on the selection state
				if(isSelected)
				{
					label.setBackground(Color.GREEN);
					label.setForeground(Color.RED);
				}
				else
				{
					label.setBackground(list.getBackground());
					label.setForeground(list.getForeground());
				}			
				return label;
			}		
		});
		
		//Add the list to a scroll pane and add the scroll pane to the frame.
		JScrollPane scrollPane = new JScrollPane(list);
		add(scrollPane);
		
		//Set the frame properties
		setTitle("Directory Browser");
		// set the JFrame size and location, and make it visible
	    setPreferredSize(new Dimension(400, 400));
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
	}
	

	private Icon getIcon(File file) 
	{
		//Return the appropriate icon for the file or directory 
		if(file.isDirectory())
		{
			return UIManager.getIcon("FileView.directoryIcon");
		}else
			return UIManager.getIcon("FileView.fileIcon");
	}	

	public static void main( String[] args )
    {
        //Run the GUI code on the event-dispatching thread
		SwingUtilities.invokeLater(()->{
			Path directory = Paths.get("C:\\Users\\raman\\OneDrive\\Pictures");
			new DirectoryBrowser(directory).setVisible(true);
		});
    }
}

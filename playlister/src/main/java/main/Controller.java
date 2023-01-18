package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

public class Controller implements EventHandler<ActionEvent> 
{
	private View view;
	private ArrayList<File> files;
	private File playList;
	private String[] validFormats = {"mp3", "wav"};
	
	public Controller()
	{
		view = new View();
		view.getLoadFileButton().setOnAction(this);
		view.getCloseButton().setOnAction(this);
		files = new ArrayList<File>();
		playList = new File("raman.m3u");
	}

	public Scene getScene()
	{
		return view.getScene();
	}
	
	public void handle(ActionEvent event) 
	{
		Button button = (Button) event.getSource();
		if(button == view.getLoadFileButton())
		{
			DirectoryChooser directoryChooser = new DirectoryChooser();
			//This line can be used to define the initial start up folder.
			//directoryChooser.setInitialDirectory(new File("path"));
			    File selectedDirectory = directoryChooser.showDialog(view.getScene().getWindow());
			    if(selectedDirectory != null)
			    {
				//Get the path of chosen directory
				String directory_path = selectedDirectory.getAbsolutePath();
				//Determine whether or not there are valid files in the given folder path.
				boolean isThereFiles = loadFilesIntoList(selectedDirectory.listFiles());
				if(isThereFiles)
					createPlayList(directory_path);
			    }
		}else if(button == view.getCloseButton())
			System.out.println("Close button");
	}
	
	private boolean loadFilesIntoList(File[] loadedFiles)
	{
		files.clear();
        for (File file : loadedFiles) 
        { 
        	if(file.isDirectory())
        		continue;
        	if(!veryfiyExtenion(file.getName()))
        		continue;
        	files.add(file);
        }
        if(files.isEmpty())
        	return false;
		return true;
	}
	
	private boolean createPlayList(String path)
	{
		try{
			//Adding the PlayList file into the directory path.
			String saveLocation = path + "\\" + playList; 
			BufferedWriter writer = new BufferedWriter(new FileWriter(saveLocation));
			writer.write("#EXTM3U"); // M3U file header
            writer.newLine();
            for(File file : files)
            {
            	String song = path + "\\" + file.getName();
            	System.out.println(song);
            	//Write file with full path into the playList.
            	writer.write(song);
            	writer.newLine();
            }
            
            writer.close();
		}catch (IOException e) {
            e.printStackTrace();
        }
		return false;
	}
	
	private void addPlayListInfo(BufferedWriter writer) throws IOException
	{
		writer.write("#PLAYLIST:My Beloved Songs");
		writer.write("#EXTGENRE:Ramanize");
		writer.write("#EXTGENRE:Ramanize");
	}
	
	
	private boolean veryfiyExtenion(String file)
	{
		int index = file.lastIndexOf('.');
		if (index > 0)
		{
			String extension = file.substring(index + 1);
			for(String format : validFormats)
			{
				if(extension.equalsIgnoreCase(format))
					return true;
			}
		}
		return false;
	}
	
}

package main;

import java.io.File;
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
			directoryChooser.setInitialDirectory(new File("C:\\Users\\raman\\OneDrive\\Desktop\\New_Music"));
            File selectedDirectory = directoryChooser.showDialog(view.getScene().getWindow());
            if(selectedDirectory == null){
                // No directory selected
            }else{
                String directory_path = selectedDirectory.getAbsolutePath();
                loadFilesIntoList(selectedDirectory.listFiles());

            }
		}
		else if(button == view.getCloseButton())
		{
			System.out.println("Close button");
		}
		else
		{
			//Throw an error.
		}
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
        	System.out.println(file.getName());
        }
        if(files.isEmpty())
        	return false;
		return true;
	}
	
	private boolean createPlayList()
	{
		
		return false;
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

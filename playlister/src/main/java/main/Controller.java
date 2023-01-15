package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class Controller implements EventHandler<ActionEvent> 
{
	private View view;
	
	public Controller()
	{
		view = new View();
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
			
		}
		else if(button == view.getCloseButton())
		{
			
		}
		else
		{
			//Throw an error.
		}
	}
	
	
}

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
		view.getLoadFileButton().setOnAction(this);
		view.getCloseButton().setOnAction(this);
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
			System.out.println("Load button");
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
	
	
}

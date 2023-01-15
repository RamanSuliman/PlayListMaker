package main;

import com.raman.fxfunctions.RenderingServices;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Application_Entry extends Application
{

	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Controller controller = new Controller();
		
		primaryStage.setScene(controller.getScene());
		primaryStage.setResizable(false);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		primaryStage.show();
		
		/******  To centre screen must be called after .show() ******/
        RenderingServices.centreWindow(primaryStage);
	}

}

package com.raman.main;

import com.raman.fxfunctions.RenderingServices;
import com.raman.gui.toast.Toast;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Application_Entry extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Toast toast = new Toast();
			toast.loadToast("Information Tech", "This is a test custom message!");
			
			//Set up Stage
			primaryStage.setScene(toast.getScene());
			primaryStage.setResizable(false);
			primaryStage.getIcons().add(new Image("com.raman.gui/icons/logo.png"));
			primaryStage.initStyle(StageStyle.TRANSPARENT);
	        
	        primaryStage.show();
	               
	        /******  To centre screen must be called after .show() ******/
	        RenderingServices.centreWindow(primaryStage);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}

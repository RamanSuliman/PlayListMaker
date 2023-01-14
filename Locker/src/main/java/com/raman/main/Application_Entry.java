package com.raman.main;

import com.raman.FileProtector.FileProtectorController;
import com.raman.fxfunctions.RenderingServices;
import com.raman.gui.toast.Toast;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Application_Entry extends Application 
{
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			/*
			Toast toast = Toast.getInstance(primaryStage);
			toast.loadToast("Information Tech", "This is a test custom message!");
			
			Button showToast = new Button("Show Toast");
			showToast.setOnAction(new EventHandler<ActionEvent>() {				
				@Override
				public void handle(ActionEvent arg0) {
					toast.show();
				}
			});
			StackPane root = new StackPane();
			root.getChildren().add(showToast);
			Scene scene = new Scene(root, 500, 500);
			*/
			
			
			FileProtectorController root = new FileProtectorController();
			
			//Set up Stage
			primaryStage.setScene(root.getScene());
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

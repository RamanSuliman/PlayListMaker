package com.raman.fxfunctions;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RenderingServices 
{
	/***
	 * Centre the program in the middle of the screen (MUST BE CALLED AFTER) .show() method.
	 */
	public static void centreWindow(Stage primaryStage)
	{
		// Get the screen size
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        System.out.println(screenBounds.toString());
        // Center the stage horizontally
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);

        // Center the stage vertically
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
	}

}

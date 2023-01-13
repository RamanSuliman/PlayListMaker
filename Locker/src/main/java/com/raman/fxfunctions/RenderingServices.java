package com.raman.fxfunctions;

import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class RenderingServices 
{
	private static double xOffset = 0;
	private static double yOffset = 0;

	/***
	 * Centre the program in the middle of the screen (MUST BE CALLED AFTER) .show() method.
	 */
	public static void centreWindow(Stage primaryStage)
	{
		// Get the screen size
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        // Center the stage horizontally
        primaryStage.setX((screenBounds.getWidth() - primaryStage.getWidth()) / 2);

        // Center the stage vertically
        primaryStage.setY((screenBounds.getHeight() - primaryStage.getHeight()) / 2);
	}

	/**
     * The stage is set to undecorated style, therefore this method
     * allow user to drag the window if wanted using mouse click-drag.
     */
	public static void dragableWindow(Stage stage, Node node)
	{
		node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
		node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	stage.setX(event.getScreenX() - xOffset);
            	stage.setY(event.getScreenY() - yOffset);
            }
        });
	}
	
}

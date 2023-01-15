package main;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class View 
{
	private Button btn_open, btn_close;
	private TextField input_saveLocation;
	private Scene scene;
	
	public View()
	{
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setSpacing(3);
		root.setPadding(new Insets(4));

		btn_open = new Button("Load Files");
		btn_close = new Button("X");
		
		HBox buttons = new HBox();
		buttons.setFillHeight(true);
		buttons.setSpacing(3);
		
		//Filling width
		HBox.setHgrow(btn_open, Priority.ALWAYS);
		HBox.setHgrow(btn_close, Priority.ALWAYS);
		btn_open.prefWidthProperty().bind(buttons.widthProperty().divide(2));
		btn_close.prefWidthProperty().bind(buttons.widthProperty().divide(2));
		
		buttons.getChildren().addAll(btn_open, btn_close);
		
		
		input_saveLocation = new TextField();
		
		root.getChildren().addAll(input_saveLocation, buttons);
		
		scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
	}
	
	protected Button getLoadFileButton()
	{
		return btn_open;
	}
	
	protected Button getCloseButton()
	{
		return btn_close;
	}
	
	protected Scene getScene()
	{
		return scene;
	}
}

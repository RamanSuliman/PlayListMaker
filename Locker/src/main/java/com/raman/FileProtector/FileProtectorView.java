package com.raman.FileProtector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FileProtectorView
{
	private Scene scene;
	private BorderPane root;
	private Label txt_title;
	private ImageView icon;
	private ImageView btn_minimise, btn_close, btn_encrypt, btn_save_dec, btn_save_enc;
	private ImageView btn_removeAll, btn_removeSelected, btn_loadFiles, btn_undo, btn_attach;
	private EventHandler<MouseEvent> eventHandler;
	
	public FileProtectorView()
	{
		//Create the root pane
		root = new BorderPane();
		root.setTop(panel_header());
		root.setCenter(panel_body());
		root.setBottom(panel_footer());
		root.getStyleClass().add("rootPane");
		//Setting minimum and maximum height for the root, works with the Region... define in the scene.
		root.setMinHeight(170);
		root.setMaxHeight(280);	
		
		scene = new Scene(root, 400, 300);
		scene.getStylesheets().add("com.raman.gui/main.css");
		scene.setFill(Color.TRANSPARENT);
	}
	
	private Node panel_header() 
	{
		BorderPane panel_header = new BorderPane();
		panel_header.getStyleClass().add("panel_header");
		
		/*############### Application Controllers Container ###############*/
		HBox container = new HBox();
		container.setSpacing(5);
		panel_header.setRight(container);
		
		/*############### Application Close Button ###############*/
		btn_close = getButton(25, 25, "btn_close");
		
		/*############### Application Minimise Button ###############*/
		btn_minimise = getButton(25, 25, "btn_minimise");
		
		container.getChildren().addAll(btn_minimise, btn_close);
		
		/*############### Application Title ###############*/
		txt_title = new Label("Privacy Locker");
		//Set text color.
		//txt_title.setTextFill(Color.web("#eae0de"));
		//Set font name, format and size.
		txt_title.setFont(Font.font("Amble CN", FontWeight.BOLD, 18));
		//Set CSS class name.
		txt_title.getStyleClass().add("txt_title");
		//Make the text to be wrapped meaning extra text is pushed into new line.
		txt_title.setWrapText(true);
		//Set max width for the text.
		txt_title.setMaxWidth(180);
		//Position the text in the middle.
		txt_title.setAlignment(Pos.CENTER);
		panel_header.setCenter(txt_title);
	
		/*############### Default Message Type Icon ###############*/
		icon = new ImageView();
		icon.getStyleClass().add("icon_application");
		//Set width and height, if not define using setPreserveRatio() display image in original size.
		icon.setFitHeight(35);
		icon.setFitWidth(35);
		icon.setPreserveRatio(true);
		//Centre the icon vertically.
		BorderPane.setAlignment(icon, Pos.CENTER);
		panel_header.setLeft(icon);
		
		return panel_header;
	}

	private Node panel_body() 
	{
		HBox panel_body= new HBox();
		panel_body.getStyleClass().add("panel_body");
		
		/*############### Left Content Editing Tools ###############*/
		VBox left_container = new VBox();
		left_container.getStyleClass().add("left_container");
		
		// Remove All Button
		btn_removeAll = getButton(25, 25, "btn_removeAll");

		// Remove Selected File Button
		btn_removeSelected = getButton(25, 25, "btn_removeSelected");
		
		/*############### File Container ###############*/
		TextArea textArea = new TextArea();
		textArea.setPrefRowCount(20);
		textArea.setPrefColumnCount(50);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(textArea);
		scrollPane.setFitToWidth(true);
		//Make the bar invisible
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		
		
		
		return panel_body;
	}

	private Node panel_footer() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private ImageView getButton(int width, int height, String css)
	{
		ImageView  button = new ImageView();
		//Define button size.
		button.setFitHeight(width);
		button.setFitWidth(height);
		//Define CSS class for this button.
		button.getStyleClass().add(css);
		//Add event handler
		button.setOnMouseClicked(eventHandler);
		
		return button;
	}
	
	protected Scene getScene()
	{
		return scene;
	}
}

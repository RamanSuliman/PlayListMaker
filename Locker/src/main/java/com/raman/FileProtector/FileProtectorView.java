package com.raman.FileProtector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FileProtectorView
{
	private Scene scene;
	private BorderPane root;
	private Label txt_title;
	private Image ic_application;
	private ImageView icon;
	private Button btn_minimise, btn_close, btn_encrypt, btn_save_dec, btn_save_enc;
	private Button btn_removeAll, btn_removeSelected, btn_loadFiles, btn_undo, btn_attach;
	private EventHandler<ActionEvent> eventHandler;
	
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
		btn_close = new Button("X");
		//Define button size.
		btn_close.setPrefSize(30, 8);
		//Define CSS class for this button.
		btn_close.getStyleClass().add("btn_close");
		//Position the button text on the centre
		btn_close.setAlignment(Pos.CENTER);
		//Add event handler
		btn_close.setOnAction(eventHandler);
		
		/*############### Application Minimise Button ###############*/
		btn_minimise = new Button("-");
		//Define button size.
		btn_minimise.setPrefSize(30, 8);
		//Define CSS class for this button.
		btn_minimise.getStyleClass().add("btn_minimise");
		//Position the button text on the centre
		btn_minimise.setAlignment(Pos.CENTER);
		//Add event handler
		btn_minimise.setOnAction(eventHandler);
		
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
		ic_application = new Image("com.raman.gui/icons/info.png");
		icon = new ImageView(ic_application);
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
		// TODO Auto-generated method stub
		return null;
	}

	private Node panel_footer() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void setButtonProperties(Button button)
	{
		
	}
	
	protected Scene getScene()
	{
		return scene;
	}
}

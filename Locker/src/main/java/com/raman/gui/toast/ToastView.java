package com.raman.gui.toast;

import com.raman.fxfunctions.RenderingServices;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ToastView extends Stage
{
	//Panels
	private BorderPane root;
	//Labels
	private Label txt_title, txt_message;
	private Image ic_info;
	private ImageView icon;
	private Button btn_close, btn_yes, btn_no;
	private EventHandler<ActionEvent> eventHandler;

	public ToastView(Stage ownerWidnow, EventHandler<ActionEvent> eventHandler) 
	{
		this.eventHandler = eventHandler;
		
		//Create the root pane
		root = new BorderPane();
		root.setTop(panel_header());
		root.setCenter(panel_body());
		root.setBottom(panel_footer());
		root.getStyleClass().add("rootPane");
		//Setting minimum and maximum height for the root, works with the Region... define in the scene.
		root.setMinHeight(170);
		root.setMaxHeight(280);	
		
		//Create the Scene
		//Set maximum width of the scene and empty height with expandable size.
		Scene scene = new Scene(root, 300, Region.USE_COMPUTED_SIZE);
		scene.getStylesheets().add("com.raman.gui/toast.css");			
		scene.setFill(Color.TRANSPARENT);
	
		initModality(Modality.APPLICATION_MODAL);
		initOwner(ownerWidnow);
		initStyle(StageStyle.TRANSPARENT);
		
		setScene(scene);
	}	

	private BorderPane panel_header() 
	{

		BorderPane pane = new BorderPane();
		pane.getStyleClass().add("panel_header");
		
		//Make the window draggable from the header.
		RenderingServices.dragableWindow(this, pane);
		
		/*############### Default Message Type Icon ###############*/
		ic_info = new Image("com.raman.gui/icons/info.png");
		icon = new ImageView(ic_info);
		//Set width and height, if not define using setPreserveRatio() display image in original size.
		icon.setFitHeight(35);
		icon.setFitWidth(35);
		icon.setPreserveRatio(true);
		//Centre the button vertically.
		BorderPane.setAlignment(icon, Pos.CENTER);
		pane.setLeft(icon);
		
		/*############### Default Message Title ###############*/
		txt_title = new Label("Error");
		//Set text color.
		txt_title.setTextFill(Color.web("#eae0de"));
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
		pane.setCenter(txt_title);
		
		/*############### Close button ###############*/
		btn_close = new Button("X");
		//Define button size.
		btn_close.setPrefSize(30, 8);
		//Define CSS class for this button.
		btn_close.getStyleClass().add("btn_close");
		//Position the button text on the centre
		btn_close.setAlignment(Pos.CENTER);
		//Position the button on the top right corner
		pane.setRight(btn_close);
		//Centre the button vertically.
		BorderPane.setAlignment(btn_close, Pos.CENTER);
		//Add event handler
		btn_close.setOnAction(eventHandler);
		
		//Set margin between nodes
		BorderPane.setMargin(icon, new Insets(2, 0, 2, 3));
		BorderPane.setMargin(txt_title, new Insets(0, 0, 0, 0));
		BorderPane.setMargin(btn_close, new Insets(0, 4, 0, 0));
		
		return pane;
	}

	private HBox panel_body() 
	{
		HBox hbx_body = new HBox();
		hbx_body.getStyleClass().add("panel_body");
		
		/*############### Default Message Title ###############*/
		txt_message = new Label("In this area the message body is written with maximum number of charachters"
				+ "up to 500 and minmium of 1.");
		//Set text color.
		txt_message.setTextFill(Color.web("#0076a3"));
		//Set font name, format and size.
		txt_message.setFont(Font.font("Amble CN", FontWeight.BOLD, 12));
		//Set CSS class name.
		txt_message.getStyleClass().add("txt_message");
		//Make the text to be wrapped meaning extra text is pushed into new line.
		txt_message.setWrapText(true);
		//Set txt_message width for the text.
		txt_title.setMaxWidth(180);
		//Position the text in the middle.
		txt_message.setAlignment(Pos.CENTER);
		txt_message.setCursor(Cursor.TEXT);
		//Centre the button vertically.
		hbx_body.setAlignment(Pos.CENTER);
		HBox.setMargin(txt_message, new Insets(0, 10, 0, 10));
		
		hbx_body.getChildren().add(txt_message);
		
		return hbx_body;
	}
	
	private HBox panel_footer() 
	{     
        // Create the HBox for the buttons
        HBox footer_panel = new HBox();
        footer_panel.setSpacing(10);
        footer_panel.getStyleClass().add("footer_panel");
        footer_panel.setAlignment(Pos.CENTER);
		footer_panel.setPadding(new Insets(10, 0 , 10, 0));
        
        // Create some buttons to assist in selection
        btn_yes = new Button("Yes");
        btn_yes.setPrefSize(82, 25);
        btn_yes.getStyleClass().add("btn_yes");
        //Add event handler
        btn_yes.setOnAction(eventHandler);
      		
        btn_no = new Button("No");
        btn_no.setPrefSize(82, 25);
        btn_no.getStyleClass().add("btn_no");
        //Add event handler
        btn_no.setOnAction(eventHandler);
      		
        Button btn_retry = new Button("Retry");
        btn_retry.setPrefSize(82, 25);
        btn_retry.getStyleClass().add("btn_retry");
        //Add event handler
        btn_retry.setOnAction(eventHandler);
      		
        // Group up Buttons
        footer_panel.getChildren().addAll(btn_no, btn_yes, btn_retry);
        
        return footer_panel;
	}
	
	protected void loadToast(String title, String message)
	{
		setToastMessage(message);
		setToastTitle(title);
	}
	
	private void setToastMessage(String message)
	{
		txt_message.setText(message);
	}
	
	private void setToastTitle(String title)
	{
		txt_title.setText(title);
	}	
	
	protected void showToast()
	{
        //This shows the current window, show() could'nt be overridden
        show();
		/******  To centre screen must be called after .show() ******/
        RenderingServices.centreWindow(this);
	}
}

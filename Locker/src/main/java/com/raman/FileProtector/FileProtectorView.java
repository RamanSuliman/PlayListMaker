package com.raman.FileProtector;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FileProtectorView
{
	private Scene scene;
	private BorderPane root;
	private Label txt_title;
	private ListView<Label> fileContainer;
	private ImageView icon;
	private Button btn_minimise, btn_close, btn_encrypt, btn_decrypt, btn_save_dec, btn_save_enc;
	private Button btn_removeAll, btn_removeSelected, btn_loadFiles, btn_undo, btn_attach;
	private EventHandler<MouseEvent> eventHandler;
	private VBox box_encrypt, box_decypt;
	private HBox box_decrypt_panel;
	private ProgressBar progressBar;
	
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
		btn_close = getButton(25, 25, "X", "btn_close");
		
		/*############### Application Minimise Button ###############*/
		btn_minimise = getButton(25, 25, "-", "btn_minimise");
		
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
		left_container.setPadding(new Insets(0,0,0,10));
		left_container.getStyleClass().add("left_container");
		
		// Remove All Button
		btn_removeAll = getButton(25, 25, "RM All", "btn_removeAll");
		// Remove Selected File Button
		btn_removeSelected = getButton(25, 25, "RM S", "btn_removeSelected");
		left_container.getChildren().addAll(btn_removeAll, btn_removeSelected);
		
				/*############### File Container ###############*/
		fileContainer= new ListView<Label>();		
		fileContainer.setPrefSize(300, 100);
		fileContainer.getStyleClass().add("fileContainer");
		fileContainer.setOnMouseClicked(new EventHandler<MouseEvent>() {

	        @Override
	        public void handle(MouseEvent event) 
	        {
	            System.out.println("clicked on " + fileContainer.getSelectionModel().getSelectedItem());
	        }
	    });
		
		panel_body.getStyleClass().add("fileContainer");
		
		ScrollPane scrollPane = new ScrollPane();
		panel_body.getStyleClass().add("scrollPane");
		scrollPane.setContent(fileContainer);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(true);
		//Make the bar invisible
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		HBox.setMargin(scrollPane, new Insets(0,10,0,10));
			
				/*############### Left Content Editing Tools ###############*/
		VBox right_container = new VBox();
		right_container.setPadding(new Insets(0,10,0,0));
		right_container.getStyleClass().add("right_container");
		
		// Remove All Button
		btn_loadFiles = getButton(25, 25, "Load Files", "btn_loadFiles");
		// Remove Selected File Button
		btn_undo = getButton(25, 25, "Undo", "btn_undo");
		right_container.getChildren().addAll(btn_loadFiles, btn_undo);
				
		panel_body.getChildren().addAll(left_container, scrollPane, right_container);
		
		return panel_body;
	}
	
	/***
	 * This method sets the footer section of the main window GUI.
	 * @return Node Repressing layout of type HBox.
	 */
	private Node panel_footer() 
	{
		VBox panel_footer = new VBox();
		panel_footer.getStyleClass().add("panel_footer");
		panel_footer.setStyle("-fx-background-color: red;");
		panel_footer.setAlignment(Pos.CENTER);
		
		//Prepare the progress bar
		progressBar = new ProgressBar();
		progressBar.getStyleClass().add("progressBar");
		//Filling width
		progressBar.prefWidthProperty().bind(panel_footer.widthProperty());
		//VBox.setMargin(progressBar, new Insets(0, 2, 0, 2));
		
		panel_footer.getChildren().addAll(progressBar, setDecryptBox());
		//panel_footer.getChildren().add(panel_footer);

		return panel_footer;
	}

	
	private VBox setEncryptBox()
	{
		box_encrypt = new VBox();
		box_encrypt.setAlignment(Pos.CENTER);
		box_encrypt.getStyleClass().add("box_encrypt");

		btn_encrypt = getButton(80, 20, "Encrypt", "btn_encrypt");

		btn_save_enc = getButton(80, 20, "Save", "btn_save_enc");
		
		//btn_save_enc.setVisible(false);
		
		box_encrypt.getChildren().addAll(btn_encrypt, btn_save_enc);
		
		return box_encrypt;
	}
	
	private VBox setDecryptBox()
	{
		box_decypt = new VBox();
		box_decypt.getStyleClass().add("box_decypt");
		box_decypt.setAlignment(Pos.CENTER);
		
		//Prepare the panel container that will hold attach and decrypt buttons.
		box_decrypt_panel = new HBox();
		box_decrypt_panel.setSpacing(10);
		box_decrypt_panel.getStyleClass().add("box_decrypt_panel");
		box_decrypt_panel.setAlignment(Pos.CENTER);
		
		//Preparing buttons
		btn_attach = getButton(80, 20, "Attach", "btn_attach");
		btn_decrypt = getButton(80, 20, "Decrypt", "btn_decrypt");
		
		//Add buttons to the horizontal panel box
		box_decrypt_panel.getChildren().addAll(btn_attach, btn_decrypt);
		
		//Button for saving the decrypted files.
		btn_save_dec = getButton(60, 20, "Save", "btn_save_dec");
		
		box_decypt.getChildren().addAll(box_decrypt_panel, btn_save_dec);
		
		return box_decypt;
	}
	
	/***
	 * This method is used to create and prepare an instance of an image button.
	 * 
	 * @param width Takes an integer value to define the width property.
	 * @param height Takes an integer value to define the height property.
	 * @return ImageView Repressing image view to be used as a button.
	 */
	private Button getButton(int width, int height, String text, String css)
	{
		Button  button = new Button(text);
		//Define button size.
		button.setPrefSize(width, height);
		//Define CSS class for this button.
		button.getStyleClass().add(css);
		//Add event handler
		button.setOnMouseClicked(eventHandler);
		
		return button;
	}
	
	
	private StackPane addLabelToImage(ImageView button, String text, String css)
	{
		// Create the StackPane
		StackPane stackPane = new StackPane();
		
		// Create the label
		Label label = new Label(text);
		label.getStyleClass().add(css);
		
		// Add the ImageView and Label to the StackPane
		stackPane.getChildren().addAll(button, label);
		
		return stackPane;
	}
	
	protected Scene getScene()
	{
		return scene;
	}
}

/*
			### assign Files icons to each label
		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		
		if (selectedFile != null) {
		    FileSystemView view = FileSystemView.getFileSystemView();
		    javax.swing.Icon icon = view.getSystemIcon(selectedFile);
		    Image image = SwingFXUtils.toFXImage((BufferedImage) icon.getImage(), null);
		    ImageView imageView = new ImageView(image);
		    Label label = new Label();
		    label.setGraphic(imageView);
		}
		
		
				### Restrict what files can be chosen
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
		    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
		    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
		    new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac")
		);

*/


/*
	public class FileExplorer extends Application {
	    private ListView<String> listView;
	
	    public static void main(String[] args) {
	        launch(args);
	    }
	
	    @Override
	    public void start(final Stage primaryStage) {
	        primaryStage.setTitle("File Explorer");
	        listView = new ListView<>();
	
	        Button openDirButton = new Button("Open Directory");
	        openDirButton.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                DirectoryChooser directoryChooser = new DirectoryChooser();
	                File selectedDirectory = directoryChooser.showDialog(primaryStage);
	
	                if(selectedDirectory == null){
	                    // No directory selected
	                }else{
	                    listView.getItems().clear();
	                    File[] files = selectedDirectory.listFiles();
	                    for (File file : files) {
	                        listView.getItems().add(file.getName());
	                    }
	                }
	            }
	        });
	
	        VBox vbox = new VBox();
	        vbox.getChildren().addAll(openDirButton, listView);
	        Scene scene = new Scene(vbox, 300, 250);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }
	}
*/

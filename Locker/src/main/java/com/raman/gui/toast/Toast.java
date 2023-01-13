package com.raman.gui.toast;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Toast implements EventHandler<ActionEvent> 
{
	private ToastView view;
	private static Toast instance = null;
	
	private Toast(Stage ownerWindow)
	{
		view = new ToastView(ownerWindow, this);
	}
	
	public static Toast getInstance(Stage ownerWindow)
	{
		if(instance == null)
			instance = new Toast(ownerWindow);
		return instance;
	}
	
	public void loadToast(String title, String message)
	{
		if(title.length() > 18 || message.length() > 500)
			throw new IllegalArgumentException("Outbound: The title max is 50 charachters"
					+ " with message max 500 and min 5.");
		if(title.length() < 4 || message.length() < 5)
			throw new IllegalArgumentException("Less: The title min is 4 charachters"
					+ " with message max and min 5.");
		view.loadToast(title, message);
	}
	
	public void show()
	{
		view.showToast();
	}

	@Override
	public void handle(ActionEvent event) 
	{
		Object source = event.getSource();
		if(source instanceof Button)
			buttonEvent((Button) source);
		else
			System.out.println("Not button event been triggered");
		
	}
	
	private void buttonEvent(Button button)
	{
		String name = button.getText();
		if(name == "Retry")
			System.out.println("Retry clicked!");
		else if(name == "Yes")
			System.out.println("Yes clicked!");
		else if(name == "No")
			System.out.println("No clicked!");
		else if(name == "X")
		{
			System.out.println("Close clicked!");
			view.close();
		}
		else
			System.out.println("Unknown button named: " + name);
	}		
}

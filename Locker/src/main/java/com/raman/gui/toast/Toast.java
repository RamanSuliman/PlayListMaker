package com.raman.gui.toast;

import javafx.scene.Scene;

public class Toast 
{
	private ToastView view;
	
	public Toast()
	{
		view = new ToastView();
	}

	public Scene getScene()
	{
		return view.scene;
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
}

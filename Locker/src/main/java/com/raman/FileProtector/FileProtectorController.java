package com.raman.FileProtector;

import javafx.scene.Scene;

public class FileProtectorController 
{
	private FileProtectorView view;
	
	public FileProtectorController()
	{
		view = new FileProtectorView();
	}
	
	public Scene getScene()
	{
		return view.getScene();
	}
}

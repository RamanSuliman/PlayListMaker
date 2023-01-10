package com.raman.file_encryption.gui;

import java.awt.Color;

public class Color_Converter 
{
	public static Color hex_to_rgb(String hex)
	{
		if(!hex.startsWith("#"))
			hex += "#";
		if(hex.length() < 6 || (hex.length() > 6 && !hex.startsWith("#")))
			throw new IllegalArgumentException("Color_Converter.hex_to_rgb is given invalid hex value!");
		return new Color(
				Integer.valueOf(hex.substring(1 ,3), 16),
				Integer.valueOf(hex.substring(3 ,5), 16),
				Integer.valueOf(hex.substring(5 ,7), 16)
		);
	}
}

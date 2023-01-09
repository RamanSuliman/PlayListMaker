package com.raman.file_encryption.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;


public class Toast extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JLabel bodyMessage;
	
	public Toast()
	{
		setUp_Frame();
		set_ui_components();
	}
	
	private void setUp_Frame()
	{
		setPreferredSize(new Dimension(400, 400));
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		//setOpacity(0);
		//setLayout(new GridBagLayout());
		//setBackground(Color_Converter.hex_to_rgb("#e8f9cf"));

		/*
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) 
			{
				setShape(new  RoundRectangle2D.Double(0,0,getWidth(),
			    getHeight(), 20, 20));  
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
	}
	
	private void set_ui_components()
	{
		bodyMessage = new JLabel();
		add(bodyMessage);
	}
	
	public void setBodyText(String message)
	{
		bodyMessage.setText(message);
	}
	
	public void show()
	{
		setVisible(true);
		/*
		try {
	         
		     //hide the toast message in slow motion
	         for (double d = 0.2; d < 1.0; d += 0.1) {
	            Thread.sleep(100);
	            setOpacity((float)d);
	         }
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	      
	     */ 
	}
	
	public void close()
	{
		try {
		     //hide the toast message in slow motion
	         for (double d = 1.0; d > 0.2; d -= 0.1) {
	            Thread.sleep(100);
	            setOpacity((float)d);
	         }
	         // set the visibility to false
	         setVisible(false);
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	
	
	public static void main(String[] args) 
	{
		//Run the GUI code on the event-dispatching thread
		SwingUtilities.invokeLater(()->{
			Toast toast = new Toast();
			toast.setBodyText("Hi...");
			toast.setVisible(true);
		});
	}
}

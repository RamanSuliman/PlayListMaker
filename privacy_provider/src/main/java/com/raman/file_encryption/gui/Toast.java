package com.raman.file_encryption.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

class Toast extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JLabel bodyMessage;
	private final int frameWidth = 300;
	private final int frameHeight = 280;
	public Toast()
	{
		setUIComponents();
		setup_frame();
	}
	
	private void setup_frame()
	{
		setPreferredSize(new Dimension(frameWidth, frameHeight));
		setTitle("Toast");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().setBackground(Color_Converter.hex_to_rgb("#e8f9cf"));
		add(new JLabel("Boo!"));
		setUndecorated(true);
		//Rounded shape
		//setShape(new Ellipse2D.Double(0, 0, 200, 200));
		setShape(only_two_rounded_corners());
		pack();
		setLocationRelativeTo(null);
		//The window must be undecorated first.
		//setOpacity(0);
	}
	
	private Area only_two_rounded_corners()
	{
		int width = getPreferredSize().width;
		int height = getPreferredSize().height;
		Area shape1 = new Area(new RoundRectangle2D.Double(0, 0, width, height, 50, 50));
        Area shape2 = new Area(new Rectangle(0, height - 50, width, height / 2));
        shape1.add(shape2);
        return shape1;
	}

	private void setUIComponents()
	{
		bodyMessage = new JLabel();
		add(bodyMessage);
	}
	
	
	public void setBodyMessage(String msg)
	{
		bodyMessage.setText(msg);
	}
	
	
	public static void main(String[] args) 
	{
		//Run the GUI code on the event-dispatching thread
		SwingUtilities.invokeLater(()->{
			Toast t = new Toast();
			//toast.setBodyText("Hi...");
			t.setBodyMessage("Raman");
			t.setVisible(true);
		});
	}

}


/**
	
	public void show()
	{
		setVisible(true);
		try {
			
		     //hide the toast message in slow motion
	         for (double d = 0.2; d < 1.0; d += 0.1) {
	            //Thread.sleep(100);
	            setOpacity((float)d);
	         }
	      }catch (Exception e) {
	         System.out.println(e.getMessage());
	      }
	}
	
 
 
 
 
 */

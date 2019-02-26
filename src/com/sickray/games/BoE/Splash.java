package com.sickray.games.BoE;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {
	Splash() throws MalformedURLException{
	JWindow window = new JWindow();
	window.getContentPane().add( new JLabel("", new ImageIcon(new URL("https://unicxa.github.io/BOE.gif")), SwingConstants.CENTER), 0);
	window.setBounds(500, 150, 300, 200);
	window.setVisible(true);
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
	GameEng g = new GameEng();
	g.start();
	
	}
}

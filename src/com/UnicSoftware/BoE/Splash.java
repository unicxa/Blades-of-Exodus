package com.UnicSoftware.BoE;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

@SuppressWarnings("unused")
public class Splash {

	@SuppressWarnings("deprecation")
	public void SplashScreen() {
		JWindow window = new JWindow();
		try {
			window.getContentPane().add(
					new JLabel("", new ImageIcon(new URL("https://unicxa.github.io/BOE.gif")), SwingConstants.CENTER),
					0);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean toggle = false;
		int yesOrNo = JOptionPane.showConfirmDialog(null, "Enable Developer Menu?");
		
		
		
		 if(yesOrNo == 0) {
			 toggle  = true;
			 JOptionPane.showMessageDialog(null, "Selected Yes: [Enabled]");
			 window.dispose();  window.removeAll();
			 start(toggle);
			 return;
		 }  
		 if(yesOrNo == 1) {
			 toggle  = false;
			 JOptionPane.showMessageDialog(null, "Selected No: [Disabled]");
			 window.dispose();  window.removeAll();
			 start(toggle);
			 return;
		} else {
			 toggle  = false;
			 JOptionPane.showMessageDialog(null, "No Input Found: [Disabled]");
			 window.dispose();  window.removeAll();
			 start(toggle);
			 return;
		}
		 
	}
	public void start(boolean toggle) {
		GameEng eg = new GameEng(toggle);
		 eg.start();
	}
}

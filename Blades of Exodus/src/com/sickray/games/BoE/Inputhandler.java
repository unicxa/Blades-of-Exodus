package com.sickray.games.BoE;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JOptionPane;

import com.sickray.games.BoE.Blocks.ObjectBase;
import com.sickray34s.Enum.ObjectID;

public class Inputhandler extends KeyAdapter {
	boolean toggle = false;
	Handler handler;
	GameEng engen;
	Inputhandler(Handler handler, GameEng engen){
	this.handler = handler;
	this.engen = engen;
		
	
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
    	 ObjectBase base = handler.object.get(i); 
    	 
    	 
    	 if(base.getID() == ObjectID.EntityPlayer){
    		 
    		 if(key == KeyEvent.VK_D) base.setVelX(2);
    		 if(key == KeyEvent.VK_A) base.setVelX(-2);
    		 if(key == KeyEvent.VK_SPACE && !base.isJumping()){ 
    			 base.setJumping(true);
    			 base.setVelY(-10);
    			 }
    	 }
		
		
		
		
		
	
    if(e.getKeyCode() == KeyEvent.VK_F1 && toggle == false){
    	JOptionPane.showMessageDialog(null, "By Clicking F1 You Open The DEVELOPMENT MENU Interface On the Graphics");
    	toggle = true;
    	GameEng.ToggleDevMenu = toggle;
     }
    if(e.getKeyCode() == KeyEvent.VK_F1 && toggle == true){
    	toggle = false;
    	GameEng.ToggleDevMenu = toggle;
     }
    
	
     }
	}
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
    	 ObjectBase base = handler.object.get(i); 
    	 
    	 
    	 if(base.getID() == ObjectID.EntityPlayer){
    		
    		 if(key == KeyEvent.VK_D) base.setVelX(0);
    		 if(key == KeyEvent.VK_A) base.setVelX(0);
    		 if(key == KeyEvent.VK_SPACE) base.setVelY(0);
    		 }
    		 
    	 }
		
	}
}




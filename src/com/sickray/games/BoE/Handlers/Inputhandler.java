package com.sickray.games.BoE.Handlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import com.sickray.games.BoE.GameEng;
import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Objects.ObjectBase;
import com.sickray.games.BoE.Projectiles.Projectile;

public class Inputhandler extends KeyAdapter {
	boolean toggle = false;
	Handler handler;
	GameEng engine;
	int playerx;
	int playery;
	public Inputhandler(Handler handler, GameEng engen){
	this.handler = handler;
	this.engine = engen;
	
	
	}
	long m = 0;
	
	long GetKeyTime(){
		return System.currentTimeMillis();
		
	}
	boolean Wait(long millis,long wait){
		if(System.currentTimeMillis() > millis + wait) {
			return true;
		}
		return false;
		
	}
	//KeyEvents
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		for(int i = 0; i < handler.object.size(); i++){
    	 ObjectBase base = handler.object.get(i); 
    	 
    	 //Base Movement
    	 if(base.getID() == ObjectID.EntityPlayer){
    		 
    		 if(key == KeyEvent.VK_D) base.setVelX(2);
    		 if(key == KeyEvent.VK_A) base.setVelX(-2);
    		 if(key == KeyEvent.VK_SPACE && !base.isJumping()){ 
    			 base.setJumping(true);
    			 base.setVelY(-10);
    			 
    	
    		 
    		 }
    		 //Adds A Simple Projectile
    	 if(key == KeyEvent.VK_OPEN_BRACKET){
    		 //*TODO* Change To AmmoHandler
    		 //implement 
    		 
    	if(this.Wait(m,100)) {
    		 
    		this.handler.addObject(new Projectile(handler, ObjectID.Fire, true));
    		m = this.GetKeyTime();
    	}
    	}
    	 if(key == KeyEvent.VK_CLOSE_BRACKET){
    		 if(this.Wait(m,100)) {
     		this.handler.addObject(new Projectile(handler, ObjectID.Fire, false));
     		
     		m = this.GetKeyTime();
    	    	}
     	}
    
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




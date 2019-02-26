package com.sickray.games.BoE.Projectiles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Entity.EntityPlayer;
import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Handlers.Handler;
import com.sickray.games.BoE.Objects.ObjectBase;
import com.sickray.games.BoE.Utils.MapArray;

public class Projectile extends ObjectBase{

	//Our Projectile Class
	 Handler handler;
	 EntityPlayer p;
	 boolean LeftRight;
	 MapArray MA;
	 long e;
	 
	public Projectile(Handler handler, ObjectID Id, boolean LeftRight) {
		super(Id);
		MA = new MapArray();
		this.Id = Id;
		this.handler = handler;
		this.LeftRight = LeftRight;
		
		
		for(int i = 0; i < handler.object.size(); i++){
	    	 ObjectBase base = handler.object.get(i); 
	    	 
	    	 
	    	 if(base.getID() == ObjectID.EntityPlayer){
	    		if(LeftRight == true){
	    		x = base.getX() + 30;
	    		
	    		
	    		}
	    		if(LeftRight == false ){
		    		x = base.getX() - 20;
		    
		    	}
	    		
	    		
	    		y = base.getY();
	    	 }
		}
		
	
	
	}
	
	@Override
	public float getX() {
		return x;
	
		
	}

	@Override
	public float getY() {
		return y;
	
		
	}

	@Override
	public void setX(float x) {
	this.x = x;
	}

	@Override
	public void setY(float y) {
	this.y = y;
	}
	
	@Override
	public ObjectID getID() {
	
		return Id;
	}

		
		
		
		
		

	
	@Override
	public void tick(LinkedList<ObjectBase> Object) {
		if(LeftRight == true){
		x+= 7;
		}
		if(LeftRight == false){
		x-= 7;
		}
	}

	@Override
	public void render(Graphics g) {
		g.fillRect( (int)x , (int)y, (int)MA.SetX16(1), (int)MA.SetY16(1));
		
	
	}
	public void setColor(Graphics g){
		g.setColor(Color.ORANGE);
	}
	
	 public void setXY(float x, float y){
	 this.x =x;
	 this.y =y;
	 }

	@Override
	public Rectangle getBoundsUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@SuppressWarnings("unused")
	private void is1000Mills() {
		
	}

}

	



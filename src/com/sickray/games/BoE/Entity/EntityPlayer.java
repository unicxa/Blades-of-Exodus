package com.sickray.games.BoE.Entity;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Handlers.Handler;
import com.sickray.games.BoE.Objects.ObjectBase;


public class EntityPlayer extends ObjectBase {


	 private float width = 32, height = 64;
	 private float gravity = 0.03f;
	 float MaxSpeed = 5;
	 private Handler handler;
	 
	 public EntityPlayer(float y, float x, Handler handler, ObjectID id){	 
		 super(x,y,id);
		
		 this.handler =	handler;
		 
	 }
	
	

	 //Tick + Player Gravity
	@Override
	public void tick(LinkedList<ObjectBase> object) {
		x += VelX;
		
		y += VelY;
		
		if(Falling || Jumping){
			VelY += gravity;
			if(VelY > MaxSpeed){
			VelY = MaxSpeed;
			}
		}
		this.Collision(object);
	}
    //get Collision
	public void Collision(LinkedList<ObjectBase> object){
		for(int i = 0; i < handler.object.size(); i++){
			ObjectBase Obj = handler.object.get(i);
			
			if(Obj.getID() == ObjectID.Grass){
				if(getBoundsDown().intersects(Obj.getBoundsDown())){
					y = (int) y;
					
					VelY = 0;
					Falling = false;
					Jumping = false;
				}else {
					Falling = true;
					
				}
			}
			
			
		}
	}

	
	

	
	
	@Override
	public void render(Graphics g) {

		
	 
	this.setBoundsCollision(g,  getBoundsUp(),  getBoundsDown(),  getBoundsLeft(),  getBoundsRight());
		
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
	public float getVelX() {
		return VelX;
		
		
	}

	@Override
	public float getVelY() {
		return VelY;
	
		
	}

	@Override
	public void setVelX(float VelX) {
		this.VelX = VelX;
		
	}

	@Override
	public void setVelY(float VelY) {
	this.VelY = VelY;
		
	}
	@Override
	public void setColor(Color C){
		if(C == null){
			C = Color.RED;
		} else {
		this.C = C;
		}
	}

	@Override	
	public Rectangle getBoundsDown() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x + (width /2)-((width /2)/2)),(int) ((int)y +(height /2)),(int)width /2,(int)height /2);
	}
	
	public Rectangle getBoundsUp() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int)x +((width /2)/2)),(int)y,(int)width /2,(int)height /2);
	}


	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,(int)width,(int)height);
	}
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x,(int)y,(int)width,(int)height);
	}
	@Override
	public ObjectID getID() {
		//GET ID
		return Id;
	}
	
	 
	
}
	


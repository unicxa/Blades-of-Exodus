package com.UnicSoftware.BoE.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.UnicSoftware.BoE.Enum.ObjectID;

public class Grass extends ObjectBase {

	public Grass(float x, float y, ObjectID Id) {
		super(x, y, Id);

	}

	@Override
	public void tick(LinkedList<ObjectBase> Object) {

		
	}

	@Override
	public void render(Graphics g) {
    g.setColor(Color.GREEN);
   // g.drawImage(img, 0, 0, null);
    g.fillRect((int)x, (int)y, 32, 32);
		
	}

	@Override
	public float getX() {
		return VelX;
	
		
	}

	@Override
	public float getY() {
		return VelX;
	
		
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
		return VelX;
	
		
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
	public ObjectID getID() {
	
		return Id;
	}
	public Rectangle getBounds(){
		return new Rectangle((int)x,(int)y, 32, 32);
	}

	@Override
	public Rectangle getBoundsUp() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 32, 32);
	}

	@Override
	public Rectangle getBoundsDown() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 32, 32);
	}

	@Override
	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 32, 32);
	}

	@Override
	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y, 32, 32);
	}


	

}
	
	


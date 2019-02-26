package com.sickray.games.BoE.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Objects.ObjectBase;
import com.sickray.games.BoE.Utils.MapArray;

public class Grass extends ObjectBase {
	int x;
	int y;
	MapArray ma;
	public Grass(float x, float y, ObjectID Id) {
		super(x, y, Id);
		this.x = (int) x;
		this.y = (int) y;
		
	}

	@Override
	public void tick(LinkedList<ObjectBase> Object) {

		
	}

	@Override
	public void render(Graphics g) {
		ma = new MapArray();
		
	
		g.setColor(Color.GREEN);
    g.fillRect(x, y, 1024, 16);
    
	
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
		
	    this.x = (int) x;
		
	}

	@Override
	public void setY(float y) {
		this.y = (int) y;
		
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
	public void setColor(Graphics g){
		g.setColor(Color.GREEN);
	}

	@Override
	public ObjectID getID() {
	
		return Id;
	}


	@Override
	public Rectangle getBoundsUp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getBoundsDown() {
		// TODO Auto-generated method stub
		return new Rectangle(x,y, 1024, 16);
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


	

}
	
	


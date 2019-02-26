package com.sickray.games.BoE.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;

public class BaseWeapon extends ObjectBase  {
	
	
	//BaseWeapon For GUI And Input (May Change)
	

	public BaseWeapon(float x, float y, ObjectID Id) {
		super(x, y, Id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick(LinkedList<ObjectBase> Object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
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

}

package com.sickray.games.BoE.Blocks;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray34s.Enum.ObjectID;

public class Fire extends ObjectBase {
	
	public Fire(float x, float y, ObjectID Id) {
		super(x, y, Id);
		// TODO Auto-generated constructor stub
	}

{


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

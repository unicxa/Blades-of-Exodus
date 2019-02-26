package com.sickray.games.BoE.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Objects.ObjectBase;
import com.sickray.games.BoE.Utils.MapArray;

public class Sky extends ObjectBase {
	float x;
	float y;
	MapArray ma;
	public Sky(float x, float y, ObjectID Id) {
	 super(x,y,Id);
	 this.x = x;
	 this.y = y;
	 this.Id = Id;
	  ma = new MapArray();
	 
	 
	}

	@Override
	public void tick(LinkedList<ObjectBase> Object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		for(int x = 0; x <= 64; x++){
			for(int y = 0; y <= 32; y++){
				g.setColor(Color.cyan);
			g.fillRect(ma.SetX16(x), ma.SetY16(y), 16, 16);
			}
			g.setColor(Color.white);
			g.fillOval(150, 80, 300, 100);
			g.fillOval(280, 120, 150, 100);
			g.fillOval(180, 140, 150, 100);
		}
		
		
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

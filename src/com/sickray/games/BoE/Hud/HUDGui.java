package com.sickray.games.BoE.Hud;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Objects.ObjectBase;

public class HUDGui extends ObjectBase {
	int Health,Energy,Sanity,Bullets;

	public HUDGui(ObjectID id, int Health,int Energy, int Sanity, int Bullets) {
		super(id);
		this.Health = Health;
		this.Energy = Energy;
		this.Sanity = Sanity;
		this.Bullets = Bullets;
		
		
		
		
		
	}

	@Override
	public void tick(LinkedList<ObjectBase> Object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
			g.drawString("Health: " + Health + " Energy: " + Health + " Sanity: " + Sanity + " Bullets: " + Bullets, 0, 522);
		
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

package com.UnicSoftware.BoE.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;

import com.UnicSoftware.BoE.Handler;
import com.UnicSoftware.BoE.Blocks.ObjectBase;
import com.UnicSoftware.BoE.Enum.ObjectID;

public class EntityPlayer extends ObjectBase {

	private float width = 32, height = 64;
	private float gravity = 0.03f;
	float MaxSpeed = 5;
	double healthpoints = 100;
	private Handler handler;

	public EntityPlayer(float y, float x, Handler handler, ObjectID id) {
		super(x, y, id);

		this.handler = handler;

	}

	@Override
	public void tick(LinkedList<ObjectBase> object) {
	
				x += VelX;

				y += VelY;

				if (Falling || Jumping) {
					VelY += gravity;
					if (VelY > MaxSpeed) {
						VelY = MaxSpeed;
					}
				}
				this.Collision(object);
			

	}

	public void Collision(LinkedList<ObjectBase> object) {
		for (int i = 0; i < handler.object.size(); i++) {
			ObjectBase Obj = handler.object.get(i);

			if (Obj.getID() == ObjectID.Grass) {
				if (getBoundsDown().intersects(Obj.getBoundsDown())) {
					y = (int) y;

					VelY = 0;
					Falling = false;
					Jumping = false;
				} else {
					Falling = true;
				}
			}
			if (Obj.getID() == ObjectID.Fire) {
				if (this.getBoundsDown().intersects(Obj.getBoundsDown())
						|| this.getBoundsLeft().intersects(Obj.getBoundsLeft())
						|| this.getBoundsRight().intersects(Obj.getBoundsRight())
						|| this.getBoundsUp().intersects(Obj.getBoundsUp())) {

					healthpoints--;

				}

			}

		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.drawRect((int) (512-64) , 64, 132, 18);
		g.setColor(Color.GREEN);
		g.fillRect((int) (512-64) +2  , 64 +2, 128, 16);
		this.setBoundsCollision(g, getBoundsUp(), getBoundsDown(), getBoundsLeft(), getBoundsRight());

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
	public void setColor(Color C) {
		if (C == null) {
			C = Color.RED;
		} else {
			this.C = C;
		}
	}

	@Override
	public Rectangle getBoundsDown() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int) x + (width / 2) - ((width / 2) / 2)), (int) ((int) y + (height / 2)),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsUp() {
		// TODO Auto-generated method stub
		return new Rectangle((int) ((int) x + ((width / 2) / 2)), (int) y, (int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsLeft() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	public Rectangle getBoundsRight() {
		// TODO Auto-generated method stub
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	@Override
	public ObjectID getID() {
		// TODO Auto-generated method stub
		return Id;
	}

}

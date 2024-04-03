  package com.UnicSoftware.BoE.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import com.UnicSoftware.BoE.Enum.ObjectID;

@SuppressWarnings("unused")
public abstract class ObjectBase {
	//BlockBase Method
	/* TODO ADD --Modifiers-- 
	 * TODO ADD BlockHealth
	 * TODO ADD BlockResource
	 * TODO	ADD BlockResourceTimeLogic
	 * TODO	ADD BlockType Entity / Static / Dynamic
	 * TODO	ADD ParticleEffect
	 * TODO	ADD Class(s)
	 * TODO	ADD AND Implement Method(s). 
	 *    	(delete when finished each TODO)
	 *  */
	protected float x,y;
	protected float px,py;
	protected ObjectID Id;
	protected float VelX = 0 , VelY = 0;
	protected Color C;
	protected boolean Falling = true;
	protected boolean Jumping = false;
	protected boolean BlockStatic = true;
	protected boolean BlockDynamic = false;
	protected BufferedImage img = null;
		
	
//Static & Dynamic Block Switch Statement
 {

		if(BlockStatic == false) {
			BlockDynamic = true;	
		} 
		else 
		if (BlockDynamic == false) {
			BlockStatic = true;
		}
		

}

    
	public ObjectBase(float x, float y, ObjectID Id){
		this.x = x;
		this.y = y;
		this.Id = Id;
	
	}
	
	
	 public abstract void tick (LinkedList<ObjectBase> Object);
	 
	 public abstract void render (Graphics g);
	
	 public abstract Rectangle getBoundsUp();
	 public abstract Rectangle getBoundsDown();
	 public abstract Rectangle getBoundsLeft();
	 public abstract Rectangle getBoundsRight();
	 public  void setColor (Color C){
		 this.C = C;
	 }
	 
	 public float getX(){
		 return x;
	 }
	 
	 public float getY(){
		 return y;
	 }
	 
	 
	 public void setX(float x){
		 this.x = x;
	 }
	 
	 public void setY(float y){
		 this.y = y;
	 }
	 
	 
	 public float getVelX(){
		 return VelX;
	 }
	 
	 public float getVelY(){
		 return VelY;
	 }
	 
	 
	 public void setVelX(float VelX){
		 this.VelX = VelX;
	 }
	 
	 public void setVelY(float VelY){
		 this.VelY = VelY;
	 }

	 
	 public boolean isJumping() {
		return Jumping;
	}


	public void setJumping(boolean jumping) {
		Jumping = jumping;
	}
	public boolean isFalling() {
		return Falling;
	}


	public void setFalling(boolean falling) {
		Falling = falling;
	}


	public boolean isBlockStatic() {
		return BlockStatic;
	}


	public void setBlockStatic(boolean blockStatic) {
		BlockStatic = blockStatic;
		
	}


	public boolean isBlockDynamic() {
		return BlockDynamic;
	}


	public void setBlockDynamic(boolean blockDynamic) {
		BlockDynamic = blockDynamic;
		
	}


	public  ObjectID getID(){
		return Id;
	}
	public void setImage(String s){
		
		 File f = new File(s);
			 try {
				img = ImageIO.read(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		
	
	public BufferedImage getImage(){
		return img;
		
	}
    
	public void setBoundsCollision(Graphics g, Rectangle BoundsUp, Rectangle BoundsDown , Rectangle BoundsLeft, Rectangle BoundsRight){
		Graphics2D g2d = (Graphics2D) g;
		g.setColor(Color.red);
		g2d.draw(BoundsUp);
		g2d.draw(BoundsDown);
		g2d.draw(BoundsLeft);
		g2d.draw(BoundsRight);
	}


	public void setImage(BufferedImage img) {
		this.img =  img;
		
	}

	
	
}

/*=== README ====
 * Soon I Plan To Add 3D Interface With LWJGL APT
 * For Now Focus On 2D Logic And Adding A Maven Interface
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */










package com.UnicSoftware.BoE;

import java.awt.Color;
import java.awt.Graphics;

@SuppressWarnings("unused")
public class Tile {
GameEng game;
int x, y;
int oX, oY;



public Tile(int x,int y, GameEng game){
	
	this.oX = 16 / x;
	this.oY = 16 / y;
	this.game = game;
}
public void tick(GameEng game){
	this.game = game;
	
	//x = oX + game.xOffset;
	//y = oY + game.yOffset;
	
}




public void render(Graphics g){
	
	g.drawString("oX: "+ oX + " oY: " + oY , 10, 10);
	

}



}

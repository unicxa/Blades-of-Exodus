package com.sickray.games.BoE.Utils;


import java.awt.Dimension;

import com.sickray.games.BoE.GameEng;

public class MapArray {
	//Map Array 
	//Grabs Map Info And Sets X - Y (FOR NOW *TODO* CHANGE) 
	


	

	public Dimension GetCellsAsWhole(GameEng g){
		Dimension d = new Dimension();
		int x;
		int y;
	y = (int) g.getHeight();
	x = (int) g.getWidth();
	d.setSize(x, y);
	
	
			System.out.println("X Cell: "+ x / 16  + " Y Cell: " + y / 16);
			return d;
	}
	
	
	public Dimension SetDimension16(int x,int y){
		
		 x = x * 16;
		 y = y * 16;
		return new Dimension(x,y);
		
	}
	
	public int SetX16(int x){
		
		 x = x * 16;
	   
		return x;
	}
	public int SetY16(int y){
		 y = y * 16;
		 
		return y;
		
	}
	

}

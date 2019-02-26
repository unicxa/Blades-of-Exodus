package com.sickray.games.BoE.Utils;

public abstract class Cell implements Cloneable {

	protected  Cell() {
	//Main Cell Method 
	// *TODO* ADD 16X16
			//ADD 32x32
			//ADD 16x32
			//Etc
	//Cells Make Up Sprites Base 2 Numbers Only Please 
	}
	
	
	public abstract void setCell(int x, int y, int width, int height);
	
	
	
	  public Object clone() {
	        try {
	            return super.clone();
	        } catch (CloneNotSupportedException e) {
	            // this shouldn't happen, since we are Cloneable
	            throw new InternalError(e);
	        }
	}
}
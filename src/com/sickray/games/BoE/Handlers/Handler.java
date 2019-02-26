package com.sickray.games.BoE.Handlers;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sickray.games.BoE.Enum.ObjectID;
import com.sickray.games.BoE.Objects.ObjectBase;
import com.sickray.games.BoE.Utils.MapArray;

public class Handler {

	public LinkedList<ObjectBase> object = new LinkedList<ObjectBase>();
	MapArray m;
	private ObjectBase temp;
	
	public void tick(){
		for(int i = 0; i < object.size(); i++ ){
			temp = object.get(i);
			temp.tick(object);
		}
	}
	public void render(Graphics G){
		for(int i = 0; i < object.size(); i++ ){
			temp = object.get(i);
			temp.render(G);
		}
	}

	public void addObject(ObjectBase object){
		this.object.add(object);
	}
	public void removeObject(ObjectBase object){
		this.object.remove(object);
	}
	@SuppressWarnings("unlikely-arg-type")
	public void removeObjectProLag(ObjectBase object){
		for(int i = 0; i < this.object.size(); i++){
		if(object.getID() == ObjectID.Fire){
			if(this.object.remove(this));
			System.out.println(this.toString());
		}
		
		else break;
		}
	}
	public void populateLevel(){
	
	}
}

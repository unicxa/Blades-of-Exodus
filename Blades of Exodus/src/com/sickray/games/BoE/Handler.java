package com.sickray.games.BoE;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sickray.games.BoE.Blocks.Grass;
import com.sickray.games.BoE.Blocks.ObjectBase;
import com.sickray34s.Enum.ObjectID;

public class Handler {

	public LinkedList<ObjectBase> object = new LinkedList<ObjectBase>();

	private ObjectBase temp;

	public void tick() {
		for (int i = 0; i < object.size(); i++) {
			temp = object.get(i);
			temp.tick(object);
		}
	}

	public void render(Graphics G) {
		for (int i = 0; i < object.size(); i++) {
			temp = object.get(i);
			temp.render(G);
		}
	}

	public void addObject(ObjectBase object) {
		this.object.add(object);
	}

	public void removeObject(ObjectBase object) {
		this.object.remove(object);
	}

	public void populateLevel() {
		for (int x = 0; x != 32; x++) {

			this.addObject(new Grass(x * 32, 32 * 15, ObjectID.Grass));

		}
	}
}

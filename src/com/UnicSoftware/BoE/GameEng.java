package com.UnicSoftware.BoE;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.UnicSoftware.BoE.Blocks.Grass;
import com.UnicSoftware.BoE.Blocks.ObjectBase;
import com.UnicSoftware.BoE.Entity.EntityPlayer;
import com.UnicSoftware.BoE.Enum.ObjectID;
import com.UnicSoftware.BoE.cell.Cell;
//import com.UnicSoftware.BoE.config.ConfigParse;
import com.UnicSoftware.BoE.maps.Map001;

public class GameEng extends Canvas implements Runnable {
	Handler handler;
	public static final long serialVersionUID = 1L;

	public int xOffset = 0;
	public int yOffset = 0;

	/*
	 * Res Must be a hexadecimal number system e.g ( 16 32 64 128 256 512 1024)
	 * #WARNING# Keep above 128 for best results
	 */

	JFrame frame;
	public static boolean running = false;
	public static final String TITLE = "Blades of Exodus";
	static int Width = 1024;
	static int Hight = 512;
	BufferedImage image = new BufferedImage(Width, Hight, BufferedImage.TYPE_INT_RGB);
	public static final Dimension gameDim = new Dimension(Width, Hight);
	public int tileWidth = 256;
	public int tileHight = 256;
	static int cell16 = 16;
	static int cell32 = 32;
	static int cell64 = 64;
	Map001 map = new Map001(this);
	public Cell cell = new Cell(Hight, Width, cell32);
	String s;

	public static boolean left, right, up, down;
	public   boolean ToggleDevMenu;

	
	public int frames;
	public int updates;
	
	
	Thread thread;

	@Override
	public void run() {

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				this.frames =  frames;
				this.updates = updates;
				frames = 0;
				updates = 0;
			}
		}
	}

	synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

	}

	synchronized void stop() {
		running = false;
		System.exit(0);
	}

	public GameEng(boolean debug) {
		this.ToggleDevMenu = debug;
		this.setMinimumSize(gameDim);
		this.setMaximumSize(gameDim);
		this.setPreferredSize(gameDim);
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		init();
		this.requestFocus();
	}

	private void init() {
	//	ConfigParse cfg = new ConfigParse(cell.getCellX(),cell.getCellY(),cell.getCellCount());
		handler = new Handler();

		handler.populateLevel();
		handler.addObject(new EntityPlayer(100, 100, handler, ObjectID.EntityPlayer));
		this.addKeyListener(new Inputhandler(handler, this));
	}

	public void tick() {
		handler.tick();
		map.tick();
		// moveMap()
		map.tick();
		KeyEvents();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);

		Debug(g);
		handler.render(g);

		g.dispose();
		bs.show();

	}
	public void setToggle(boolean toggle) {
		this.ToggleDevMenu = toggle;
	}

	public int cellY() {
		return cell.getCellY();
	}

	public int cellX() {
		return cell.getCellX();

	}

	public int cell() {
		return cell.getCellCount();

	}

	public void Debug(Graphics g) {
		if(this.ToggleDevMenu == true) {
		cell.render(g);
		}
		g.setColor(Color.RED);
		for (int i = 0; i < handler.object.size(); i++) {
			ObjectBase base = handler.object.get(i);
			

			g.drawString(
					"CellCount: " + cell.getCellCount() + " CellX: " + cell.getCellX() + " CellY: " + cell.getCellY(),
					15, 64);

			g.drawString(
					"Frames: " + this.frames + " FPS: " + this.updates ,
					15, 96);

			if (base.getID() == ObjectID.EntityPlayer) {
				g.drawString("Player: " + base.getID().toString() + " X: " + base.getX() + " Y: " + base.getY()
						+ " VelX " + base.getVelX() + " VelY " + base.getVelY(), 15, 32);
			}

		}

	}

	public void KeyEvents() {
		if (left == true) {
			xOffset--;
		}
		if (right == true) {
			xOffset++;
		}
		if (up == true) {
			yOffset--;
		}
		if (down == true) {
			yOffset++;
		}
	}

}

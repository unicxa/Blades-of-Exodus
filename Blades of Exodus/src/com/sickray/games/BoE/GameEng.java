package com.sickray.games.BoE;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import com.sickray.game.BoE.maps.Map001;
import com.sickray.games.BoE.Blocks.Grass;
import com.sickray.games.BoE.Blocks.ObjectBase;
import com.sickray.games.BoE.Entity.EntityPlayer;
import com.sickray34s.Enum.ObjectID;

public class GameEng extends Canvas implements Runnable {
	Handler handler;
    public static final long serialVersionUID = 1L;
   
    public int xOffset = 0;
    public int yOffset = 0;
    
  
    
    
  
    
    /* Res Must be a hexadecimal number 
     * system e.g ( 16 32 64 128 256 512 1024)
     * #WARNING# Keep above 128 for best results
     */
    
 
 
    
    	
    
    JFrame frame;
    public static boolean running = false;
    public static final String TITLE = "Blades of Exodus";
    static int Width = 1024;
    static int Hight = 512;
    BufferedImage image = new BufferedImage(Width,Hight,BufferedImage.TYPE_INT_RGB);
    public static final Dimension gameDim = new Dimension(Width,Hight);
    public int tileWidth = 256;
    public int tileHight = 256;
    Map001 map = new Map001(this);
    
    String s;
 
   public static boolean left,right,up,down,ToggleDevMenu;
    
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
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
					
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}
	
	synchronized void start(){
		if(running) return;
	running = true;
    thread = new Thread(this);
	thread.start();
		}
	 synchronized void  stop(){
	running = false;
	System.exit(0);
		}
	public GameEng(){
		this.setMinimumSize(gameDim);
		this.setMaximumSize(gameDim);
		this.setPreferredSize(gameDim);
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this,BorderLayout.CENTER);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		init();
		this.requestFocus();
	}
	private void init(){
		handler = new Handler();
		
		
		
		handler.populateLevel();
		handler.addObject(new EntityPlayer(100,100, handler, ObjectID.EntityPlayer));
		this.addKeyListener(new Inputhandler(handler,this));
	}
	
	
	public void tick(){
		handler.tick();
		map.tick();
		//moveMap()
		map.tick();
		KeyEvents();
	}
	

		
		
		
	
	public void render(){
		BufferStrategy  bs = this.getBufferStrategy();
		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0,0, this.getWidth(), this.getHeight(), null);
	
		
		
		handler.render(g);
		
		Debug(g);
		g.dispose();
		bs.show();
		
	}
	
	public void Debug(Graphics g){
		for(int i = 0; i < handler.object.size(); i++){
	    	 ObjectBase base = handler.object.get(i); 
	    	 
	    	 
	    	 if(base.getID() == ObjectID.EntityPlayer){
		g.drawString("Player: "+ base.getID().toString() + " X: " + base.getX() +  " Y: " +  base.getY() + " VelX " + base.getVelX() + " VelY " + base.getVelY(), 15, 32);
	    	 }
		}
	}
	

	public void KeyEvents(){
		if(left == true){
			xOffset--;
		}
		if(right == true){
			xOffset++;
		}
		if(up == true){
			yOffset--;
		}
		if(down == true){
			yOffset++;
		}
	}

}

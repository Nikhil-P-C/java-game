package MainPackage;

import java.awt.Graphics;

import entity.Player;

public class Game implements Runnable {
	
	private GamePanel gamePanel;
	private GameWindow gameWindow;
	private Thread GameThread;
	private final int FPS_SET=120;
	private final int UPS_SET=120;
	
	private Player player;
public Game() {
	initializeClasses();
	gamePanel = new GamePanel(this);
	gameWindow = new GameWindow(gamePanel);
	gamePanel.setFocusable(true);
	startGameloop();

}

private void initializeClasses() {
	player = new Player(200,200);
	
}

private void startGameloop() {
	GameThread = new Thread(this);
	GameThread.start();
}
public void update() {
	player.update();
}
public void render(Graphics g) {
	player.render(g);
}
@Override
public void run() {
	
	double timePerFrame = 1000000000.0/FPS_SET;
	double timePerUpdate = 1000000000.0/UPS_SET;
	
	long previousTime =System.nanoTime();
	
	int frames =0;
	int updates =0;
	long lastcheck =System.currentTimeMillis();
	
	double DeltaU =0;
	double DeltaF =0;
	
	while(true) {
		long currentTime=System.nanoTime();
		
		DeltaU += (currentTime - previousTime) / timePerUpdate;
		DeltaF += (currentTime - previousTime) / timePerFrame;
		previousTime= currentTime; 
		
		if(DeltaU >= 1) {
		    update();
			updates++;
			DeltaU--;
		}
		if(DeltaF >= 1) {
			gamePanel.repaint();
		    frames++;
		    DeltaF--;
		}
		
		
	    if(System.currentTimeMillis() - lastcheck >= 1000) {
	    	lastcheck=System.currentTimeMillis();
	    	System.out.println("FPS:"+frames +"| UPS:"+updates);
	    	frames =0;
	    	updates =0;
	    } 
	}
	
	
}
public Player getPlayer() {
	return player;
}



public void windowFocusLost() {
	player.resetBooleans();
	
}
}

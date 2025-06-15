package entity;

import static Utilz.Constants.Direction.DOWN;
import static Utilz.Constants.Direction.LEFT;
import static Utilz.Constants.Direction.RIGHT;
import static Utilz.Constants.Direction.UP;
import static Utilz.Constants.PlayerConstant.GetSpriteAmount;
import static Utilz.Constants.PlayerConstant.*;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Player extends Entity {
	private BufferedImage[][] Animation;
	private int aniTick,aniIndex,aniSpeed=15;
	private int playerAction=IDLE;
	private int playerDirection=-1;
	private boolean moving =false;
	private boolean attacking =false;
	public Player(float x, float y) {
		super(x, y);
		LoadAnimation();
	}
	
	public void update() {
		updateAniTick();
		setAnimation();
		updatePos();
	}
    
    public void render(Graphics g) {
    	g.drawImage(Animation[playerAction][aniIndex], (int)x, (int)y,256,160, null);
	}
	public void setDirection(int direction) {
		this.playerDirection = direction;
		moving = true;
		
	}
    public void resetBooleans() {
		moving =false;
		
	}
	
	public void setMoving(boolean moving) {
		this.moving =moving;
	}
	public void setAttacking(boolean attacking) {
		this.attacking =attacking;
	}

	private void updateAniTick() {
		aniTick++;
		if(aniTick >= aniSpeed) {
			aniTick =0;
			aniIndex++;
			if(aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
                attacking =false;
			}
		}
	}
	private void setAnimation() {
		int playerAni = playerAction;
		if(moving) {
			playerAction = RUNNING;
		}
		else {
			playerAction = IDLE;
		}
		if(attacking) {
			playerAction = ATTACK;
		}
		if(playerAni != playerAction) {
			resetAniTick();
		}
		
	}
	private void resetAniTick() {
		aniIndex =0;
		aniTick =0;
		
	}

	private void updatePos() {
		if(moving) {
			switch(playerDirection) {
			case LEFT:x -= 2;
				break;
			case UP:y -= 2;
				break;
			case RIGHT:x+= 2;
				break;
			case DOWN:y += 2;
				break;
			}
		}
		
	}
    private void LoadAnimation() {
    	InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		try {
			BufferedImage img = ImageIO.read(is);
			
			Animation = new BufferedImage[9][6];
			for(int j =0;j<Animation.length;j++) {
			for(int i =0;i<Animation[j].length;i++) {
				Animation[j][i]= img.getSubimage( i*64, j*40, 64, 40);
			}}
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
    	
    	
    	
		
}

	}

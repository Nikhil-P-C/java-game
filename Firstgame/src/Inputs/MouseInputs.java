package Inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import MainPackage.GamePanel;

public class MouseInputs implements MouseListener , MouseMotionListener {
	private GamePanel gamePanel;
	public MouseInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch(e.getButton()) {
		case MouseEvent.BUTTON1:gamePanel.getGame().getPlayer().setAttacking(true);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

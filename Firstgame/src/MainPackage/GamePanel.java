package MainPackage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import static Utilz.Constants.PlayerConstant.*;
import static Utilz.Constants.Direction.*;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs =new MouseInputs(this);
    private Game game;
	public GamePanel(Game game){
		setPanelSize();
		this.game = game;
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
		
	}
	private void setPanelSize() {
		Dimension size =new Dimension(1024,668);
		setPreferredSize(size);
	}
	
	public void updateGame() {
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
	}
	public Game getGame() {
		return game;
	}
}

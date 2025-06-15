package MainPackage;




import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;
public GameWindow(GamePanel gamePanel) {
	
	jframe =new JFrame();
	jframe.setResizable(false);
	jframe.setTitle("game");
	jframe.add(gamePanel);
	jframe.setLocationRelativeTo(null);
	jframe.pack();
	jframe.setVisible(true);
	jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
	jframe.addWindowFocusListener(new WindowFocusListener() {

		@Override
		public void windowGainedFocus(WindowEvent e) {
			
			
		}

		@Override
		public void windowLostFocus(WindowEvent e) {
			gamePanel.getGame().windowFocusLost();
			
		}
		
	});
}
}

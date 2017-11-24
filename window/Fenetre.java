package scrabble.game.window;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	public Fenetre(Panneau p) {
		 this.setTitle("SCRABBLE");    
		 this.setSize(900, 500);    
		 this.setLocationRelativeTo(null);    
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		 this.setContentPane(p);
		 this.setVisible(true); 
	}
	
}

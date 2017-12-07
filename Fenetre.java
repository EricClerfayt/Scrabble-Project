package scrabble.game.window;

import java.awt.BorderLayout;
import javax.swing.JFrame;


public class Fenetre extends JFrame {

	public Fenetre(Panneau p) {
		
		Menu menu = new Menu();
		
		
		
		this.setTitle("SCRABBLE");    
		this.setSize(900, 500);    
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new BorderLayout());
		
		this.getContentPane().add(p, BorderLayout.CENTER);
		this.getContentPane().add(menu, BorderLayout.NORTH);  
		 
		this.setVisible(true); 
	}
	
}

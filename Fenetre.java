package scrabble.game.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {	
	
	public Fenetre(Panneau p,Menu M) {
		
		//Button b = new Button(" teste ");
		//Button b1 = new Button(" test2 ");
		//Button b2 = new Button(" test3 ");
		
		JPanel p2 = new JPanel();
		//p2.add(b);
		//p2.add(b2);
		//p2.add(b1);
		p2.setBackground(new Color(10, 80, 40));
		
		setSize(1000,700);
		setResizable(false);
		
		this.setTitle("SCRABBLE");    
		this.setLocationRelativeTo(null);  
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setLayout(new BorderLayout());
		
		
		
		this.getContentPane().add(p2, BorderLayout.SOUTH);  
		this.getContentPane().add(p, BorderLayout.CENTER);
		 
		this.setVisible(true); 
	}
}
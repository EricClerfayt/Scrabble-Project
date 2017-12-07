package scrabble.game.window;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Menu extends JPanel {
	private JComboBox combo = new JComboBox();

	public Menu() {
		super();
		
	}
	
	public void paintComponent(Graphics g) {
		combo.setPreferredSize(new Dimension(100, 20));
		combo.addItem("Option 1");
	    combo.addItem("Option 2");
	    combo.addItem("Option 3");
	    combo.addItem("Option 4");
	}

}

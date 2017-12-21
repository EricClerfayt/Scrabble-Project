package scrabble.game.window;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Button extends JButton {

	private String name;
	public Button(String str) {
		super(str);
		this.name = str;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp = new GradientPaint(0, 0, Color.BLUE, 0, 0,Color.BLUE,true);
		g2d.setPaint(gp);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.BLACK);
		g2d.drawString(this.name, this.getWidth()/2-(this.getWidth()/2/4), (this.getHeight()/2)+5);
	}
	
	
	
}

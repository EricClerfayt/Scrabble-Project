package scrabble.game.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import scrabble.game.jeu.Jeu;
import scrabble.game.jeu.Lettre;

public class Panneau extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7781513288792808734L;
	/**
	 * 
	 */
	private Jeu jeu;
	
	public Panneau(Jeu _jeu) {
		jeu = _jeu;
		setMinimumSize(new Dimension(this.getHeight()/4, this.getWidth()));
		setMaximumSize(new Dimension(this.getHeight()/4, this.getWidth()));
	}
	
	public void paintComponent(Graphics g){ 
		
		Graphics2D fond = (Graphics2D)g;
		GradientPaint fd = new GradientPaint(0, 0, new Color(10, 80, 40), 0, 0, new Color(10, 80, 40));
		
		fond.setPaint(fd);
		fond.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int x1 = this.getWidth()/8;    
		int y1 = this.getHeight()/8;
		
		Lettre plateau[][] = jeu.getPlateau().getPlateau();
		int plateau_cases_spe[][] = jeu.getPlateau().getPlateau_cases_spe();
		Lettre[] handjoueur;
		
		if(jeu.getbool()) {			
			handjoueur = jeu.getJoueur().getJeu();
		}
		else {
			handjoueur = jeu.getOrdi().getJeu();
		}
		
		affichePlateau(plateau,plateau_cases_spe, x1, y1, g);
		afficheJeuJoueur(handjoueur, x1, y1, g);
		afficheScore(jeu.getJoueur().getScore(), jeu.getOrdi().getScore(), x1, y1, g);
	}
	
	public void affichePlateau(Lettre plateau[][],int plateau_cases_spe[][],int x1,int y1,Graphics g) {
		
		int setDecalX = 50;
		int setDecalY = 20;
	
		
		g.setColor(Color.white);
		g.fillRect(x1-25-setDecalX, y1-20, 325, 325);
		
		g.setColor(Color.GREEN);
		g.fillRect(x1-setDecalX, y1+5, 300, 300);
		
		
		int x=x1-setDecalX;
		int y=y1+setDecalY;
		
		for (int i=0 ; i<15 ; i++)
		{	
			for (int j=0 ; j<15 ; j++)
			{
				if(plateau[i][j].getLettre()=='0') {
					if(plateau_cases_spe[i][j]!=0) {
						switch (plateau_cases_spe[i][j]) {
						case 1:
							g.setColor(Color.CYAN);
							g.fillRect(x, y-15, 20, 20);
							g.setColor(Color.black);
							break;
						case 2:	
							g.setColor(Color.blue);
							g.fillRect(x, y-15, 20, 20);
							g.setColor(Color.black);
							break;
						case 3:	
							g.setColor(Color.PINK);
							g.fillRect(x, y-15, 20, 20);
							g.setColor(Color.black);
							break;
						case 4:
							g.setColor(Color.RED);
							g.fillRect(x, y-15, 20, 20);
							g.setColor(Color.black);
							break;
						default:
							break;
						}
					}
					g.drawString(" ", x, y);
				}
				else {
					g.setColor(Color.orange);
					g.fillRect(x, y-15, 20, 20);
					g.setColor(Color.black);
					g.drawString(" "+plateau[i][j].getLettre()+" ", x+2, y);
				}
				x+=20;
			}
			x=x1-setDecalX;
			y+=20;
		}
		
		x=x1-setDecalX;
		y=y1+setDecalY;
		
		for (int i=0 ; i<15 ; i++)
		{	
			for (int j=0 ; j<15 ; j++)
			{
				g.drawLine(x, y1+5-25,x , y+5);
				x+=20;
			}
			g.drawLine(x1-setDecalX-25, y+5-20,x , y+5-20);
			x=x1-setDecalX;
			y+=20;
		}	
		
		g.setColor(Color.black);
		g.drawRect(x1-setDecalX, y1+5, 300, 300);
		g.drawRect(x1-25-setDecalX, y1-20, 325, 325);
		
		x=x1-setDecalX;
		y=y1+setDecalY;
		
		for(int i=0;i<15;i++) {
			g.drawString("" + (i+1),x1-setDecalX-20,y);
			y+=20;
		}
		for(int i=0;i<15;i++) {
			g.drawString("" + (i+1),x+4,y1-5);
			x+=20;
		}
		
	}
	
	public void afficheCase(int plateau_cases_spe[][],int x1,int y1,Graphics g) {
		
		int x=x1 + 300;
		int y=y1;
		
		for (int i=0 ; i<15 ; i++)
		{
			for (int j=0 ; j<15 ; j++)
			{
				g.drawString(""+plateau_cases_spe[i][j], x, y);
				x+=20;
			}
			x=x1 + 300;
			y+=20;
		}
		
		
	}
	
	public void afficheScore(int J1,int J2,int x1,int y1,Graphics g) {
		
		int setDecalX = -400;
		int setDecalY = 20;
	
		g.setColor(Color.RED);
		g.fillRect(x1-setDecalX, y1+5, 150, 90);
		
		
		int x=x1-setDecalX;
		int y=y1+setDecalY;

		g.setColor(Color.black);
		
		g.drawString("SCORE",x+50,y);
		g.drawString("JOUEUR 1 : "+J1,x+10,y+25);
		g.drawString("JOUEUR 2 : "+J2,x+10,y+45);
		
		g.drawRect(x1-setDecalX, y1+5, 150, 90);
		
	}
	
	
	public void afficheJeuJoueur(Lettre[] handjoueur,int x1,int y1,Graphics g) {
		
		int setDecalX = 45;
		int setDecalY = 330;

		int x=x1-setDecalX;
		int y=y1+setDecalY;
		
		
		g.setColor(Color.orange);
		g.fillRect(x-5, y-15, 140, 20);
		
		g.setColor(Color.black);
		g.drawRect(x-5, y-15, 140, 20);
		
		for(int i = 0 ; i < jeu.getJoueur().tailleJeu(); i++) {
			if(handjoueur[i].getLettre() != '0') {
				if(handjoueur[i].getLettre() != ' ') {
					g.drawString(""+handjoueur[i].getLettre(),x,y);
				}
				else {
					g.drawString("_",x,y);
				}
			}
			else {
				g.drawString("!",x,y);
			}
			x+=20;
		}
		
		x=x1-setDecalX;
		
		for(int i = 0 ; i < jeu.getJoueur().tailleJeu()-1; i++) {
			g.drawLine(x+15, y-15, x+15, y+5);
			x+=20;
		}
	}
	
	
	
}
package scrabble.game.window;

import java.awt.Color;
import java.awt.Graphics;

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
	}
	
	public void paintComponent(Graphics g){ 
		
		int x1 = this.getWidth()/8;    
		int y1 = this.getHeight()/8;
		
		Lettre plateau[][] = jeu.getPlateau().getPlateau();
		int plateau_cases_spe[][] = jeu.getPlateau().getPlateau_cases_spe();
		Lettre[] handjoueur = jeu.getJoueur().getJeu();
		
		affichePlateau(plateau,plateau_cases_spe, x1, y1, g);
		afficheJeuJoueur(handjoueur, x1, y1, g);
	}
	
	public void affichePlateau(Lettre plateau[][],int plateau_cases_spe[][],int x1,int y1,Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillRect(x1-90, y1+5, 300, 300);
		g.setColor(Color.black);
		g.drawRect(x1-90, y1+5, 300, 300);
		 
		int x=x1-90;
		int y=y1+20;
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
						g.drawString(""+plateau_cases_spe[i][j], x, y);
					}
					g.drawString(" ", x, y);
				}
				else {
					g.drawString(" "+plateau[i][j].getLettre()+" ", x, y);
				}
				g.drawLine(x, y1+5,x , y+5);
				x+=20;
			}
			g.drawLine(x, y1+5,x , y+5);
			g.drawLine(x1-90, y+5,x , y+5);
			x=x1-90;
			y+=20;
		}
		for(int i=0;i<15;i++) {
			g.drawString("" + (i+1),x1-106,y);
			y+=20;
		}
		for(int i=0;i<15;i++) {
			g.drawString("" + (i+1),x,y1-5);
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
	
	public void afficheJeuJoueur(Lettre[] handjoueur,int x1,int y1,Graphics g) {
		
		int x=x1-100;
		int y=y1+350;
		
		for(int i = 0 ; i < jeu.getJoueur().tailleJeu(); i++) {
			if(handjoueur[i].getLettre() != '0') {
				g.drawString(""+handjoueur[i].getLettre(),x,y);
			}
			else {
				g.drawString("_",x,y);
			}
			x+=20;
		}
		
		
	}
	
	
	
}

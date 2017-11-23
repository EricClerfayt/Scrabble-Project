package scrabble.game.window;

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
		
		affichePlateau(plateau, x1, y1, g);
		afficheCase(plateau_cases_spe, x1, y1, g);
		afficheJeuJoueur(handjoueur, x1, y1, g);
		
		
	}
	
	public void affichePlateau(Lettre plateau[][],int x1,int y1,Graphics g) {
		
		int x=x1-100;
		int y=y1;
		
		for (int i=0 ; i<15 ; i++)
		{
			for (int j=0 ; j<15 ; j++)
			{
				g.drawString(""+plateau[i][j].getLettre(), x, y);
				x+=20;
			}
			x=x1-100;
			y+=20;
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
			g.drawString(""+handjoueur[i].getLettre(),x,y);
			x+=20;
		}
		
		
	}
	
	
	
}

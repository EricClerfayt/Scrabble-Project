package scrabble.game.jeu;

import scrabble.game.window.Fenetre;
import scrabble.game.window.Panneau;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Jeu jeu = new Jeu();
		
		jeu.getJoueur().afficherJeuJoueur();
		System.out.println(" ");
		jeu.toursEnCours();
		jeu.getJoueur().afficherJeuJoueur();
		
		//Panneau P = new Panneau(jeu);
		//Fenetre f = new Fenetre(P);
		jeu.getPlateau().afficher();
		//f.repaint();
		
		
	}

}

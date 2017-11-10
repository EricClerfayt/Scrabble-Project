package scrabble.game.jeu;

import scrabble.game.window.Fenetre;
import scrabble.game.window.Panneau;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Jeu jeu = new Jeu();
		
		Plateau plateau = new Plateau();
		jeu.toursEnCours();
		jeu.getJoueur().afficherJeuJoueur();
		jeu.getPioche().sauvgarde();
		Panneau P = new Panneau(jeu);
		Fenetre f = new Fenetre(P);
		plateau.afficher();
		
	}

}

package scrabble.game.jeu;

import scrabble.game.window.Fenetre;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Jeu jeu = new Jeu();
		jeu.toursEnCours();
		jeu.getJoueur().afficherJeuJoueur();
		jeu.getPioche().sauvgarde();
		Fenetre f = new Fenetre();
		
	}

}

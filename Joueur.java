package scrabble.game.jeu;

public class Joueur {
	
	private Lettre[] jeu = new Lettre[7];
	private int score ;
	
	public Joueur() {
		score = 0;
		for(int i=0; i<7; i++ ) {
			jeu[i] = new Lettre();
		}
	}

	/**
	 * donne la taille du jeu du joueur.
	 * @return le nombre de lettre que le joueur a dans la main;
	 */
	public int tailleJeu() {
		return jeu.length;
	}
	
	/**
	 * affiche le jeu du joueur.
	 */
	public void afficherJeuJoueur() {
		for(int i = 0 ; i < jeu.length; i++) {
			System.out.println(jeu[i].getLettre());
		}
	}
	
	/**
	 * ajoute une lettre dans la main du joueur.
	 * @return false si erreur sinon true.
	 */
	public boolean ajoutLettre(Lettre lettre) {
		
		for(int i = 0 ; i < jeu.length; i++) {
			if(jeu[i].getLettre() == '0') {
				jeu[i] = lettre;
				return true;
			}
		}
		return false;
	}
	
}

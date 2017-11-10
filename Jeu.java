package scrabble.game.jeu;


public class Jeu {

	private Plateau plateau = new Plateau();
	private Pioche pioche = new Pioche();
	private Joueur joueur = new Joueur();
	private Joueur ordi = new Joueur();
	
	
	public Jeu() {
	}

	
	public void toursEnCours () {
		
		for(int i = 0 ; i < joueur.tailleJeu(); i++) {
			
			char L = (char)pioche.donner();
			
			if(joueur.ajoutLettre(new Lettre(L)) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}
		for(int i = 0 ; i < ordi.tailleJeu(); i++) {
			char L = (char)pioche.donner();
			
			if(ordi.ajoutLettre(new Lettre(L)) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}
		
		
		
		
		
		
	}


	/**
	 * Getter and Setter
	 */
	
	public Pioche getPioche() {
		return pioche;
	}


	public void setPioche(Pioche pioche) {
		this.pioche = pioche;
	}


	public Joueur getJoueur() {
		return joueur;
	}


	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Joueur getOrdi() {
		return ordi;
	}


	public void setOrdi(Joueur ordi) {
		this.ordi = ordi;
	}


	public Plateau getPlateau() {
		return plateau;
	}


	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	
}

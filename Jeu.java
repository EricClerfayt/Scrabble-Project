package scrabble.game.jeu;


public class Jeu {

	private Plateau plateau = new Plateau();
	private Pioche pioche = new Pioche();
	private Joueur joueur = new Joueur();
	private Joueur ordi = new Joueur();
	private dico dictio = new dico();
	
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
		
		
		
		placerLettre(2, 4, 4);
		
		
	}

	
	
	
	/**
	 * placer une lettre sur le plateau
	 */
	
	public boolean placerLettre(int indice , int x , int y) 
	{
		Lettre lettre = joueur.getJeuIndice(indice-1);
		if( plateau.getPlateauIndice(x-1, y-1).getLettre() =='0') {
			plateau.setPlateauIndice(x-1, y-1, lettre );
			joueur.setJeuIndice(indice-1);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verification du mot placé avec le Dictionnaire
	 */
	
	public boolean verifierMot(Lettre [] mot)
	{
		String chaine = "";
		for(int i = 0;i<mot.length;i++)
		{
			chaine = chaine + Character.toString(mot[i].getLettre());
		}
		return dictio.recherche(chaine);
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


	public dico getDictio() {
		return dictio;
	}


	public void setDictio(dico dictio) {
		this.dictio = dictio;
	}
	
	
}

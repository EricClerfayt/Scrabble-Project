package scrabble.game.jeu;

import java.util.Scanner;

public class Jeu {

	private Plateau plateau = new Plateau();
	private Pioche pioche = new Pioche();
	private Joueur joueur = new Joueur();
	private Joueur ordi = new Joueur();
	
	
	public Jeu() {
	}

	
	public void toursEnCours () {
		
		Lettre[] mot = new Lettre[16];
		
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
		
		mot = demanderJeu();
		
		System.out.println("" + mot[0]);
		
		//placerMot(mot, 5, 5, Direction.HAUT);
		
	}
	
	
	/**
	 * place le mot du joueur dans le tableau
	 */
	
	public boolean placerMot(Lettre[] mot,int x,int y,Direction direction) {
		
		switch (direction)
		{
		case HAUT:
			for(int i=0;i<mot.length;i++) {
				System.out.println("" + mot[i]);
				plateau.setPlateauIndice(x-1, y-1, mot[i] );
				y++;
			}
			break;
		case BAS:
			for(int i=0;i<mot.length;i++) {
				
			}
			break;
		case DROITE:
			for(int i=0;i<mot.length;i++) {
				
			}
			break;
		case GAUCHE:
			for(int i=0;i<mot.length;i++) {
				
			}
			break;
		
		} 
		return false;
	}
	
	
	
	

	/**
	 * Demande au joueur le mot qu'il veux jouer
	 */
	
	public Lettre[] demanderJeu() {
		
		Lettre[] mot = new Lettre[16];
		
		Scanner sc = new Scanner(System.in);
		
		String motDemander = sc.nextLine();

		char[] motJouer = motDemander.toCharArray();
		
		for(int i=0; i < motJouer.length;i++ ) {
			
			mot[i] = new Lettre(motJouer[i]);
			System.out.println((int)motJouer[i]);
		}
		System.out.println("" + mot[0]);
		return mot;
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

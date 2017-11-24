package scrabble.game.jeu;

import java.util.Scanner;

public class Jeu {

	private Plateau plateau = new Plateau();
	private Pioche pioche = new Pioche();
	private Joueur joueur = new Joueur();
	private Joueur ordi = new Joueur();
	private dico dictio = new dico();
	
	
	public Jeu() {
	}

	
	public void toursEnCours () {
		
		Lettre[] mot = new Lettre[16];
		
		for(int i = 0 ; i < joueur.tailleJeu(); i++) {
			
			Lettre L = pioche.donner();
			
			if(joueur.ajoutLettre(L) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}
		for(int i = 0 ; i < ordi.tailleJeu(); i++) {
			Lettre L = pioche.donner();
			
			if(ordi.ajoutLettre(L) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}
		
		mot = demanderJeu();
		
		
		placerMot(mot, 1, 1, Direction.BAS);
		
		
		
		
	}
	
	
	/**
	 * place le mot du joueur dans le tableau
	 */
	
	public boolean placerMot(Lettre[] mot,int x,int y,Direction direction) {
		
		int i=0;
		
		switch (direction)
		{
		
		case BAS:
			while(mot[i] != null || i == mot.length-1) {
				plateau.setPlateauIndice(x-1, y-1, mot[i] );
				x++;
				i++;
			}
			break;
		case DROITE:
			while(mot[i] != null || i == mot.length-1){
				plateau.setPlateauIndice(x-1, y-1, mot[i] );
				y++;
				i++;
			}
			break;
		
		} 
		return false;
	}
	
	
	
	

	/**
	 * Demande au joueur le mot qu'il veux jouer
	 */
	
	public Lettre[] demanderJeu() {
		
		Lettre[] mot = new Lettre[15];
		char[] motJouer;
		
		Scanner sc = new Scanner(System.in);
		
		String motDemander = sc.nextLine();
		if(motDemander.equals(motDemander.toUpperCase()))
		{
			motJouer = motDemander.toCharArray();
		}
		else
		{
			
			motJouer = motDemander.toUpperCase().toCharArray();
		}

		
		for(int i=0; i < motJouer.length;i++ ) {
			
			if(verifierLongMot(motJouer)==true) {
				
			mot[i] = new Lettre(motJouer[i]);
			
			}else return null;
		}
		
		return mot;
	}	
	
	
	
	/**
	 * Vérifier la longueur d'un mot  
	 */
	
 public boolean verifierLongMot(char[] mot) {
		 
		 if(mot.length > 1 && mot.length <= 15) {
			 
			 return true;
		 }
		 return false;
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
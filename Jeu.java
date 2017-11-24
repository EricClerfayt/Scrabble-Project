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
		
		if (verifierPlacementMot(mot, 1, 12, Direction.BAS))
		{
			placerMot(mot, 1, 12, Direction.BAS);
		}
		
		
		
	
		
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
		
		Lettre[] mot = new Lettre[16];
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
			
			
			mot[i] = new Lettre(motJouer[i]);
		}
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
	
	 /*
	  * Verification du placement du mot
	  * si chevauchement et que la lettre du plateau ne correspond pas à la lettre du mot, return false
	  * si le mot dépasse du plateau, return false
	  * sinon return true
	  */
	 
	 public boolean verifierPlacementMot(Lettre[] mot,int x,int y,Direction direction) {
			
			int i=0;
			private boolean place;
			
			switch (direction)
			{
			
			case BAS:
				while(mot[i] != null || i == mot.length-1) 
				{
					 if (((plateau.getPlateau[x-1][y-1].getLettre() == plateau.getVide()) || (plateau.getPlateau[x-1][y-1].getLettre() == mot[i])) && (((x-1)<15 && (x-1)>= 0) && ((y-1)<15 && (y-1)>= 0)))
					 {
						 place = true;
						 x++;
						 i++;
					 }
					 else return false;
				}
				return place;
				break;
			case DROITE:
				while(mot[i] != null || i == mot.length-1) 
				{
					 if (((plateau.getPlateau[x-1][y-1].getLettre() == vide) || (plateau.getPlateau[x-1][y-1].getLettre() == mot[i])) && (((x-1)<15 && (x-1)>= 0) && ((y-1)<15 && (y-1)>= 0)))
					{
						place = true;
						y++;
						i++;
					}
					else return false;
				}
				return place;
				break;
			} 
			return false;
	 }
		
		/*
		 * Conditions de fin de partie
		 * 
		 * si la pioche est vide
		 * ou abandon d'un joueur
		 * ou refus de jeu / impossibilité de jouer
		 */
		
		public void FinDePartie()
		{
			/*
			 * Pioche vide. Comparaison des scores
			 */
			if (pioche.getNbLettre() == 0)
			{
				if ((joueur.getScore() < ordi.getScore())
				{
					System.out.println("Victoire de joueur2 \n");
					System.out.println("Score joueur 1 :" + joueur.getScore() + "\n");
					System.out.println("Score joueur 2 :" + ordi.getScore() + "\n");
				}
				else if ((joueur.getScore() == ordi.getScore())
				{
					System.out.println("Match nul. Les joueurs sont ex-aequo.\n");
					System.out.println("Score joueur 1 :" + joueur.getScore() + "\n");
					System.out.println("Score joueur 2 :" + ordi.getScore() + "\n");
				}
				else
				{
					System.out.println("Victoire de joueur1 \n");
					System.out.println("Score joueur 1 :" + joueur.getScore() + "\n");
					System.out.println("Score joueur 2 :" + ordi.getScore() + "\n");	
				}
			}
			
			/*
			 * Abandon d'un joueur
			 */

			//créer les boutons AbandonJoueur1 et AbandonJoueur2
			
			if (joueur.abandon == 1) 
				System.out.println("Victoire de joueur2 par abandon de joueur1");
			else (ordi.abandon == 1)
				System.out.println("Victoire de joueur1 par abandon de joueur2");
			
			/*
			 * si les joueurs ont passé chacun 3 fois consécutivement (sans qu'aucun mot n'ait été posé)
			 * défalquement des points (des lettres du chevalet/de la main) non joués (chevalets personnels) des scores
			 */

			//créer compteur de passes consécutives

			if ((joueur.passe.compteur == 3) && (ordi.passe.compteur == 3))
			{
				System.out.println("refus de jeu de la part des 2 joueurs \n");
				joueur.getScore() -= joueur.chevalet; //chevalet = somme des points des lettres du chevalet de joueur1
				ordi.getScore() -= ordi.chevalet; //chevalet = somme des points des lettres du chevalet d'ordi ou joueur2
			}
			
			/*
			 *  bloquer le jeu (ne plus pouvoir jouer) (à faire)
			 *  pas les boutons ...
			 */
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

package scrabble.game.jeu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {

	private Plateau plateau = new Plateau();
	private Pioche pioche = new Pioche();
	private Joueur joueur = new Joueur();
	private Joueur ordi = new Joueur();
	private dico dictio = new dico();
	private boolean first = true;


	public Jeu() {
	}


	public void toursEnCours (Joueur courant) {

		// variable.
		Lettre[] mot = new Lettre[15];
		int x=-1,y=-1;
		Direction direction = null;
		Scanner sc = new Scanner(System.in);
		String d;

		boolean valide = false;
		int n = 0;
		int j = 0;
		
		//donne les lettres au joueur.
		for(int i = 0 ; i < courant.tailleJeu(); i++) {

			Lettre L = pioche.donner();

			if(courant.ajoutLettre(L) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}
		
		courant.afficherJeuJoueur();
		
		//choix de l'action
		System.out.println("Voulez-vous: \n 1- Jouer un mot \n 2-Passer votre Tour \n 3-Changer N Lettres \n");
		switch(sc.nextInt()){

		case 1:
			while(valide==false)
			{
				//demande le mot a jouer
				System.out.println("Quelle mot jouer ?");
				mot = demanderJeu();
				
				//demande sa position et sa direction
				System.out.println("A quelle position ?");
				x = number();
				System.out.println(x);
				y = number();
				System.out.println(y);
				System.out.println("Dans quelle direction ?");
				System.out.println(direction);
				direction = choixDirection();
				System.out.println(direction);
				
				//verification si le mot et jouable.
				if(mot[0]!=null) {			
					if(canPlay(mot, 5, 10, Direction.DROITE, courant.getJeu(), plateau.getPlateau())){
						if(verifierPlacementMot(mot, x, y, direction)) {
							if(verifierMot(mot)) {
								if(!placerMot(mot, x, y, direction)) {
									System.out.println("## ERREUR : il est impossible de placer le mot (placerMot)");
								}
								else {
									courant.setScore(courant.getScore()+courant.calculpoint(mot, x, y, direction));
								}
							}
							else {
								System.out.println("## ERREUR : il est impossible de placer le mot(verifierMot)");
							}
						}
						else {
							System.out.println("## ERREUR : il est impossible de placer le mot(verifierPlacementMot)");
						}
					}
					else {
						System.out.println("## ERREUR : il est impossible de placer le mot(canPlay)");
					}
				}
				else {
					System.out.println("## ERREUR : lecture de mot incorecte(demanderJeu)");
				}
			}
			

			break;

		case 2:
			System.out.println("Vous avez passez votre tour.");
			break;

		case 3:
			sc.nextLine();
			System.out.println("Combien de lettres voulait vous defausser?(de 1 à 7 lettres)");
			while(n>7 || n<=0)
				n = sc.nextInt();
			Lettre [] defausse = new Lettre[n];
			while(n>0)
			{
				sc.nextLine();
				System.out.println("Quelle lettre voulait vous defausser?(donner l'indice de la lettre dans votre main 0-6)");
				j = sc.nextInt();
				defausse[n-1] = new Lettre(courant.getJeuIndice(j).getLettre());
				courant.getJeu()[j].setLettre('0');
				n--;
			}
			pioche.reprendre(defausse);
			for(int i = 0 ; i < courant.tailleJeu(); i++){

				Lettre L = pioche.donner();

				if(courant.ajoutLettre(L) == false) {
					System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
				}
			}	

			break;

		}
	}

	
	/**
	 * 
	 * @param mot
	 * @param x
	 * @param y
	 * @param direction
	 * @return
	 */
	private boolean testeFirst(Lettre[] mot,int x,int y,Direction direction) {
		
		int taille=0;
		switch (direction)
		{
		case BAS:
			if(x != 7) {return false;}
			while(mot[taille] != null || taille == mot.length-1) {
				taille++;
			}
			if(y+taille<7 || y > 7){return false;}
			
			break;
		case DROITE:
			if(y != 7) return false;
			while(mot[taille] != null || taille == mot.length-1) {
				taille++;
			}
			if(x+taille<7 || x > 7){return false;}
			break;
		}		
		return true;
	}
	
	


	/**
	 * prend en paramétre un mot, comment le placer et les lettre possible du joueur ainssi que le plateau en cours.
	 * @param mot
	 * @param x
	 * @param y
	 * @param direction
	 * @param jeu
	 * @param plateau
	 * @return
	 */
	public boolean canPlay(Lettre[] mot,int x,int y,Direction direction,Lettre[] jeu,Lettre plateau[][]) {

		
		
		if(!testeFirst(mot, x, y, direction)) {return false;}
		
		int i = 0,j = 0;
		Lettre[] lettreRestante = new Lettre[mot.length];
		Lettre[] copieJeu = new Lettre[jeu.length];
		for(i = 0; i < copieJeu.length;i++) {
			copieJeu[i]=new Lettre(jeu[i].getLettre());
		}

		
		switch (direction)
		{


		case BAS:
			while(mot[i] != null || i == mot.length-1) {
				if(plateau[x][y].getLettre() == '0') {	
					lettreRestante[j] = new Lettre(mot[i].getLettre());
					j++;
				}
				else if(plateau[x][y].getLettre() != mot[i].getLettre()) {
					return false;
				}
				x++;
				i++;
			}
			break;
		case DROITE:
			while(mot[i] != null || i == mot.length-1){
				if(plateau[x-1][y-1].getLettre() == '0') {
					lettreRestante[j] = new Lettre(mot[i].getLettre());
					j++;
				}
				else {
					if(plateau[x-1][y-1].getLettre() != mot[i].getLettre()) {
						return false;
					}
				}

				y++;
				i++;
			}
			break;
		} 

		i=0;
		
		while(lettreRestante[i] != null || i == lettreRestante.length-1) {
			for(j = 0; j < copieJeu.length;j++) {				
				if(lettreRestante[i].getLettre()==copieJeu[j].getLettre()) {
					copieJeu[j].setLettre('0');
					lettreRestante[i].setLettre('0');
				}
			}
			i++;
		}

		i=0;
		
		while(lettreRestante[i] != null || i == lettreRestante.length-1) {
			if(lettreRestante[i].getLettre()!='0') {return false;}
			i++;
		}

		return true;
	}


	// renvoit un chiffre pour le placement dans le plateau
	public int number() {
		boolean erreur;
		int valeur=-1;
		 Scanner sc = new Scanner(System.in);
		
		do {
		    erreur = false;
		    try {
				valeur=sc.nextInt();
		    } catch (InputMismatchException e) {
		       erreur = true;
		    }
		   
		} while (erreur && !(valeur<1 && valeur>16));
	
		return valeur;
	}

	// renvoit une direction pour le placement dans le plateau
	private Direction choixDirection() {
		boolean erreur;
		Direction direction = null;
		String d;
		 Scanner sc = new Scanner(System.in);
		
		do {
		    erreur = false;
		    try {
				d=sc.nextLine();
				if(d.equals("bas")) {
					direction = Direction.BAS;
				}
				if(d.equals("droite")) {
					direction = Direction.DROITE;
				}
		    } catch (InputMismatchException e) {
		       erreur = true;
		    }
		} while (erreur && direction==null);
		return direction;
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



		for(int i=0; i < motJouer.length;i++ ) 
		{			
			 if(verifierLongMot(motJouer)==true)
			 {				
				mot[i] = new Lettre(motJouer[i]);			
			}else return mot;
		}		
		
		return mot;
	}	
	
	
	/**
	 * Vérifier la longueur d'un mot  
	 */
	 	
	public boolean verifierLongMot(char[] mot) 
	{ 		 
		if(mot.length > 1 && mot.length <= 15) 
		{	 
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
		int i = 0;
		String chaine = "";
		while(mot[i] != null || i == mot.length-1)
		{
			chaine = chaine + Character.toString(mot[i].getLettre());
			i++;
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
			boolean place = false;
			
			switch (direction)
			{
			
			case BAS:
				while(mot[i] != null || i == mot.length-1) 
				{
					 if (((plateau.getPlateauIndice(x-1, y-1).getLettre() == plateau.getVide()) || (plateau.getPlateauIndice(x-1, y-1).getLettre() == mot[i].getLettre())) && (((x-1)<15 && (x-1)>= 0) && ((y-1)<15 && (y-1)>= 0)))
					 {
						 place = true;
						 x++;
						 i++;
					 }
					 else return false;
				}
				return place;
			case DROITE:
				while(mot[i] != null || i == mot.length-1) 
				{
					 if (((plateau.getPlateauIndice(x-1, y-1).getLettre() == plateau.getVide()) || (plateau.getPlateauIndice(x-1, y-1).getLettre() == mot[i].getLettre())) && (((x-1)<15 && (x-1)>= 0) && ((y-1)<15 && (y-1)>= 0)))
					{
						place = true;
						y++;
						i++;
					}
					else return false;
				}
				return place;
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
				if (joueur.getScore() < ordi.getScore())
				{
					System.out.println("Victoire de joueur2 \n");
					System.out.println("Score joueur 1 :" + joueur.getScore() + "\n");
					System.out.println("Score joueur 2 :" + ordi.getScore() + "\n");
				}
				else if (joueur.getScore() == ordi.getScore())
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
			/*
			if (joueur.abandon == 1) 
				System.out.println("Victoire de joueur2 par abandon de joueur1");
			else (ordi.abandon == 1)
				System.out.println("Victoire de joueur1 par abandon de joueur2");
			*/
			/*
			 * si les joueurs ont passé chacun 3 fois consécutivement (sans qu'aucun mot n'ait été posé)
			 * défalquement des points (des lettres du chevalet/de la main) non joués (chevalets personnels) des scores
			 */

			//créer compteur de passes consécutives

			/*
			if ((joueur.passe.compteur == 3) && (ordi.passe.compteur == 3))
			{
				System.out.println("refus de jeu de la part des 2 joueurs \n");
				joueur.getScore() -= joueur.chevalet; //chevalet = somme des points des lettres du chevalet de joueur1
				ordi.getScore() -= ordi.chevalet; //chevalet = somme des points des lettres du chevalet d'ordi ou joueur2
			}
			*/
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

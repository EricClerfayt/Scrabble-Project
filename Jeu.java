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


	public void toursEnCours (Joueur courant) {
		boolean valide = false;
		Lettre[] mot = new Lettre[16];
		int n = 0;
		int j = 0;

		Scanner sc = new Scanner(System.in);

		for(int i = 0 ; i < courant.tailleJeu(); i++) {

			Lettre L = pioche.donner();

			if(courant.ajoutLettre(L) == false) {
				System.out.println("## ERREUR : ajoutLettre retourne false dans ajoutLettre Joueur ##");
			}
		}

		courant.afficherJeuJoueur();

		System.out.println("Voulez-vous: \n 1- Jouer un mot \n 2-Passer votre Tour \n 3-Changer N Lettres \n");
		switch(sc.nextInt()){

		case 1:
			while(valide==false)
			{
				mot = demanderJeu();

				valide = verifierMot(mot);

				if(valide)
					System.out.println("Mot Valide.");
				else
					System.out.println("Mot Non Valide.");
			}
			placerMot(mot, 1, 1, Direction.BAS);

			break;

		case 2:
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

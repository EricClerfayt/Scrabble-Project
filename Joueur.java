package scrabble.game.jeu;

public class Joueur {
	
	
	// contient les lettres du joueur ('0' si case vide)
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
			System.out.print(jeu[i].getLettre());
		}
		System.out.println("");
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
	
	
	
	/**
	 * calculer le score d'un mot
	 * @return le score du mot placé.
	 */
	
	public int calculpoint(Lettre[] mot,int x,int y,Direction direction) {
	
		
		 Lettre l = new Lettre();
		 Plateau plateau = new Plateau();
		 
		 int multMot = 1;
		 int score = 0;
		 
		 int i = 0;
		 
		 while(mot[i] != null || i == mot.length-1) {
			 
			 l.setLettre(mot[i].getLettre());
			 l.setScore(mot[i].getScore());
			 switch (direction)
				{
				case BAS:
						 switch (plateau.getPlateau_cases_speIndice(x-1, y-1))
						 {
						 case 0:
							 score += l.getScore();
							 break;
						 case 4:
							 score += l.getScore();
							 multMot += 3;
							 break;
						 case 3:
							 score += l.getScore();
							 multMot += 2;
							 break;
						 case 2:
							 score += l.getScore()*3;
							 break;
						 case 1:
							 score += l.getScore()*2;
							 break;
					}
						 x++;
					break;
				case DROITE:
						switch (plateau.getPlateau_cases_speIndice(x-1, y-1))
						 {
						 case 0:
							 score += l.getScore();
							 break;
						 case 4:
							 score += l.getScore();
							 multMot += 3;
							 break;
						 case 3:
							 score += l.getScore();
							 multMot += 2;
							 break;
						 case 2:
							 score += l.getScore()*3;
							 break;
						 case 1:
							 score += l.getScore()*2;
							 break;
					}
						y++;
					break;
				}
			 i++;
		 }
			score = score* multMot;
			return score;
	}	

	/**
	 * Getter and Setter
	 */

	public Lettre getJeuIndice(int indice) {
		return jeu[indice];
	}
	
	public Lettre[] getJeu() {
		return jeu;
	}

	public void setJeuIndice(int indice) {
		Lettre l = new Lettre();
		this.jeu[indice] = l;
	}
	public void setJeu(Lettre[] jeu) {
		this.jeu = jeu;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}

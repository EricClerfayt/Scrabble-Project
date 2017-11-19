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
		
		
		

		/**
		 * calculer le score d'un mot
		 * @return le score du mot placé.
		 */
		
	public int calculpoint(Lettre[] mot) {
		
			
			 Lettre l = new Lettre();
			 Plateau p = new Plateau();
			 mot = new Lettre[15];
			 int multLettre = 1;
			 int multMot = 1;
			 
			for (int i = 0; i< mot.length; i++) {
				
				l.initialisationLettre(mot[i].getLettre());
				
				if(l.getLettre()!='0') {
					
					for (int k=0 ; k<15 ; k++) {
						for (int j=0 ; j<15 ; j++)
						{
							if(p.getPlateau_cases_spe().equals(1)) {
								multLettre = 2;
							}
							else if(p.getPlateau_cases_spe().equals(2)) {
								multLettre = 3;
							}else multLettre = 1;
							
							if(p.getPlateau_cases_spe().equals(3)) {
								multMot = 2;
							}else if(p.getPlateau_cases_spe().equals(4)){
								multMot = 3;
							}else multMot = 1;
						}
					}
					
					score += l.getScore() * multLettre;
				
			} 
				score = score* multMot;
		}
			
			
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
	
	


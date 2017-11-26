package scrabble.game.jeu;




public class Partie {

	public static void main(String[] args) {
		
		//creation du jeu;
		Jeu jeu = new Jeu();

		//creation de la variable de victoire
		boolean victoire = false;
		
		//creation boucle de jeu
		
		while(!victoire) {
			jeu.getPlateau().afficher();
			
			jeu.toursEnCours(jeu.getJoueur());
			
			//jeu.FinDePartie(); /* non fini + return void */
			
			jeu.getPlateau().afficher();
			
			jeu.toursEnCours(jeu.getOrdi());
			
			//jeu.FinDePartie(); /* non fini + return void */
		}
		
		
	}

}

package scrabble.game.jeu;

import scrabble.game.window.*;

public class Partie {

	public static void main(String[] args) {
		
		//creation du jeu;
		Jeu Jeu = new Jeu();
		Panneau P = new Panneau(Jeu);
		Fenetre f = new Fenetre(P);

		//creation de la variable de victoire
		boolean victoire = false;
		
		//creation boucle de jeu
		
		if(true) {
			
			//FLEUR
			Jeu.getJoueur().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(6)));
			Jeu.getJoueur().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(12)));
			Jeu.getJoueur().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(5)));
			Jeu.getJoueur().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(21)));
			Jeu.getJoueur().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(18)));
			
			//CANARD
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(3)));
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(1)));
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(14)));
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(1)));
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(18)));
			Jeu.getOrdi().ajoutLettre(new Lettre(Jeu.getPioche().tableauLettre.get(4)));
			
		}
		
		
		
		
		
		while(!victoire) {
			f.repaint();
			Jeu.toursEnCours(Jeu.getJoueur(),f);
			f.repaint();
			//Jeu.FinDePartie(); /* non fini + return void */		
			Jeu.toursEnCours(Jeu.getOrdi(),f);
			f.repaint();
			//Jeu.FinDePartie(); /* non fini + return void */
		}
		
		
	}

}

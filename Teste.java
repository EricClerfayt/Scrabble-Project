package scrabble.game.jeu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import scrabble.game.window.Fenetre;
import scrabble.game.window.Panneau;

public class Teste {

	public Teste() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		
		HashMap<Integer, Character> tableauLettre = new HashMap<>();
		
		  tableauLettre.put(10, 'a');
		  tableauLettre.put(20, 'b');
		  tableauLettre.put(30, 'c');
		  tableauLettre.put(40, 'd');
		  tableauLettre.put(50, 'e');
		  
		  
		  System.out.println("Parcours de l'objet HashMap : ");
	      Set<Entry<Integer, Character>> setHm = tableauLettre.entrySet();
	      Iterator<Entry<Integer, Character>> it = setHm.iterator();
	      while(it.hasNext()){
	         Entry<Integer, Character> e = it.next();
	         System.out.println(e.getKey() + " : " + e.getValue());
	      }
	      
	      System.out.println("Valeur pour la clé 8 : " + tableauLettre.get(8));

		
		/*
		Jeu jeu = new Jeu();
		
		jeu.getJoueur().afficherJeuJoueur();
		System.out.println(" ");
		//jeu.toursEnCours();
		jeu.getJoueur().afficherJeuJoueur();
		
		//Panneau P = new Panneau(jeu);
		//Fenetre f = new Fenetre(P);
		jeu.getPlateau().afficher();
		//f.repaint();
		*/
	}

}

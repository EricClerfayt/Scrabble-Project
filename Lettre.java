/**
 * 
 */
package scrabble.game.jeu;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author simon strzelecki
 *
 */
public class Lettre implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4012544490248004650L;
	/**
	 * 
	 */
	
	private char lettre;
	private int score;
	HashMap<Character, Integer> tableauLettre = new HashMap<>();
	
	
	
	
	
	/**
	 * constructeur qui prend en parramétre un char et initialise la lettre
	 * @param _lettre
	 * @param _score
	 */
	public Lettre(char c) {
		initialisationHashMap();
		initialisationLettre(c);
	}
	/**
	 * constructeur par defaut
	 */
	public Lettre() {
		initialisationHashMap();
		lettre = '0';
		score = 0;
	}
	
	/**
	 * initialise la hash map
	 */
	public void initialisationHashMap() {
		tableauLettre.put('A',1);
		tableauLettre.put('B',2);
		tableauLettre.put('C',3);
		tableauLettre.put('D',4);
		tableauLettre.put('E',5);
		tableauLettre.put('F',6);
		tableauLettre.put('G',7);
		tableauLettre.put('H',8);
		tableauLettre.put('I',9);
		tableauLettre.put('J',10);
		tableauLettre.put('K',11);
		tableauLettre.put('L',12);
		tableauLettre.put('M',13);
		tableauLettre.put('N',14);
		tableauLettre.put('O',15);
		tableauLettre.put('P',16);
		tableauLettre.put('Q',17);
		tableauLettre.put('R',18);
		tableauLettre.put('S',19);
		tableauLettre.put('T',20);
		tableauLettre.put('U',21);
		tableauLettre.put('V',22);
		tableauLettre.put('W',23);
		tableauLettre.put('X',24);
		tableauLettre.put('Y',25);
		tableauLettre.put('Z',26);
		tableauLettre.put(' ',27);
	}
	
	
	
	/**
	 * Prend en parramettre un char pour le retrouver dans le tableau des lettres affin d'initialiser le score.
	 * @param c (char)
	 */
	public void initialisationLettre(char c) {
		
		
		int valeur = tableauLettre.get(c);
		lettre=c;
		
		switch(valeur-1) {
		
		case 26:
			score = 0;
			break;
		case 0:
			score = 1;
			break;
		case 1:
			score = 3;
			break;
		case 2:
			score = 3;
			break;
		case 3:
			score = 2;
			break;
		case 4:
			score = 1;
			break;
		case 5:
			score = 4;
			break;
		case 6:
			score = 2;
			break;
		case 7:
			score = 4;
			break;
		case 8:
			score = 1;
			break;
		case 9:
			score = 8;
			break;
		case 10:
			score = 10;
			break;
		case 11:
			score = 1;
			break;
		case 12:
			score = 2;
			break;
		case 13:
			score = 1;
			break;
		case 14:
			score = 1;
			break;
		case 15:
			score = 3;
			break;
		case 16:
			score = 8;
			break;
		case 17:
			score = 1;
			break;
		case 18:
			score = 1;
			break;
		case 19:
			score = 1;
			break;
		case 20:
			score = 1;
			break;
		case 21:
			score = 4;
			break;
		case 22:
			score = 10;
			break;
		case 23:
			score = 10;
			break;
		case 24:
			score = 10;
			break;
		case 25:
			score = 10;
			break;
		default:
			
			break;
		}
		
	}

	
	/**
	 * Renvoie l'Indice D'une Lettre
	 */
	public int indice(char c){
		return tableauLettre.get(c);
	}
	
	
	
	
	/**
	 * Getter and Setter
	 */
	
	public char getLettre() {
		return lettre;
	}

	public void setLettre(char lettre) {
		this.lettre = lettre;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public HashMap<Character, Integer> getTableauLettre() {
		return tableauLettre;
	}

}
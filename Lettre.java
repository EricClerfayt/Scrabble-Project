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
	HashMap<Integer, Character> tableauLettre = new HashMap<>();
	
	
	
	
	
	/**
	 * @param _lettre
	 * @param _score
	 */
	public Lettre(int valeur) {
		initialisationHashMap();
		initialisationLettre(valeur);
	}
	public Lettre() {
		initialisationHashMap();
		lettre = '0';
		score = 0;
	}
	
	public void initialisationHashMap() {
		tableauLettre.put(1, 'A');
		tableauLettre.put(1, 'B');
		tableauLettre.put(1, 'C');
		tableauLettre.put(1, 'D');
		tableauLettre.put(1, 'E');
		tableauLettre.put(1, 'F');
		tableauLettre.put(1, 'G');
		tableauLettre.put(1, 'H');
		tableauLettre.put(1, 'I');
		tableauLettre.put(1, 'J');
		tableauLettre.put(1, 'K');
		tableauLettre.put(1, 'L');
		tableauLettre.put(1, 'M');
		tableauLettre.put(1, 'N');
		tableauLettre.put(1, 'O');
		tableauLettre.put(1, 'P');
		tableauLettre.put(1, 'Q');
		tableauLettre.put(1, 'R');
		tableauLettre.put(1, 'S');
		tableauLettre.put(1, 'T');
		tableauLettre.put(1, 'U');
		tableauLettre.put(1, 'V');
		tableauLettre.put(1, 'W');
		tableauLettre.put(1, 'X');
		tableauLettre.put(1, 'Y');
		tableauLettre.put(1, 'Z');
		tableauLettre.put(1, ' ');
		
	}
	
	
	
	
	public void initialisationLettre(int valeur) {
		
		lettre = tableauLettre.get(valeur);
		
		switch(valleur) {
		
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
	
	
	
	

}

/**
 * 
 */
package scrabble.game.jeu;


/**
 * @author simon strzelecki
 *
 */
public class Lettre {

	/**
	 * 
	 */
	
	private char lettre;
	private int score;
	
	/**
	 * @param _lettre
	 * @param _score
	 */
	public Lettre(int asciiVal) {
		initialisationLettre(asciiVal);
	}
	
	public void initialisationLettre(int asciiVal) {
		
		switch(asciiVal) {
		
		case 97:
			lettre = 'a';
			score = 1;
			break;
		case 98:
			lettre = 'b';
			score = 3;
			break;
		case 99:
			lettre = 'c';
			score = 3;
			break;
		case 100:
			lettre = 'd';
			score = 2;
			break;
		case 101:
			lettre = 'e';
			score = 1;
			break;
		case 102:
			lettre = 'f';
			score = 4;
			break;
		case 103:
			lettre = 'g';
			score = 2;
			break;
		case 104:
			lettre = 'h';
			score = 4;
			break;
		case 105:
			lettre = 'i';
			score = 1;
			break;
		case 106:
			lettre = 'j';
			score = 8;
			break;
		case 107:
			lettre = 'k';
			score = 10;
			break;
		case 108:
			lettre = 'l';
			score = 1;
			break;
		case 109:
			lettre = 'm';
			score = 2;
			break;
		case 110:
			lettre = 'n';
			score = 1;
			break;
		case 111:
			lettre = 'o';
			score = 1;
			break;
		case 112:
			lettre = 'p';
			score = 3;
			break;
		case 113:
			lettre = 'q';
			score = 8;
			break;
		case 114:
			lettre = 'r';
			score = 1;
			break;
		case 115:
			lettre = 's';
			score = 1;
			break;
		case 116:
			lettre = 't';
			score = 1;
			break;
		case 117:
			lettre = 'u';
			score = 1;
			break;
		case 118:
			lettre = 'v';
			score = 4;
			break;
		case 119:
			lettre = 'w';
			score = 10;
			break;
		case 120:
			lettre = 'x';
			score = 10;
			break;
		case 121:
			lettre = 'y';
			score = 10;
			break;
		case 122:
			lettre = 'z';
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

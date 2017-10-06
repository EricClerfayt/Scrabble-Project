package scrabble.game.jeu;

/**
 * @author simon strzelecki
 *
 */
public class Pioche {

	private int[] pioche = new int[26];
	
	/**
	 * 
	 */
	
	public Pioche() {
		initialisationPioche();
	}

	
	/**
	 * initialise le nombre de lettre restante dans la pioche.
	 */
	public void initialisationPioche() {
		pioche[0] = 9;
		pioche[1] = 2;
		pioche[2] = 2;
		pioche[3] = 3;
		pioche[4] = 15;
		pioche[5] = 2;
		pioche[6] = 2;
		pioche[7] = 2;
		pioche[8] = 8;
		pioche[9] = 1;
		pioche[10] = 1;
		pioche[11] = 5;
		pioche[12] = 3;
		pioche[13] = 6;
		pioche[14] = 6;
		pioche[15] = 2;
		pioche[16] = 1;
		pioche[17] = 6;
		pioche[18] = 6;
		pioche[19] = 6;
		pioche[20] = 6;
		pioche[21] = 2;
		pioche[22] = 1;
		pioche[23] = 1;
		pioche[25] = 1;
		pioche[25] = 1;
	}


	
	/**
	 * Getter and Setter
	 */
	
	
	public int[] getPioche() {
		return pioche;
	}


	public void setPioche(int[] pioche) {
		this.pioche = pioche;
	}
}

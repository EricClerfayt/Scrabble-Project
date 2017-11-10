package scrabble.game.jeu;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;




/**
 * @author simon strzelecki
 *
 */
public class Pioche implements Serializable{

	private int[] pioche = new int[27];
	private int nbLettre;
	/**
	 * 
	 */
	
	public Pioche() {
		initialisationPioche();
		nbLettre = 102;
	}

	
	public Pioche(Pioche pioche2) {
		nbLettre = pioche2.nbLettre;
		pioche = pioche2.pioche;
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
		pioche[24] = 1;
		pioche[25] = 1;
		pioche[26] = 2;
	}


	/**
	 * pioche une lettre aléatoirement dans la pioche.
	 * @return la la valeur ASCII de la lettre ou -1 si erreur
	 */
	public int donner() {
		

		
		int lettre;
		
		if(nbLettre != 0){
			do {
				lettre =(int)(Math.random()*27);
				
				if(pioche[lettre] != 0) {
					nbLettre --;
					if(lettre == 26) {
						return 32;
					}
					else {
						return (97+lettre);						
					}
				}
			}while (true);
		}
		
		return -1;
	}
	
	
	/**
	 * sauvegarde la pioche.
	 */
	
	public void sauvgarde(){	
		ObjectOutputStream oos;
		try{
			oos=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Pioche.txt"))));
			oos.writeObject(this);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * chargement de la pioche.
	 */
	
	
	public Pioche lecture(){
		
		ObjectInputStream ois;
		Pioche p=null;
		try{
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("pioche.txt"))));
			
				System.out.println(((Pioche)ois.readObject()).toString());
			 p=new Pioche(((Pioche)ois.readObject()));
			
			
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
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

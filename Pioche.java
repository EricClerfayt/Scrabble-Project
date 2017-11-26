package scrabble.game.jeu;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;




/**
 * @author simon strzelecki
 *
 */
public class Pioche implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465219085131690909L;
	private int[] pioche = new int[27];
	private int nbLettre;
	HashMap< Integer, Character> tableauLettre = new HashMap<>();
	/**
	 * 
	 */
	
	public Pioche() {
		initialisationPioche();
		nbLettre = 102;
		initialisationHashMap();
	}

	
	public Pioche(Pioche pioche2) {
		nbLettre = pioche2.nbLettre;
		pioche = pioche2.pioche;
		initialisationHashMap();
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
	 * initialise la hash map
	 */
	public void initialisationHashMap() {
		tableauLettre.put(1,'A');
		tableauLettre.put(2,'B');
		tableauLettre.put(3,'C');
		tableauLettre.put(4,'D');
		tableauLettre.put(5,'E');
		tableauLettre.put(6,'F');
		tableauLettre.put(7,'G');
		tableauLettre.put(8,'H');
		tableauLettre.put(9,'I');
		tableauLettre.put(10,'J');
		tableauLettre.put(11,'K');
		tableauLettre.put(12,'L');
		tableauLettre.put(13,'M');
		tableauLettre.put(14,'N');
		tableauLettre.put(15,'O');
		tableauLettre.put(16,'P');
		tableauLettre.put(17,'Q');
		tableauLettre.put(18,'R');
		tableauLettre.put(19,'S');
		tableauLettre.put(20,'T');
		tableauLettre.put(21,'U');
		tableauLettre.put(22,'V');
		tableauLettre.put(23,'W');
		tableauLettre.put(24,'X');
		tableauLettre.put(25,'Y');
		tableauLettre.put(26,'Z');
		tableauLettre.put(27,' ');
	}

	/**
	 * pioche une lettre aléatoirement dans la pioche.
	 * @return la lettre ( 0 si erreur)
	 */
	public Lettre donner() {
		

		
		int lettre;
		
		if(nbLettre != 0){
			do {
				lettre =(int)(Math.random()*27+1);
				
				if(pioche[lettre-1] != 0){
					nbLettre --;
					pioche[lettre-1] --;
					if(lettre == 26) {
						return (new Lettre(' '));
					}
					else {
						return (new Lettre(tableauLettre.get(lettre)));						
					}
				}
			}while (true);
		}
		
		return (new Lettre());
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
	 * Reprendre lettre
	 */

	public void reprendre(Lettre [] defausse)
	{
		int n = 0;
		for(int i = 0;i<defausse.length;i++)
		{
			n = defausse[i].indice(defausse[i].getLettre());
			pioche[n-1]++;
			nbLettre++;
		}
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


	public int getNbLettre() {
		return nbLettre;
	}


	public void setNbLettre(int nbLettre) {
		this.nbLettre = nbLettre;
	}
	
}

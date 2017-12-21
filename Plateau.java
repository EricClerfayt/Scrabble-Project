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
 * initialisation du plateau de scrabble
 * * plateau : plateau (initialisé) de lettres
 * plateau_cases_spe : plateau des cases spéciales
 * 
 * sauvegarde (serialisation) et lecture (deserialisation) du plateau
 */

/**
 * @author Gransebi
 *
 */

public class Plateau implements Serializable
{
	private static final long serialVersionUID = -6199088246846017310L;
	private Lettre plateau[][] = new Lettre[15][15];
	private int plateau_cases_spe[][] = new int[15][15];
	private int i,j;
	//la Lettre vide sert pour l'initialisation du plateau de Lettres
	private Lettre vide = new Lettre();

	public Plateau() {initialisation(); CasesSpeciales();}
	
	public Plateau(Plateau plateau2) {
		plateau = plateau2.plateau;
		plateau_cases_spe = plateau2.plateau_cases_spe;
	}
	

    public void initialisation()
	{
		for (i=0 ; i<15 ; i++)
			for (j=0 ; j<15 ; j++)
			{
				plateau[i][j] = vide;
			}
	}

	
	public void CasesSpeciales() 
	{
		for (i=0 ; i<15 ; i++)
			for (j=0 ; j<15 ; j++)
			{
				plateau_cases_spe[i][j] = 0;
			}
		
			   plateau_cases_spe[0][0] = plateau_cases_spe[0][7] = plateau_cases_spe[0][14] = plateau_cases_spe[7][0] = 
		   plateau_cases_spe[7][14] = plateau_cases_spe[14][0] = plateau_cases_spe[14][7] = plateau_cases_spe[14][14] = 4; //mot triple MT
		
				plateau_cases_spe[1][1] = plateau_cases_spe[2][2] = plateau_cases_spe[3][3] = plateau_cases_spe[4][4] = 
			plateau_cases_spe[1][13] = plateau_cases_spe[2][12] = plateau_cases_spe[3][11] = plateau_cases_spe[4][10] =
			plateau_cases_spe[13][1] = plateau_cases_spe[12][2] = plateau_cases_spe[11][3] = plateau_cases_spe[10][4] = 
		plateau_cases_spe[10][10] = plateau_cases_spe[11][11] = plateau_cases_spe[12][12] = plateau_cases_spe[13][13] = 3; //mot double MD
		
			  plateau_cases_spe[1][5] = plateau_cases_spe[1][9] = plateau_cases_spe[13][5] = plateau_cases_spe[13][9] =
			   plateau_cases_spe[5][1] = plateau_cases_spe[5][5] = plateau_cases_spe[5][9] = plateau_cases_spe[5][13] = 
		       plateau_cases_spe[9][1] = plateau_cases_spe[9][5] = plateau_cases_spe[9][9] = plateau_cases_spe[9][13] = 2; //lettre triple LT
		
			   plateau_cases_spe[0][3] = plateau_cases_spe[0][11] = plateau_cases_spe[2][6] = plateau_cases_spe[2][8] = 
			   plateau_cases_spe[3][0] = plateau_cases_spe[3][7] = plateau_cases_spe[3][14] = plateau_cases_spe[6][2] = 
			   plateau_cases_spe[6][6] = plateau_cases_spe[6][8] = plateau_cases_spe[6][12] = plateau_cases_spe[7][3] = 
			   plateau_cases_spe[7][11] = plateau_cases_spe[8][2] = plateau_cases_spe[8][6] = plateau_cases_spe[8][8] = 
		   plateau_cases_spe[8][12] = plateau_cases_spe[11][0] = plateau_cases_spe[11][7] = plateau_cases_spe[11][14] = 
		   plateau_cases_spe[12][6] = plateau_cases_spe[12][8] = plateau_cases_spe[14][3] = plateau_cases_spe[14][11] = 1; //lettre double LD
		
			 								  plateau_cases_spe[7][7] = 3; //case centrale CC (MD)
	}
	
	public void afficher()
	{
		System.out.println ("voici le plateau initialisé (toutes les cases initialisées ŕ '0' et score = 0):");
		for (i=0 ; i<15 ; i++)
		{
			for (j=0 ; j<15 ; j++)
			{
				System.out.print (plateau[i][j].getLettre() + " ");
			}
			System.out.println (" ");
		}
		System.out.println();
	
		System.out.println ("voici le plateau avec les cases speciales: ");
		for (i=0 ; i<15 ; i++)
		{
			for (j=0 ; j<15 ; j++)
			{
				System.out.print (plateau_cases_spe[i][j] + " ");
			}
			System.out.println (" ");
		}	
	}



	/**
	 * sauvegarde du plateau.
	 */
	
	public void sauvegarde(){	
		ObjectOutputStream oos;
		try{
			oos=new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("Plateau.txt"))));
			oos.writeObject(this);
			oos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * chargement du plateau.
	 */
	
	
	public Plateau lecture(){
		
		ObjectInputStream ois;
		Plateau p=null;
		try{
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File("plateau.txt"))));
			
				System.out.println(((Plateau)ois.readObject()).toString());
		 p = new Plateau(((Plateau)ois.readObject()));
			
			
			ois.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return p;
	}

	
	
	/**
	 * Getter and Setter
	 */
	
	
 
	public Lettre getPlateauIndice(int x, int y){
		return plateau[x][y];
	}
	public Lettre[][] getPlateau() {
		return plateau;
	}
	
	public void setPlateauIndice(int x, int y,Lettre lettre) {
		this.plateau[x][y] = lettre;
	}
	public void setPlateau(Lettre[][] plateau) {
		this.plateau = plateau;
	}
	
	
	public int[][] getPlateau_cases_spe() {
		return plateau_cases_spe;
	}
	public int getPlateau_cases_speIndice(int x,int y) {
		return plateau_cases_spe[x][y];
	}
	
	public void setPlateau_cases_spe(int[][] plateau_cases_spe) {
		this.plateau_cases_spe = plateau_cases_spe;
	}
	
	
	public char getVide() {
		return vide.getLettre();
	}
	
}
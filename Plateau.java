package Game;

/**
 * initialisation du plateau de scrabble
 * A : plateau (initialisé) de lettres
 * B : plateau des cases spéciales
 */

/**
 * @author Gransebi
 *
 */

public class Plateau
{
	Lettre A[][] = new Lettre[15][15];
	int B[][] = new int[15][15];
	int i,j;
	//la Lettre vide sert pour l'initialisation du plateau de Lettres
	Lettre vide = new Lettre();

	public Plateau() {initialisation(); CasesSpeciales();}
	

    public void initialisation()
	{
		for (i=0 ; i<15 ; i++)
			for (j=0 ; j<15 ; j++)
			{
				A[i][j] = vide;
			}
	}

	
	public void CasesSpeciales() 
	{
		for (i=0 ; i<15 ; i++)
			for (j=0 ; j<15 ; j++)
			{
				B[i][j] = 0;
			}
		
			   B[0][0] = B[0][7] = B[0][14] = B[7][0] = 
		   B[7][14] = B[14][0] = B[14][7] = B[14][14] = 4; //mot triple MT
		
				B[1][1] = B[2][2] = B[3][3] = B[4][4] = 
			B[1][13] = B[2][12] = B[3][11] = B[4][10] =
			B[13][1] = B[12][2] = B[11][3] = B[10][4] = 
		B[10][10] = B[11][11] = B[12][12] = B[13][13] = 3; //mot double MD
		
			  B[1][5] = B[1][9] = B[13][5] = B[13][9] =
			   B[5][1] = B[5][5] = B[5][9] = B[5][13] = 
		       B[9][1] = B[9][5] = B[9][9] = B[9][13] = 2; //lettre triple LT
		
			   B[0][3] = B[0][11] = B[2][6] = B[2][8] = 
			   B[3][0] = B[3][7] = B[3][14] = B[6][2] = 
			   B[6][6] = B[6][8] = B[6][12] = B[7][3] = 
			   B[7][11] = B[8][2] = B[8][6] = B[8][8] = 
		   B[8][12] = B[11][0] = B[11][7] = B[11][14] = 
		   B[12][6] = B[12][8] = B[14][3] = B[14][11] = 1; //lettre double LD
		
			 								  B[7][7] = 3; //case centrale CC (MD)
	}
	
	public void afficher()
	{
		System.out.println ("voici le plateau initialisé (toutes les cases initialisées à '0' et score = 0):");
		for (i=0 ; i<15 ; i++)
		{
			for (j=0 ; j<15 ; j++)
			{
				System.out.print (A[i][j].getLettre() + " ");
			}
			System.out.println (" ");
		}
		System.out.println();
	
		System.out.println ("voici le plateau avec les cases speciales: ");
		for (i=0 ; i<15 ; i++)
		{
			for (j=0 ; j<15 ; j++)
			{
				System.out.print (B[i][j] + " ");
			}
			System.out.println (" ");
		}	
	}
}

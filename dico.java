package scrabble.game.jeu;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * @author Clerfayt Eric
 *
 */

public class dico {
	
	//Méthode pour comparer le mot posé(String) à la ligne extraite du dictionnaire(String) et renvoyant un boolean si ils sont identiques
	private static boolean Comparaison(int lineNo, String line, String mot) {
		//String m = line.toLowerCase();
		
		if(mot.equals(line))
			return true;
		else
			return false;
	}

	//Methode de lecture ligne par ligne du dictionnaire pour comparer au mot donné (String) renvoyant un boolean si ils sont identiques
	public static boolean recherche(String mot) 
	{
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(".\\src\\scrabble\\game\\jeu\\Dictionnaire.txt");//Chemin du fichier Dictionnaire
			br = new BufferedReader(fr);
			String line;	//ligne extraite
			int lineNo = 0;
			while ((line = br.readLine()) != null) {
				if(Comparaison(++lineNo, line, mot))//Appelle de la fonction de comparaison
				{
					try {br.close();} catch (Exception ignoreMe) {} //Fermeture des flux
					try {fr.close();} catch (Exception ignoreMe) {}
					return true; // Mot trouvé dans le dictionnaire
				}
			}
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		finally {
			if (fr != null) {
				try {br.close();} catch (Exception ignoreMe) {} //Fermeture des flux
				try {fr.close();} catch (Exception ignoreMe) {}
			}
		}
		return false; //Mot non trouvé
	}

}




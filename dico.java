package scrabble.game.jeu;

import java.io.BufferedReader;
import java.io.FileReader;


public class dico {
	
	
	private static boolean Comparaison(int lineNo, String line, String mot) {
		if(mot.equals(line))
			return true;
		else
			return false;
	}

	public static boolean recherche(String mot) 
	{
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(".\\src\\scrabble\\game\\jeu\\Dictionnaire.txt");
			br = new BufferedReader(fr);
			String line;
			int lineNo = 0;
			while ((line = br.readLine()) != null) {
				if(Comparaison(++lineNo, line, mot))
				{
					try {br.close();} catch (Exception ignoreMe) {}
					try {fr.close();} catch (Exception ignoreMe) {}
					return true;
				}
			}
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		finally {
			if (fr != null) {
				try {br.close();} catch (Exception ignoreMe) {}
				try {fr.close();} catch (Exception ignoreMe) {}
			}
		}
		return false;
	}

}




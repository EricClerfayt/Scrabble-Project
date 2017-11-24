package scrabble.game.jeu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solveur {
	
	
	
	
	public static void aide(Lettre [] main) 
	{
		String chaine = "";
		for(int i = 0;i<main.length;i++)
		{
			chaine = chaine + Character.toString(main[i].getLettre());
		}
		
		BufferedReader br = null;
		FileReader fr = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader(".\\src\\scrabble\\game\\jeu\\Dictionnaire.txt");//Chemin du fichier Dictionnaire
			br = new BufferedReader(fr);
			fw = new FileWriter(".\\src\\scrabble\\game\\jeu\\Possibilite.txt");//Chemin du fichier Dictionnaire
			bw = new BufferedWriter(fw);
			
			String line;	//ligne extraite
			while ((line = br.readLine()) != null) {
				String m = line.toLowerCase();
				if(m.contains(Character.toString(chaine.charAt(0))) && m.contains(Character.toString(chaine.charAt(1)))&& m.contains(Character.toString(chaine.charAt(2)))&& m.contains(Character.toString(chaine.charAt(3)))&& m.contains(Character.toString(chaine.charAt(4)))&& m.contains(Character.toString(chaine.charAt(5)))&& m.contains(Character.toString(chaine.charAt(6))))
				{
					bw.write(m);
					bw.newLine();
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
				try {bw.close();} catch (Exception ignoreMe) {} //Fermeture des flux
				try {fw.close();} catch (Exception ignoreMe) {}
			}
		}
	}
}

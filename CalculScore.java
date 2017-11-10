package scrabble.game.jeu;

public class CalculScore {
	
// calcul point calculer les point d'un mot placé 
	
int calculpoint(String mot) {
		
		int point = 0, multMot = 1, multLettre = 1;
		
		Plateau p = new Plateau();
		
		Lettre l = new Lettre();
		
		for (int i = 0; i< mot.length(); i++) {
			
			char c = mot.charAt(i); 
			int ch = (int)c;  
			
			l.initialisationLettre(ch);
			
			if(ch==l.getLettre()) {
				
				for (int k=0 ; k<15 ; k++)
					for (int j=0 ; j<15 ; j++)
					{
						if(p.B[k][j] == 1) {
							multLettre = 2;
						}
						else if(p.B[k][j] == 2) {
							multLettre = 3;
						}else multLettre = 1;
						
						if(p.B[k][j] == 3) {
							multMot = 2;
						}else if(p.B[k][j] == 4) {
							multMot = 3;
						}else multMot = 1;
					}
				
				
				point += l.getScore() * multLettre;
				
				
			}
			
			
			
		} 
		
		point = point* multMot;
		
		return point;
	}
	

}

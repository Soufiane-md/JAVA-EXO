package fr.m2i.models;

import fr.m2i.models.Combattant;
import fr.m2i.models.Guerrier;
import fr.m2i.models.Mage;
import fr.m2i.models.Soigneur;

public class Jeu {

	public static void main(String[] args) {
		Combattant[] combattants = {
				new Guerrier("Hurlenfer", "Garrosh"),
				new Mage("Proudmore", "Jaina"),
				new Soigneur("Wrynn", "Anduin"),
				new Guerrier("Barbe-de-Bronze", "Magni"),
				new Mage("Haut-Soleil", "Kael'Thas")
		};
		
		int premier = (int)(Math.random() * 5);
		int deuxieme = -1;
		do {
			deuxieme = (int)(Math.random() * 5);
		} while (deuxieme == premier);
		
		Combattant combattant1 = combattants[premier];
		Combattant combattant2 = combattants[deuxieme];

		System.out.println(String.format("%s vs %s !", combattant1.getPrenom(), combattant2.getPrenom()));
		int tour = 0;
		while (combattant1.getPtsVie() > 0 && combattant2.getPtsVie() > 0 && tour < 20) {
			if (tour % 2 == 0) {
				combattant1.action(combattant2);
			} else {
				combattant2.action(combattant1);
			}
			tour++;
		}
		
		Combattant vainqueur = combattant1.getPtsVie() > 0 ? combattant1 : combattant2;
		System.out.println(String.format("%s a gagné !", vainqueur.getPrenom()));
	}
	
	/*
	public static void action(Combattant combattant, Combattant victime) {
		if (combattant instanceof Guerrier) {
			((Guerrier) combattant).attaquer(victime);
		} else if (combattant instanceof Soigneur) {
			((Soigneur) combattant).soigner();
		} else if (combattant instanceof Mage) {
			if (combattant.getPtsVie() > combattant.getPtsVieMax() / 2) {
				((Mage) combattant).attaquer(victime);
			} else {
				((Mage) combattant).soigner();
			}
		}
	}
	*/

}

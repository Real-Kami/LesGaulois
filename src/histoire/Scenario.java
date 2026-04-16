package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Chaudron;
import village_gaulois.Musee;

import java.util.Iterator;

import objets.Equipement;

//import village_gaulois.Musee;

public class Scenario {
	
	public static void main(String[] args) {
		
		// partie bataille des gaulois
		
		Chaudron chaudron = new Chaudron(0, 0);
		Druide druide = new Druide("Panoramix", 5);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.fabriquerPotion(5, 3, chaudron);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix, chaudron);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix, chaudron);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");

		for (int i = 0; i < 2; i++) {
			int force_avant_coup = minus.getForce();
			asterix.frapper(minus);

			if (force_avant_coup == minus.getForce()) {
				minus.parler("Alors " + asterix.getNom() + " on fait moins le malin face à mon équipement!");
				obelix.parler("Tu veux un peu d'aide " + asterix.getNom() + " ?");
				obelix.frapper(minus);
			}
		}

		// Partie musée des trophées
		
		Musee musee = new Musee();
		
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			obelix.frapper(milexcus);
		} while (milexcus.getForce() > 0);

		
		obelix.faireUneDonnation(musee);

		System.out.println(musee.extraireVersOCaml());
		
	}

}
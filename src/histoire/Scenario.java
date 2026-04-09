package histoire;

import personnages.Gaulois;
import personnages.Romain;
import personnages.Druide;
import personnages.Chaudron;
import objets.Equipement;

//import village_gaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
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
		int force_avant_coup = minus.getForce();
		asterix.frapper(minus);
		
		// MINUS EST PAS CENSE ABANDONNER CAR EQUIPEMENT.
		
//		if (force_avant_coup == minus.getForce()) {
//			minus.parler("Alors " + asterix.getNom() + " on fait moins le malin face à mon équipement!");
//		}

//		PARTIE 5 : a decommenter
//		milexcus.parler("UN GAU... UN GAUGAU...");
//		do {
//			obelix.frapper(milexcus);
//		} while (milexcus.getForce() > 0);

//		Musee musee = new Musee();
//		obelix.faireUneDonnation(musee);

	}

}
package test_fonctionnel;

import personnages.Chaudron;
import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;
import village_gaulois.Village;

public class TestGaulois {
	public static void main(String[] args) {
		/*
		 * Gaulois asterix = new Gaulois("Astérix", 8); Gaulois obelix = new
		 * Gaulois("Obélix", 16);
		 * 
		 * asterix.parler("Bonjour Obélix.");
		 * obelix.parler("Bonjour Astérix, Ca te dirais d'aler chasser des sangliers ?"
		 * ); asterix.parler("Oui très bonne idée");
		 * 
		 * Romain minus = new Romain("Minus", 6);
		 * 
		 * System.out.println("Dans la forêt " + asterix.getNom() + " et " +
		 * obelix.getNom() + " rencontrent " + minus.getNom() + ".");
		 * 
		 * for (int i = 0; i < 3; i++) { asterix.frapper(minus); }
		 */
		
		/*
		 * Gaulois asterix = new Gaulois("Astérix", 8); Gaulois obelix = new
		 * Gaulois("Obélix", 16); Romain brutus = new Romain( "Brutus", 14); Druide
		 * panoramix = new Druide( "Panoramix", 2); Chaudron chaudron = new Chaudron(0,
		 * 0);
		 * 
		 * panoramix.fabriquerPotion(4, 3, chaudron); panoramix.booster(obelix,
		 * chaudron); panoramix.booster(asterix, chaudron);
		 * 
		 * for (int i = 0; i < 3; i++) { asterix.frapper(brutus); }
		 */	
		
		System.out.println("--- Partie village gaulois ---");
		
		Gaulois abra = new Gaulois("Abraracourcix", 6);		
		Village village_gaulois = new Village("Village des irréductibles", 30, abra);
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix  = new Gaulois("Obélix", 25);
		Gaulois dpolem  = new Gaulois("Doublepolémix", 4);


		Gaulois gaulois_inconnu;
		
		gaulois_inconnu = village_gaulois.trouverVillageois(30);
		
		village_gaulois.ajouterVillageois(asterix);

		gaulois_inconnu = village_gaulois.trouverVillageois(0);
		System.out.println(gaulois_inconnu.getNom());
		
		gaulois_inconnu = village_gaulois.trouverVillageois(1);
		System.out.println(gaulois_inconnu);
		
		village_gaulois.ajouterVillageois(obelix);
		
		village_gaulois.afficherVillage();
		
		abra.sePresenter(village_gaulois);
		asterix.sePresenter(village_gaulois);
		obelix.sePresenter(village_gaulois);
		dpolem.sePresenter(village_gaulois);
		
		//System.out.println(village_gaulois.estVillageois(asterix));
		
		System.out.println("--- Partie invariants ---");
		
		Romain minus = new Romain("Minus", 6);
		minus.parler("Bonjour je suis le romain Minus, et je ne suis pas très fort...");

	}
}

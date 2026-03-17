package village_gaulois;

import personnages.Gaulois;

public class Village {

	private String nom;
	private int nbVillageois;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	
	
	public Village(String nom, int capaciteMax, Gaulois chef) {
		this.nom = nom;
		this.nbVillageois = 0;
		this.villageois = new Gaulois[capaciteMax+1];
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return this.chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		this.villageois[nbVillageois] = gaulois;
		this.nbVillageois += 1;
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (this.nbVillageois <= numVillageois) {
			System.out.println("Il n'y a pas autant de villageois dans notre village !");
			return null;
		} else {
			return this.villageois[numVillageois];
		}
	}
	
	public void afficherVillage() {
		System.out.println("Le chef du village \"" + this.nom + "\" est le gaulois " + this.chef.getNom());
		for (int i = 0; i < this.nbVillageois; i++) {
			System.out.println("Le villageois numéro " + (i+1) + " du village est : " + trouverVillageois(i).getNom());
		} 
	}
	
	public boolean estVillageois(Gaulois gaulois) {
		boolean appartient = false;
		for (int i = 0; i < this.nbVillageois; i++) {
			if (trouverVillageois(i) == gaulois) {
				appartient = true;
			}
		}
		return appartient;
	}
	
}

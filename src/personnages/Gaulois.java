package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " frappe " + romain.getNom());
		romain.recevoirCoup(force * this.effetPotion / 3);
		if (this.effetPotion > 1) {
			this.effetPotion -= 1;
		}
	}
	
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}
	
	public void sePresenter(Village village) {
		if (village.getChef() == this) {
			parler("Bonjour je m'appelle " + this.nom + " Je suis le chef du village : " + village.getNom());
		} else {
			if (village.estVillageois(this) == true) {
				parler("Bonjour, je suis " + this.nom + " et je suis bien un habitant du village : " + village.getNom());
			} else {
				parler("Bonjour, je suis " + this.nom + " et je ne suis pas un habitant du village : " + village.getNom());
			}
		}
	}

}

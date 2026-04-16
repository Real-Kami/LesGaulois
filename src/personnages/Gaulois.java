package personnages;

import village_gaulois.Village;
import objets.Equipement;
import village_gaulois.Musee;

public class Gaulois {
	private String nom;
	// private int force;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

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

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	// code importé depuis le sujet
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + "]";
//	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " frappe " + romain.getNom());
//		romain.recevoirCoup(force * this.effetPotion / 3);
//		if (this.effetPotion > 1) {
//			this.effetPotion -= 1;
//		}
//	}

	// code importé depuis le sujet
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesLoc = romain.recevoirCoup((this.force / 2) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; tropheesLoc != null && i < tropheesLoc.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesLoc[i];
		}
	}

	// code importé depuis le sujet
	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public void sePresenter(Village village) {
		if (village.getChef() == this) {
			parler("Bonjour je m'appelle " + this.nom + " Je suis le chef du village : " + village.getNom());
		} else {
			if (village.estVillageois(this)) {
				parler("Bonjour, je suis " + this.nom + " et je suis bien un habitant du village : "
						+ village.getNom());
			} else {
				parler("Bonjour, je suis " + this.nom + " et je ne suis pas un habitant du village : "
						+ village.getNom());
			}
		}
	}

	public void faireUneDonnation(Musee musee) {
		parler("Je donne tous mes trophées au musée !");
		while (this.nbTrophees > 0) {
			musee.donnerTrophee(this, this.trophees[this.nbTrophees-1]);
			parler("Je donne " + this.trophees[this.nbTrophees-1] + " au musée.");
			this.nbTrophees -= 1;
		}
	}
	
}

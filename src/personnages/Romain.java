package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() == true;
		this.nbEquipement = 0;
		this.equipement = new Equipement[2];
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int forceAvant = this.force;
				
		this.force = this.force - forceCoup;
		if (this.force < 0) {
			this.parler("J'abandonne");
		} else {
			this.parler("Aïe !");
		}
		
		int forceApres = this.force;
		assert forceApres < forceAvant;
		assert isInvariantVerified() == true;
	}
	
	private boolean isInvariantVerified() {
		return this.force >= 0;
	}
	
	public void sEquiper(Equipement equipement) {
		// cas de figures : inventaire plein, possède déjà l'obj, equip ajouté.
		
		// AJOUTER LES OBJETS AU ROMAIN
		switch(this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 0:
			System.out.println("Le soldat " + this.nom + " s'équippe avec " + equipement.toString());
			break;
		case 1:
			boolean doublon = false;
			for (int i = 0; i < this.nbEquipement; i++) {
				if (equipement = this.equipement[i]) {
					doublon = true;
				}
			}
			switch(doublon) {
			case 0:
				System.out.println("sequippe avec l'item");
				break;
			case 1:
				System.out.println("sequippe avec l'item");
				break
			}
			break;
		}
	}
	
}

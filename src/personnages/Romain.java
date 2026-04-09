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
		switch (this.nbEquipement) {
		case 2:
			System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipement != this.equipement[0]) {
				System.out.println("Le soldat " + this.nom + " s'équippe avec " + equipement.toString());
				this.equipement[1] = equipement;
				this.nbEquipement += 1;
			} else {
				System.out.println("Le soldat " + this.nom + " possède déjà l'équipement " + equipement.toString());
			}
			break;
		case 0:
			System.out.println("Le soldat " + this.nom + " s'équippe avec " + equipement.toString());
			this.equipement[0] = equipement;
			this.nbEquipement += 1;
			break;
		}
	}

}

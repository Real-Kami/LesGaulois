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
		assert isInvariantVerified();
		this.nbEquipement = 0;
		this.equipement = new Equipement[2];
	}

	public int getForce() {
		return force;
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

//	public void recevoirCoup(int forceCoup) {
//		assert forceCoup > 0;
//		int forceAvant = this.force;
//
//		this.force = this.force - forceCoup;
//		if (this.force < 0) {
//			this.parler("J'abandonne");
//		} else {
//			this.parler("Aïe !");
//		}
//
//		int forceApres = this.force;
//		assert forceApres < forceAvant;
//		assert isInvariantVerified() == true;
//	}

// code importé depuis le sujet
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		if (forceCoup > 0) {
			this.force -= forceCoup;
			parler("Aïe");
			if (this.force < 1) {
				equipementEjecte = ejecterEquipement();
				parler("j'abandone...");
			}
			
		}
		return equipementEjecte;
	}

	// code importé depuis le sujet
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += " Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipement[i] != null && equipement[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 6;
				} else {
					// System.out.println("Equipement casque");
					resistanceEquipement += 3;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}

	// code importé depuis le sujet
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			equipementEjecte[nbEquipementEjecte] = equipement[i];
			nbEquipementEjecte++;
			equipement[i] = null;
		}
		return equipementEjecte;
	}

	private boolean isInvariantVerified() {
		return this.force >= 0;
	}

	public void sEquiper(Equipement equipement) {
		String identite = "Le soldat ";
		switch (this.nbEquipement) {
		case 2:
			System.out.println(identite + this.nom + " est déjà bien protégé !");
			break;
		case 1:
			if (equipement != this.equipement[0]) {
				System.out.println(identite + this.nom + " s'équippe avec " + equipement.toString());
				this.equipement[1] = equipement;
				this.nbEquipement += 1;
			} else {
				System.out.println(identite + this.nom + " possède déjà l'équipement " + equipement.toString());
			}
			break;
		case 0:
			System.out.println(identite + this.nom + " s'équippe avec " + equipement.toString());
			this.equipement[0] = equipement;
			this.nbEquipement += 1;
			break;
		default:
			System.out.println("Cas du switch dans romain.sEquiper non prévu");
			break;
		}
	}

}

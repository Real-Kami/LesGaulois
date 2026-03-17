package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() == true;
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

}

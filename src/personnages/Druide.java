package personnages;

public class Druide {
	private String nom;
	//private int force;
	
	public Druide(String nom, int force) {
		this.nom = nom;
		//this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois gaulois, Chaudron chaudron) {
		if (chaudron.resterPotion()) {
			String nomGaulois = gaulois.getNom();
			if (nomGaulois == "Obélix") {
				this.parler("Non " + nomGaulois + " Tu ne peux pas avoir de potion magique.");
			} else {
				int forcePotion = chaudron.prendreLouche();
				if (forcePotion > 0) {
					gaulois.boirePotion(forcePotion);
					this.parler("Tiens " + nomGaulois + " prends de la potion magique.");
				} else {
					this.parler("Désolé " + nomGaulois + " il n'y a plus de potion magique.");
				}
			}
		}		
	}
	
	public void fabriquerPotion(int quantite, int forcePotion, Chaudron chaudron) {
		chaudron.remplirChaudron(quantite, forcePotion);
		this.parler("J'ai concocté " + quantite + " doses de potion magique. Elle a une force de " + forcePotion + ".");
	}
	
}
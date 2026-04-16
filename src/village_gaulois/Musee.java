package village_gaulois;

import objets.Trophee;
import objets.Equipement;
import personnages.Gaulois;

public class Musee {

	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = trophee;
		nbTrophee += 1;
	}
	
	public String extraireVersOCaml() {
		String output = "let musee = [\n";
		for (int i = 0; i < this.nbTrophee; i++) {
			Trophee trophee_courant = this.trophees[i];
			output += " \"" + trophee_courant.getGaulois().getNom() + "\", \"" + trophee_courant.getEquipement() + "\"; \n";
		}
		output = output.substring(0, output.length() -3);
		output += " \n]";
		return output;
	}
}

package personnages;


import personnages.Trophee;
import personnages.Gaulois;
import personnages.*;

public class Musee {
	private Trophee[] tabTrophee = new Trophee[200];
	private int nbTrophees = 0;
	
	
	public void donnerTrophees(Gaulois gaulois, Equipement equip) {
		if (nbTrophees < 200) {
			tabTrophee[nbTrophees] = new Trophee(gaulois, equip);
			nbTrophees += 1;
		}
	
	}
	
	public String extraireInstructionsCaml( ) {
		String Ocaml = "let musee = [ ";
		for (int i = 0; i < nbTrophees + 1 ; i++) {
			Ocaml += "\n	" + " \" \" " + tabTrophee[i].getGaulois().getNom() + " \" \" "+  "," + tabTrophee[i].getEquipement().name(); 
		}
		return Ocaml + "\n ]";
		
	}
}


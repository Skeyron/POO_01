package histoire;

import personnages.Gaulois;
import personnages.Druide;
import personnages.Romains;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Astérix", 8);
		Romains minus = new Romains ("Minus", 20);
		Druide pano = new Druide ("Panoramix",5,10);
		Gaulois obelix = new Gaulois ("Obélix", 200);
		
		pano.parler("Je vais preparer une petite potion");
		pano.preparerPotion();
		pano.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste");
		pano.booster(asterix);
		asterix.parler("Bonjour");
		minus.parler("UN GAU ... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
		
		
	}

}

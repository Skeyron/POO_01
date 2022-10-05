package histoire;

import personnages.Gaulois;
import personnages.Romains;

public class Scénario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Astérix", 8);
		Romains minus = new Romains ("Minus", 6);
		asterix.parler("Bonjour à tous");
		minus.parler("UN GAUL... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}

package histoire;

import personnages.Gaulois;
import personnages.Romains;

public class Sc�nario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois ("Ast�rix", 8);
		Romains minus = new Romains ("Minus", 6);
		asterix.parler("Bonjour � tous");
		minus.parler("UN GAUL... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);
	}

}

package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement [100];
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {

		System.out.println(prendreParole() + "<<" + texte + ">>");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
		}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
//	public void frapper(Romains romain) {
//		System.out.println(nom + " envoie un grand coup dans la mï¿½choire de "
//				+ romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romains romain) {
		System.out.println(nom + " envoie un grand coup dans la mÃ¢choire de " + romain.getNom());
		Equipement[] trophees2 = romain.recevoirCoup((force / 3) * effetPotion);
//		System.out.println(trophees2.length);
		for (int i = 0; trophees2 != null && i < trophees2.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees2[i];
		}
	}
		
	
	public void faireUneDonation(Musee musee) {
		if (nbTrophees != 0) {
			String texte = " Je donne au musée tous mes trophées !";
			parler(texte);
			while (nbTrophees != 0) {
				musee.donnerTrophees( this , trophees[nbTrophees] );
				System.out.println(" -" + trophees[nbTrophees - 1].name());
				nbTrophees -= 1;
			}
		} else {
			String textes = " Je n'ai pas  de trophées ";
			parler(textes);
		}	
		
	}

	@Override
	public String toString() {
		return "Gaulois [nom = " + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int potion) {
		effetPotion = potion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois dÃ©cuplÃ©e");
	}
	
	public static void main(String[] args) {
		Gaulois ast = new Gaulois ("AstÃ©rix", 9);
		ast.boirePotion(3);
		
	}
	
}

package personnages;


public class Romains {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	private String texte;
	
	public Romains(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		assert (force>0) : "force négative";
	}
	
	public String getNom() {
		return nom;
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
		
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
			
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert (force>0) : "force négative";
//		int preForce = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			parler("J'abandonne");
//		}
//		assert (preForce>force) : "La force n'a pas diminué";
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert force > 0;
		int oldForce = force;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
//		if (force > 0) {
//			parler("Aïe");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//		}
		
		switch (force) {
		case 0:
			parler("Aïe");
		
		default:
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
			break;
		}
		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;

	}	
	
	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du
		coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
		texte += "\nMais heureusement, grace à mon équipement sa
		force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipements[i] != null &&
		equipements[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "
		s'envole sous la force du coup.");
		//TODO
		
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {if (equipements[i] == null) {
			continue;
		} else {
		equipementEjecte[nbEquipementEjecte] =
		equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
		}

	public void sEquiper(Equipement equip) {
		switch (nbEquipements) {
			case 0 :
				equipements[0] = equip;
				System.out.println("Le soldat " + nom + " s'équipe avec " + equip.name());
				nbEquipements += 1;
				break;
			case 1 :
				if(equipements[0] == equip) {
					System.out.println("Le soldat " + nom + " possède déjà un " + equip.name());
				} else {
					equipements[1] = equip;
					System.out.println("Le soldat " + nom + " s'équipe avec " + equip.name());
					nbEquipements += 1;
				}
				break;
			case 2 :
				System.out.println("Le soldat " + nom + " est déjà bien protégé ! ");
		}
	}
	
	@Override
	public String toString() {
		return "Romains [nom=" + nom + ", force=" + force + "]";
	}
	public static void main(String[] args) {
		Romains alex = new Romains("Minus", 6);
		System.out.println(alex);
		alex.prendreParole();
		alex.parler("Oh non !");
		alex.recevoirCoup(10);
		System.out.println(Equipement.BOUCLIER);
		System.out.println(Equipement.CASQUE);
		
		alex.sEquiper(Equipement.CASQUE);
		alex.sEquiper(Equipement.CASQUE);
		alex.sEquiper(Equipement.BOUCLIER);
		alex.sEquiper(Equipement.CASQUE);
	}
}

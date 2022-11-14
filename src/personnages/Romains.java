package personnages;


public class Romains {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipements = 0;
	
	
	public Romains(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		assert (force>0) : "force n�gative";
	}
	
	
	
	public int getForce() {
		return force;
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
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		
		if (force > 0) {
			parler("A�e");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}

		// post condition la force a diminuée
		assert force < oldForce;
		return equipementEjecte;

	}	
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipements != 0) {
			texte += "\n Mais heureusement, grace � mon �quipement sa force est diminue de ";
			for (int i = 0; i < nbEquipements; i++) {
				if ((equipements[i] != null &&
							equipements[i].equals(Equipement.BOUCLIER) )) {
							resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
		}
			
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if (forceCoup < 0) {
			forceCoup = 0;
		}
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipements];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipements; i++) {if (equipements[i] == null) {
			
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
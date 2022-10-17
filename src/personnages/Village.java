package personnages;

public class Village {
	private Chef chef;
	private String nom;
	private int nbVillageois = 0;
	private Gaulois villageois[];
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.villageois = new Gaulois [nbVillageoisMaximum];
	}
	
	
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int i) {
		return villageois[i];

	}
	
	public void afficherVillageois(Chef chef) {
		
		System.out.println("Dans le village du chef" + chef.getNom() +" vivent les légendaires Gaulois : \n");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());
			
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
		Chef chef = new Chef ("Abraracourcix", 6, 1, village);
		Gaulois asterix = new Gaulois ("Astéreix", 8);	
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois(chef);
		
	}	
}

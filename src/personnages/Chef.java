package personnages;

public class Chef {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village;
	
	public Chef(String nom, int force, int effetPotion, Village village) {
		this.nom = nom;
		this.force = force;
		this.effetPotion = effetPotion;
		this.village = village;
	}
	
	
	public String getNom() {
		return nom;
	}


	public String prendreParole() {
		return "le chef " + nom + " du village" + village.getNom() + " : ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
		
		
	}
	
	public void frapper(Romains romain) {
		System.out.println(nom + "envoie un grand coup dans la mâchoire de" + romain.getNom());
		romain.recevoirCoup(force/3);
	}
}

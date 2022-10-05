package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + "et ma potion magique peut aller d'une force"
				 + effetPotionMin + " à " + effetPotionMax);
		
	}
	
	public String getNom() {
		return nom;
	}
	
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
			
	}
	
	public String prendreParole() {
		return "Le druide " + nom + " : ";
	}
		
	
}

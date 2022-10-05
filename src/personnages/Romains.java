package personnages;

public class Romains {
	
	public Romains(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	private String nom;
	private int force;
	
	public String getNom() {
		return nom;
	}
	private String prendreParole() {
		return "Le romain " + nom + " : ";
		
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "<<" + texte + ">>");
			
	}
	
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne");
		}
	}
	
	
	@Override
	public String toString() {
		return "Romains [nom=" + nom + ", force=" + force + "]";
	}
	public static void main(String[] args) {
		Romains alex = new Romains("Alexendre", 3);
		System.out.println(alex);
		alex.prendreParole();
		alex.parler("Oh non !");
		alex.recevoirCoup(10);
		
	}
	
	
}

package classes;

public class Joueur {
	
	// attributes
	public int id;
	public String nom;
	public String prenom;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Joueur( String nom, String prenom) {
		 
		this.id = (int) (Math.random()*100);
		this.nom = nom;
		this.prenom = prenom;
	}
	public Joueur() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		 return "Joeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
 
	}
	
	
	

}

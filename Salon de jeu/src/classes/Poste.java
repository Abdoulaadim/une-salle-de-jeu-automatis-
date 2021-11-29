package classes;

public class Poste {

	
	private int numeroPost;
 
	private static int nbr_postReserver;
	private Materiels materiel;
	
	
	
	public Poste(int numeroPost, Materiels materiel) {
		super();
		this.numeroPost = numeroPost;
		setMateriel(materiel);
		this.nbr_postReserver ++;
	}
	
	public Poste( ) {
 
	}
	public int getNumeroPost() {
		return numeroPost;
	}
	@Override
	public String toString() {
		return "Poste [numeroPost=" + numeroPost + ", nbr_postReserver=" + nbr_postReserver + ", materiel=" + materiel
				+ "]";
	}
	public void setNumeroPost(int numeroPost) {
		this.numeroPost = numeroPost;
	}
 
	public int getNbr_postReserver() {
		return nbr_postReserver;
	}
	public void getNbr_postReserver(int nbr_postReserver) {
		this.nbr_postReserver = nbr_postReserver;
	}
	public Materiels getMateriel() {
		return materiel;
	}
	public void setMateriel(Materiels materiel) {
		if(materiel!=null)
		{
				this.materiel = materiel;
		}
	
	}
	
	
}

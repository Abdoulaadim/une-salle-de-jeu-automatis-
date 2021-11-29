package classes;

public class Materiels {
	
	private int id;
	private String intitulé;
	private int modele;
	private boolean occupe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitulé() {
		return intitulé;
	}
	public void setIntitulé(String intitulé) {
		this.intitulé = intitulé;
	}
	public int getModele() {
		return modele;
	}
	public void setModele(int modele) {
		this.modele = modele;
	}
	public Materiels(int id, String intitulé, int modele) {
		super();
		this.id = id;
		this.intitulé = intitulé;
		this.modele = modele;
	}
	public Materiels() {
	 
	}
	 
	@Override
	public String toString() {
		return "Materiels [id=" + id + ", intitulé=" + intitulé + ", modele=" + modele + ", occupe=" + occupe + "]";
	}
	public boolean isOccupe() {
		return occupe;
	}
	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}
	
	 

}

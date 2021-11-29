package classes;

public class Materiels {
	
	private int id;
	private String intitul�;
	private int modele;
	private boolean occupe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntitul�() {
		return intitul�;
	}
	public void setIntitul�(String intitul�) {
		this.intitul� = intitul�;
	}
	public int getModele() {
		return modele;
	}
	public void setModele(int modele) {
		this.modele = modele;
	}
	public Materiels(int id, String intitul�, int modele) {
		super();
		this.id = id;
		this.intitul� = intitul�;
		this.modele = modele;
	}
	public Materiels() {
	 
	}
	 
	@Override
	public String toString() {
		return "Materiels [id=" + id + ", intitul�=" + intitul� + ", modele=" + modele + ", occupe=" + occupe + "]";
	}
	public boolean isOccupe() {
		return occupe;
	}
	public void setOccupe(boolean occupe) {
		this.occupe = occupe;
	}
	
	 

}

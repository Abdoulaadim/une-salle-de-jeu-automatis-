package classes;

public class Jeu {
	
	private int id;
	private String type ;
	private String intitule;

	@Override
	public String toString() {
		return "Jeu [id=" + id + ", type=" + type + ", intitule=" + intitule + "]";
	}
	public Jeu(int id, String type, String intitule) {
		super();
		this.id = id;
		this.type = type;
		this.intitule = intitule;
	}
	public Jeu()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	

}

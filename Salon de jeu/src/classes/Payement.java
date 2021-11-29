package classes;

public class Payement {

	private int id;
	private Joueur Joueur;
	private float tarif;
	private Reservation reservation;

	public int getId() {
		return id;
	}

	public Payement(int id, Joueur Joueur, String tarif,Reservation reservation) {
		super();
		this.id = id;
		this.Joueur = Joueur;
		 setTarif(tarif);
		 setReservation(reservation);
	}
	 

	 

	@Override
	public String toString() {
		return "Payement [id=" + id + ", Joueur=" + Joueur + ", tarif=" + tarif + ", reservation=" + reservation + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public Joueur getJoueur() {
		return Joueur;
	}

	public void setJoueur(Joueur Joueur) {
		this.Joueur = Joueur;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(String offre) {
		float montant = 0;
		switch (offre) {
		case "30min":
			montant = 5;
			break;
		case "1h":
			montant = 10;
			break;
		case "2h":
			montant = 18;
			break;
		case "5h":
			montant = 40;
			break;
		case "Joueur de lux":
			montant = 65;
			break;

		}
		this.tarif = montant;

	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}

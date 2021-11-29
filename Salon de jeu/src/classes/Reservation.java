package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

 
 

public class Reservation {


	private Joueur joueur;
	private Poste poste;
	private Date date_debut;
	private String periode;
	private Jeu jeu_choisi;
	private boolean session_finish;
 

	
	
	public Reservation(Joueur joueur, Poste poste, Date date_debut,String periode, Jeu jeu_choisi) {
		super();
		this.joueur = joueur;
		this.poste = poste;
		this.date_debut = date_debut;
		this.periode =  periode;
		this.jeu_choisi = jeu_choisi;
		this.setSession_finish(seeIfSessionFinish());
	}
	public Reservation()
	{
		
	}
	public long setPeriodeAdequat(String periode)
	{
		float adequatPeride =0 ;
		switch (periode.toLowerCase()) {
		case "30min":
			adequatPeride = (float) 0.5;
			break;
		case "1h":
			adequatPeride = 1;
			break;
		case "2h":
			adequatPeride = 2;
			break;
		case "5h":
			adequatPeride = 5;
			break;
		case "joueur de lux":
			adequatPeride = 11;
			break;

		}
		return (long) adequatPeride;
		
	}
	 
	@Override
	public String toString() {
		return "Reservation [joueur=" + joueur + ", poste=" + poste + ", date_debut=" + date_debut + ", periode="
				+ periode + ", jeu_choisi=" + jeu_choisi + ", session_finish=" + session_finish + "]";
	}

	
	public boolean seeIfSessionFinish()
	{
		Date oldDate = this.getDate_debut();
		Date newDate = new Date(oldDate.getTime() + TimeUnit.HOURS.toMillis(setPeriodeAdequat(this.getPeriode()))); 
		
		long diff = newDate.getTime() - oldDate.getTime();
		long diffMinutes = diff / (60 * 1000);  
		 if(diffMinutes<0)
		 {
	 
			 this.joueur=null;
			 this.poste=null;
			 this.date_debut=null;
			 this.periode=null;
			 this.jeu_choisi=null;
			 return true;
		 }
		 else
			 return false;
 

	}

	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public Poste getPoste() {
		return poste;
	}
	public void setPoste(Poste poste) {
		this.poste = poste;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}
	public Jeu getJeu_choisi() {
		return jeu_choisi;
	}
	public void setJeu_choisi(Jeu jeu_choisi) {
		this.jeu_choisi = jeu_choisi;
	}
	public boolean isSession_finish() {
		return session_finish;
	}
	public void setSession_finish(boolean session_finish) {
		this.session_finish = session_finish;
	}
 
 
	
	
}

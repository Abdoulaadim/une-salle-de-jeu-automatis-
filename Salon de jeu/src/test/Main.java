package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import classes.Jeu;
import classes.Joueur;
import classes.Materiels;

import classes.Poste;
import classes.Reservation;

public class Main {

	public static List<Poste> ListePlace = new ArrayList<Poste>();
	public static List<Joueur> listJoeur = new ArrayList<Joueur>();
	public static List<Jeu> listeJeu = loadData_jeu();
	public static List<Joueur> listJoeur_attente = new ArrayList<Joueur>();
	public static List<Materiels> listeMateriel = loadData_Materiels();
	public static List<Reservation> listeReservation = new ArrayList<Reservation>();

	public static float somme = 0;

	public static List<Jeu> loadData_jeu() {
		Jeu jeu1 = new Jeu(1, "football", "FIFA2020");
		Jeu jeu2 = new Jeu(2, "football", "PES2021");
		Jeu jeu3 = new Jeu(3, "Guerre", "Assassin's_Creed");
		Jeu jeu4 = new Jeu(4, "Guerre", "Counter_strike");
		Jeu jeu5 = new Jeu(5, "Guerre", "God_of_war");

		List<Jeu> List_Jeu = new ArrayList<Jeu>();
		List_Jeu.add(jeu1);
		List_Jeu.add(jeu2);
		List_Jeu.add(jeu3);
		List_Jeu.add(jeu4);
		List_Jeu.add(jeu5);

		return List_Jeu;

	}

	public static float montantApayer(String offre) {
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
		case "joueur de lux":
			montant = 65;
			break;

		}
		return montant;

	}

	public static float CalculRevenu(String choix) {
		Date date = new Date();
		float somme = 0;
		if (choix == "day") {
			

			for (int i = 0; i < listeReservation.size(); i++) {

				if (listeReservation.get(i).getDate_debut().compareTo(date) <= 1) {
					System.out.println(listeReservation.get(i).getDate_debut().compareTo(date));

					somme += montantApayer(listeReservation.get(i).getPeriode());

				}
			}
		} else {

			Date newDate = null;
			newDate = new Date(date.getTime() + TimeUnit.DAYS.toMillis(30));
			for (int i = 0; i < listeReservation.size(); i++) {
				if (listeReservation.get(i).getDate_debut().compareTo(newDate) <= 1) {
					somme += montantApayer(listeReservation.get(i).getPeriode());
				}
			}

		}
		return somme;

	}

	public static List<Materiels> loadData_Materiels() {
		Materiels m1 = new Materiels(1, "Xbox", 2012);
		Materiels m2 = new Materiels(2, "Xbox", 2012);
		Materiels m3 = new Materiels(3, "Xbox", 2012);
		Materiels m4 = new Materiels(4, "PlayStation5", 2020);
		Materiels m5 = new Materiels(5, "PlayStation5", 2020);
		Materiels m6 = new Materiels(6, "Nintendo_Switch", 2015);
		Materiels m7 = new Materiels(7, "Nintendo_Switch", 2015);

		List<Materiels> list_Materiel = new ArrayList<Materiels>();
		list_Materiel.add(m1);
		list_Materiel.add(m2);
		list_Materiel.add(m3);
		list_Materiel.add(m4);
		list_Materiel.add(m5);
		list_Materiel.add(m6);
		list_Materiel.add(m7);
		return list_Materiel;

	}



	public static boolean checkDisponibility(String nomPoste) {
		Poste p = new Poste();
		int i;
		boolean ret = false;
		for (i = 0; i < listeMateriel.size(); i++) {
			if (listeMateriel.get(i).getIntitulé().toLowerCase().equals(nomPoste.toLowerCase())
					&& !listeMateriel.get(i).isOccupe() && i < listeMateriel.size()) {
				ret = true;

			}
		}

		return ret;

	}

	public static Jeu checherJeu(String nomJeu) {
		Jeu jeu = new Jeu();
		jeu = null;
		for (int i = 0; i < listeJeu.size(); i++) {
			if (listeJeu.get(i).getIntitule().toLowerCase().equals(nomJeu.toLowerCase())) {
				jeu = listeJeu.get(i);

			}
		}
		return jeu;

	}

	public static Poste checherPoste(String nomPoste) {
		Poste poste = new Poste();
		poste = null;
		for (int i = 0; i < listeMateriel.size(); i++) {

			if (listeMateriel.get(i).getIntitulé().toLowerCase().equals(nomPoste.toLowerCase())
					&& !listeMateriel.get(i).isOccupe()) {

				poste = new Poste(listeMateriel.get(i).getId(), listeMateriel.get(i));

			} else if (i > listeMateriel.size()) {
				System.out.println("Poste Inexistant");
			}
		}
		return poste;

	}

	public static boolean reserver(String nomPoste, Joueur joueur, String nomJeu, String periode) {
		Date dateDebut = new Date();
		boolean ret = false;
		if (checkDisponibility(nomPoste) && checherJeu(nomJeu) != null && checherPoste(nomPoste) != null) {

			if (listeReservation.size() < 7) {
				Reservation R1 = new Reservation(joueur, checherPoste(nomPoste), dateDebut, periode,
						checherJeu(nomJeu));
				R1.getPoste().getMateriel().setOccupe(true);
				listeReservation.add(R1);

				ListePlace.add(checherPoste(nomPoste));
				listJoeur.add(joueur);
				ret = true;
			} else if (listJoeur_attente.size() < 10) {
				listJoeur_attente.add(joueur);
				ret = true;
			}

		}
		return ret;

	}

	public static void posteDisponible() {

		for (int i = 0; i < listeMateriel.size(); i++) {

			if (!listeMateriel.get(i).isOccupe()) {

				System.out.println("Numero poste : " + listeMateriel.get(i).getId());
				System.out.println("Nom poste : " + listeMateriel.get(i).getIntitulé());

			}
		}

	}

	public static void tousLesJeux() {
//Character ch = Character.MIN_VALUE;
		for (int i = 0; i < listeJeu.size(); i++) {

			if (i == 0) {
				System.out.println("|-----------------------------|");
			} else {

				System.out.println("|Nom Jeu : " + listeJeu.get(i).getIntitule() + "|");
				System.out.println("|Categorie : " + listeJeu.get(i).getType() + "|");

				System.out.println("|-----------------------------|");
			}

		}

	}

	public static boolean verificationheure() {
		boolean ret = false;

		Calendar calendar = GregorianCalendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
 
		if ((hour >= 9 && hour < 12) || (hour >= 0 && hour < 20)) {
			ret = true;
		}

		return ret;
	}

	public static void positionListe(Joueur joeur) {
		int position = 0;
		if (listeReservation.size() < 7) {
			System.out.println("Vous etes dans la liste principale");
		} else if (joeur != null) {
			for (int i = 0; i < listJoeur_attente.size(); i++) {
				 
				if (listJoeur_attente.contains(joeur)) {
					position = i + 1;
					i = listJoeur.size() + 2;
				}
			}
			if (position != 0 && listeReservation.size() > 7) {
				System.out.println("Votre position dans la liste d'attente est " + position);
			} else if (listeReservation.size() > 7) {
				System.out.println("Vous n'etes pas dans la liste d'attente ");
			}
		}

	}

	public static void menu() {
		System.out.println(" ------------Menu------------ ");
		System.out.println("1)-S'inscrire");
		System.out.println("2)-Voir les postes disponibles ");
		System.out.println("3)-Verifier les jeux disponibles");
		System.out.println("4)-Reserver");
		System.out.println("5)-Afficher les revenues du jour");
		System.out.println("6)-Afficher les revenues du mois");
		System.out.println("7)-Position dans la liste d'attente");
		System.out.println("0)-Quitter");
		int choix = 0;
		Scanner sc = new Scanner(System.in);
		choix = sc.nextInt();
		Joueur joueur = null;

		do {
			switch (choix) {
			case 1:
				System.out.println("Entrer votre nom :");

				String nom = sc.next();
				System.out.println("Entrer votre prénom :");

				String prenom = sc.next();
				joueur = new Joueur(nom, prenom);
				break;
			case 2:
				System.out.println("Les postes Disponibles :");
				posteDisponible();
				break;
			case 3:
				System.out.println("Tous les jeux disponibles");
				tousLesJeux();
				break;

			case 4:

				if (verificationheure()) {
					String periode = "";
					System.out.println("Nom du poste dont vous voulez faire une reservation ");
					String nomPoste = sc.next();
					if (checherPoste(nomPoste) == null) {
						System.out.println("Poste Occupé ou Inexistant");
					} else {
						System.out.println("Entrer le nom du jeu ");
						String nomJeu = sc.next();
						if (checherJeu(nomJeu) == null) {
							System.out.println("Jeu inexistant ");
						} else {
							boolean checked = true;

							while (checked) {
								System.out.println("Entrer la priode souhaiter");
								periode = sc.nextLine();
								if (periode.equals("2h") || periode.equals("5h") || periode.equals("30min")
										|| periode.equals("1h") || (periode.trim()).equals("joueur de lux")) {

									checked = false;
									break;
								} else {
									System.out.println(
											"les periodes disponibles sont : 30min \n 1h \n 2h \n 5h \n joueur de lux");

									checked = true;
								}
							}
							if (!checked) {
								if (joueur != null) {
									boolean verifieReservation = reserver(nomPoste, joueur, nomJeu, periode);
									if (verifieReservation) {
										System.out.println("Bienvenue et passez une bonne journée");
									} else {
										System.out.println(
												"Echec de reservation reverifié les etapes encore une fois ! :)");
									}

								} else {
									System.out.println("Vous devrier vous s'inscrire au debut");
								}
							}

						}
					}
				} else {
					System.out.println("Les heures de reservation sont comprises entre 9h et 12h - 14h et 20h");
				}
				break;
			case 5:
				System.out.println("5)-Les revenues du jour sont :");
				System.out.println(CalculRevenu("day") + " Dh");
				break;
			case 6:
				System.out.println("6)-Les revenues du mois sont :");
				System.out.println(CalculRevenu("month") + " Dh");
				break;
			case 7:
				positionListe(joueur);
				break;
			default:System.out.println("choix une existant ");
			break;

			}
			System.out.println("Entrer votre choix ");
			choix = sc.nextInt();

		} while (choix != 0);
		System.out.println("Goodbye");

	}

	public static void main(String[] args) {

		/*
		Joueur joueur = new Joueur("Hamdaoui", "Rachid");
		Joueur j2 = new Joueur("Farid", "remdan");
		reserver("Nintendo_Switch", joueur, "Assassin's_Creed", "2h");
		reserver("xbox", j2, "Assassin's Creed", "2h");
		Reservation R2 = new Reservation(joueur, checherPoste("Playstation5"), new Date(), "5h",
				checherJeu("fifa2020"));
		listeReservation.add(R2);
		Reservation R3 = new Reservation(joueur, checherPoste("Playstation5"), new Date(), "joueur de lux",
				checherJeu("fifa2020"));
		listeReservation.add(R3);
		listeReservation.add(R3);
		listeReservation.add(R3);
		listeReservation.add(R3);
		listeReservation.add(R3);
		listeReservation.add(R3);
		listJoeur_attente.add(joueur);
 		System.out.println(CalculRevenu("day"));
		System.out.println(listeReservation.size());
		*/
		   menu();
	

	}

}

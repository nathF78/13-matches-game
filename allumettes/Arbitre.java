package allumettes;

public class Arbitre {

	private Joueur joueur1;
	private Joueur joueur2;
	private Boolean confiant;

	public Arbitre(Joueur joueur1, Joueur joueur2) {
		assert (joueur1 != null && joueur2 != null);
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	public void arbitrer(Jeu jeu) {
		assert (jeu != null && jeu.getNombreAllumettes() > 0);

		boolean finPartie = false;
		boolean tourJ1 = true;
		boolean nextRound = false;
		boolean triche = false;
		int nbPrises = 0;

		Joueur joueur = null;

		if (!this.confiant) {
			jeu = new ProxyJeu(jeu);
		}

		while (!finPartie) {

			nextRound = false;

			if (tourJ1) {
				joueur = this.joueur1;
			} else {
				joueur = this.joueur2;
			}
			if (!triche) {

				System.out.println("Allumettes restantes : " + jeu.getNombreAllumettes());
			}

			while (!nextRound) {
				try {

					if (joueur.getStrategie() instanceof Humain) {
						System.out.print(joueur.getNom() + ", combien d'allumettes ? ");
					}
					try {
						nbPrises = joueur.getPrise(jeu);
					} catch (CoupTricheurException e) {
						jeu.retirer(1);
						System.out.println(
								"[Une allumette en moins, plus que "
						+ jeu.getNombreAllumettes() + " . Chut !]");
						triche = true;
						break;
					}

					if (nbPrises > 1) {
						System.out.println(
								joueur.getNom() + " prend " + nbPrises + " allumettes.");
					} else {
						System.out.println(joueur.getNom()
								+ " prend " + nbPrises + " allumette.");
					}

					if (jeu instanceof ProxyJeu) {
						((ProxyJeu) jeu).getJeu().retirer(nbPrises);
					} else {
						jeu.retirer(nbPrises);
					}

					System.out.println("");
					nextRound = true;
					triche = false;
					tourJ1 = !tourJ1;

				} catch (NumberFormatException | IllegalStateException e) {
					System.out.println("Vous devez donner un entier.\n");
				} catch (OperationInterditeException e) {
					System.out.println(
							"Abandon de la partie car " + joueur.getNom() + " triche !");
					finPartie = true;
					triche = true;
					break;
				} catch (CoupInvalideException e) {
					System.out.println(
							"Impossible ! Nombre invalide : " + e.getCoup()
							+ " (" + e.getProbleme() + ")\n");
					System.out.println("Allumettes restantes : "
							+ jeu.getNombreAllumettes());
				}

			}

			if (jeu.getNombreAllumettes() <= 0) {
				finPartie = true;
			}

		}

		if (!triche) {
			if (joueur == joueur1) {
				afficherresultats(joueur2, joueur1);
			} else {
				afficherresultats(joueur1, joueur2);
			}
		}
	}

	private void afficherresultats(Joueur gagnant, Joueur perdant) {
		System.out.println(perdant.getNom() + " perd !");
		System.out.println(gagnant.getNom() + " gagne !");
	}

	public void setConfiant(Boolean confiant) {
		this.confiant = confiant;
	}
}

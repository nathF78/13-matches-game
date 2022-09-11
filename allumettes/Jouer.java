package allumettes;

/**
 * Lance une partie des 13 allumettes en fonction des arguments fournis sur la
 * ligne de commande.
 * @author Xavier Crégut
 * @version $Revision: 1.5 $
 */
public class Jouer {

	private static final int NB_ALLUMETTES_INITIALES = 13;

	/**
	 * Lancer une partie. En argument sont donnés les deux joueurs sous la forme
	 * nom@stratégie.
	 * @param args la description des deux joueurs
	 */
	public static void main(String[] args) {
		try {
			verifierNombreArguments(args);

		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
			System.exit(1);
		}

		int indexArgs;
		Jeu jeu = new JeuReel(NB_ALLUMETTES_INITIALES);
		Boolean confiant;

		if (args[0].equals("-confiant")) {
			confiant = true;
			indexArgs = 1;
		} else {
			indexArgs = 0;
			confiant = false;
		}

		try {
			// Joueur 1
			Joueur joueur1 = initPlayer(args[indexArgs]);
			// Joueur 2
			Joueur joueur2 = initPlayer(args[indexArgs + 1]);

			Arbitre arbitre = new Arbitre(joueur1, joueur2);
			arbitre.setConfiant(confiant);
			arbitre.arbitrer(jeu);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();
		} catch (ConfigurationException e) {
			System.out.println();
			System.out.println("Erreur : " + e.getMessage());
			afficherUsage();

		}

	}

	private static Joueur initPlayer(String argument) throws
			ConfigurationException, ArrayIndexOutOfBoundsException {
		String[] split = argument.split("@", 2);
		String nom = split[0];
		String strat = split[1];
		Strategie strategie;

		if (strat.equals("naif")) {
			strategie = new Naif();
		}
		if (strat.equals("rapide")) {
			strategie = new Rapide();
		} else if (strat.equals("humain")) {
			strategie = new Humain();
		} else if (strat.equals("expert")) {
			strategie = new Expert();
		} else if (strat.equals("tricheur")) {
			strategie = new Tricheur();
		} else {
			throw new ConfigurationException(
					"La stratégie " + split[1] + " n'est pas reconnue");
		}
		return (new Joueur(nom, strategie));
	}

	private static void verifierNombreArguments(String[] args) {
		final int nbJoueurs = 2;
		if (args.length < nbJoueurs) {
			throw new ConfigurationException("Trop peu d'arguments : " + args.length);
		}
		if (args.length > nbJoueurs + 1) {
			throw new ConfigurationException("Trop d'arguments : " + args.length);
		}
	}

	/** Afficher des indications sur la manière d'exécuter cette classe. */
	public static void afficherUsage() {
		System.out.println("\n" + "Usage :" + "\n\t"
				+ "java allumettes.Jouer joueur1 joueur2" + "\n\t\t"
				+ "joueur est de la forme nom@stratégie" + "\n\t\t"
				+ "strategie = naif | rapide | expert | humain | tricheur"
				+ "\n" + "\n\t" + "Exemple :" + "\n\t"
				+ "	java allumettes.Jouer Xavier@humain " + "Ordinateur@naif" + "\n");
	}

}

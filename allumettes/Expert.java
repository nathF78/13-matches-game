package allumettes;

public class Expert implements Strategie {
	private static final int BORNE_MAX = 10;
	private static final int BORNE_MIN = 5;

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {

		int allumettesRestantes = jeu.getNombreAllumettes();
		assert (allumettesRestantes > 0);

		if (allumettesRestantes > BORNE_MAX) {
			return Math.min(BORNE_MAX - 1, Jeu.PRISE_MAX);
		} else if (allumettesRestantes <= BORNE_MAX
				&& allumettesRestantes >= BORNE_MIN) { // l'ordi à perdu
			return 1;
		} else if (allumettesRestantes == 1) { // l'ordi à perdu
			return 1;
		} else {
			return (allumettesRestantes - 1);
		}
	}

	@Override
	public String toString() {
		return "expert";
	}

}

package allumettes;

public class Rapide implements Strategie {

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu.getNombreAllumettes() > 0);
		return Math.min(Jeu.PRISE_MAX,
				jeu.getNombreAllumettes()); //max d'allumettes possibles
	}

	@Override
	public String toString() {
		return "rapide";
	}
}

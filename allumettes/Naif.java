package allumettes;

import java.util.Random;

public class Naif implements Strategie {

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu.getNombreAllumettes() > 0);
		int maxPossible = Math.min(Jeu.PRISE_MAX, jeu.getNombreAllumettes());
		Random random = new Random();
		return random.nextInt(maxPossible);
	}

	@Override
	public String toString() {
		return "naif";
	}

}

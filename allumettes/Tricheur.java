package allumettes;

public class Tricheur implements Strategie {

	@Override
	public int getPrise(Jeu jeu) throws CoupInvalideException {
		int allumettesRestantes = jeu.getNombreAllumettes();
		assert (allumettesRestantes > 0);
		System.out.println("[Je triche...]");
		while (jeu.getNombreAllumettes() != 2) {
			jeu.retirer(1);
		}
		System.out.println("[Allumettes restantes : 2]");
		return 1;
	}

	@Override
	public String toString() {
		return "tricheur";
	}
}

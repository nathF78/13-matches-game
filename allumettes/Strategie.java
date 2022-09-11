package allumettes;

public interface Strategie {

	/**
	 * Demander nb d'allumettes à prendre
	 * @param jeu
	 * @return nombre d'allumettes
	 */
	int getPrise(Jeu jeu) throws CoupInvalideException;

	String toString();

}

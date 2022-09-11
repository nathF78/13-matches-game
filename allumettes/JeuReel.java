package allumettes;

public class JeuReel implements Jeu {

	private int nbAllumettes;

	public JeuReel(int nbAllumettes) {
		this.nbAllumettes = nbAllumettes;
	}

	@Override
	public int getNombreAllumettes() {
		return this.nbAllumettes;
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {

		if (nbPrises > this.nbAllumettes) {
			throw new CoupInvalideException(nbPrises, "> " + this.nbAllumettes);
		}
		if (nbPrises > PRISE_MAX) {
			throw new CoupInvalideException(nbPrises, "> " + PRISE_MAX);
		}
		if (nbPrises < 1) {
			throw new CoupInvalideException(nbPrises, "< " + 1);
		}
		this.nbAllumettes = this.nbAllumettes - nbPrises;
	}

	// Dans le cas d'une triche
	public void setnbAllumettes(int nb) {
		this.nbAllumettes = nb;
	}

}

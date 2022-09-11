package allumettes;

public class ProxyJeu implements Jeu {

	private Jeu jeu;

	/* Proxy qui gère le jeu */

	public ProxyJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	@Override
	public int getNombreAllumettes() {
		return this.jeu.getNombreAllumettes();
	}

	@Override
	public void retirer(int nbPrises) throws CoupInvalideException {
		throw new OperationInterditeException();
	}

	protected Jeu getJeu() {
		return this.jeu;
	}

}

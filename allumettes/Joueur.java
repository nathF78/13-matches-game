package allumettes;

public class Joueur {

	private String name;
	private Strategie strat;

	public Joueur(String playerName, Strategie playerStrategie) {
		this.name = playerName;
		this.strat = playerStrategie;
	}

	public String getNom() {
		return this.name;
	}

	public Strategie getStrategie() {
		return this.strat;
	}

	public int getPrise(Jeu jeu) throws CoupInvalideException {
		assert (jeu != null);
		return this.strat.getPrise(jeu);
	}

	public void setStrategie(Strategie strategie) {
		this.strat = strategie;
	}

	public String toString() {
		return this.name + " - " + this.strat.toString();
	}
}

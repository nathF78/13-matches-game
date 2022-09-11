package allumettes;
import org.junit.*;

/**
  * Classe de test de la stratégie Rapide.
  */
public class RapideTest {

	Strategie rapide = new Rapide();
	
	
	@Test public void tester1erprise() {
		Jeu jeu = new JeuReel(13);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 10);
	}

	@Test public void tester2emerprise() {
		Jeu jeu = new JeuReel(10);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jeu.getNombreAllumettes());
		assert(jeu.getNombreAllumettes() == 7);
	}
	@Test public void tester3emeprise() {
		Jeu jeu = new JeuReel(7);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 4);
	}
	@Test public void tester4emeprise() {
		Jeu jeu = new JeuReel(4);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 1);
	}
	
	@Test public void tester5emeprise() {
		Jeu jeu = new JeuReel(1);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 0);
	}
	
	@Test public void tester6emeprise() {
		Jeu jeu = new JeuReel(3);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 0);
	}

	@Test public void tester7emeprise() {
		Jeu jeu = new JeuReel(2);
		try {
		jeu.retirer(rapide.getPrise(jeu));
		} catch (CoupInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert(jeu.getNombreAllumettes() == 0);
	}
}

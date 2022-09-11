package allumettes;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Humain implements Strategie {

	private static Scanner scan = new Scanner(System.in);

	@Override
	public int getPrise(Jeu jeu)
			throws InputMismatchException, NumberFormatException,
			IllegalStateException, CoupInvalideException {

		String priseStr = scan.next();
		if (priseStr.equals("triche")) {
			throw new CoupTricheurException();
		}

		int prise = Integer.parseInt(priseStr);
		return prise;
	}

	@Override
	public String toString() {
		return "humain";
	}

}

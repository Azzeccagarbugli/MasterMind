package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Estensione di <code>CodeBreaker</code> mirata ad una gestione del
 * comportamento del giocatore in maniera casuale.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotBreaker extends CodeBreaker {

	private Set<List<ColorPegs>> combinationAttempts;

	private int seqLength;

	public RandomBotBreaker(int seqLength) {
		this.seqLength = seqLength;
		combinationAttempts = new HashSet<>();
	}

	/**
	 * Potrebbe capitare che la generazione casuale delle sequenze porti ad una
	 * sequenza di <code>ColorPegs</code> già inserita precedentemente. In tal caso
	 * verrà ripetuta l'azione di definizione di una nuova sequenza.
	 */
	@Override
	public List<ColorPegs> getAttempt() {
		List<ColorPegs> listAttempt;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			new Random().ints(seqLength, 0, ColorPegs.values().length).mapToObj(index -> ColorPegs.values()[index])
					.forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		combinationAttempts.add(listAttempt);
		return listAttempt;
	}

}

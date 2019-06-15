package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Estensione di <code>CodeBreaker</code> mirata ad una gestione del
 * comportamento del giocatore parzialmente random.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotBreaker extends CodeBreaker {

	/**
	 * Un <code>Set</code> in cui si andrà a fare lo storage dei tentativi
	 * effettuati per fare in modo che non vengano ripetuti.
	 */
	private Set<List<ColorPegs>> combinationAttempts;

	public RandomBotBreaker() {
		combinationAttempts = new HashSet<>();
	}

	@Override
	public List<ColorPegs> getAttempt(InteractionView intView) {
		List<ColorPegs> listAttempt;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			new Random().ints(intView.getCurrentSequenceLength(), 0, ColorPegs.values().length)
					.mapToObj(index -> ColorPegs.values()[index]).forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		combinationAttempts.add(listAttempt);
		return listAttempt;
	}

}

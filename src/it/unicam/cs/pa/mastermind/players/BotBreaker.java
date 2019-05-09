package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * La classe di seguito permette la creazione di un player avente sembianze da
 * Bot. Ciò implica che le sue scelte e azioni siano semplicemente dettate da
 * meri e puri algoritmi che andranno ad influenzare l'esito della partita.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BotBreaker implements CodeBreaker {

	/**
	 * Variabile booleana in cui setto la potenziale resa del player.
	 */
	private boolean giveUp;

	/**
	 * Un <code>Set</code> in cui si andrà a fare lo storage dei tentativi
	 * effettuati.
	 */
	private Set<List<ColorPegs>> combinationAttempts;

	/**
	 * Costruisco un BotBreaker e lo rendo disponibile per una partita qualsisi.
	 */
	public BotBreaker() {
		giveUp = false;
		combinationAttempts = new HashSet<>();
	}

	@Override
	public boolean isGiveUp() {
		return giveUp;
	}

	@Override
	public void setGiveUp(boolean giveUp) {
		this.giveUp = giveUp;
	}

	@Override
	public List<ColorPegs> getAttempt(int sequenceLength) {
		List<ColorPegs> listAttempt;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			new Random().ints(sequenceLength, 1, ColorPegs.values().length).mapToObj(index -> ColorPegs.values()[index])
					.forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		combinationAttempts.add(listAttempt);
		return listAttempt;
	}

}

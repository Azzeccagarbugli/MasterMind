package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unicam.cs.pa.mastermind.exceptions.BreakerGiveUpException;
import it.unicam.cs.pa.mastermind.gui.InteractionManager;
import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * La classe qui definita permette al giocatore umano di andare a creare una
 * sequenza da decodificare.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveBreaker implements CodeBreaker {

	/**
	 * Instanza di <code>InteractionManager</code> per definire un manager locale.
	 */
	private InteractionManager manager;

	/**
	 * Un <code>Set</code> in cui si andrà a fare lo storage dei tentativi
	 * effettuati.
	 */
	private Set<List<ColorPegs>> combinationAttempts;

	/**
	 * Costruisco lo HumanBreaker utilizzando l'<code>InteractionManager</code> per
	 * gestire le varie interazioni.
	 * 
	 * @param intManager un <code>InteractionManager</code> per definire le sue
	 *                   interazioni
	 */
	public InteractiveBreaker(InteractionManager intManager) {
		this.manager = intManager;
		combinationAttempts = new HashSet<>();
	}

	/*
	 * @Override public void askGiveUp() throws BreakerGiveUpException {
	 * if(this.manager.askGiveUp()) { throw new BreakerGiveUpException(); } }
	 */

	@Override
	public List<ColorPegs> getAttempt(int sequenceLength) throws BreakerGiveUpException {
		List<ColorPegs> listAttempt;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			manager.getIndexSequence(sequenceLength, true).stream().map(index -> ColorPegs.values()[index])
					.forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		return listAttempt;
	}

}

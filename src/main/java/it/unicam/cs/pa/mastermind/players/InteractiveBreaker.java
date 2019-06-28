package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Estensione di <code>CodeBreaker</code> mirata ad una gestione del
 * comportamento del giocatore tramite interazioni con l'utente umano.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveBreaker extends CodeBreaker {

	/**
	 * Un <code>Set</code> in cui si andrà a fare lo storage dei tentativi
	 * effettuati per fare in modo che non vengano ripetuti.
	 */
	private Set<List<ColorPegs>> combinationAttempts;
	
	private GameView view;

	public InteractiveBreaker(GameView newView) {
		combinationAttempts = new HashSet<>();
		view = newView;
	}

	@Override
	public List<ColorPegs> getAttempt() {
		List<ColorPegs> listAttempt;
		List<Integer> listIndex;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			listIndex = this.view.getIndexSequence(true);
			if (listIndex.contains(0)) {
				this.toggleGiveUp();
				break;
			}
			listIndex.stream().map(index -> ColorPegs.values()[index - 1]).forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		return listAttempt;
	}

}

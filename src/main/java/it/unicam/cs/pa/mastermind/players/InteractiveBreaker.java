package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Particolare estensione di <code>CodeBreaker</code>, rappresentante un utente
 * fisico. Nello specifico l'utente umano può effettuare decisioni ed impartire
 * comandi passando da un'istanza di <code>GameView</code>.
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

	/**
	 * La vista con la quale avere l'interazione con l'utente fisico.
	 */
	private GameView view;

	private int seqLength;
	
	public InteractiveBreaker(GameView newView, int seqLength) {
		combinationAttempts = new HashSet<>();
		view = newView;
		this.seqLength = seqLength;
	}

	/**
	 * L'utente fisico può decidere di voler reinserire una sequenza di
	 * <code>ColorPegs</code> già inserita precedentemente. In tal caso ripeterà
	 * l'azione di definizione di una nuova sequenza. <b>Contratto</b>: se dalla
	 * vista <code>GameView</code> viene restuito il valore 0 allora tale valore
	 * viene interpretato come la volontà dell'utente fisico di arrendersi.
	 */
	@Override
	public List<ColorPegs> getAttempt() {
		List<ColorPegs> listAttempt;
		List<Integer> listIndex;
		do {
			listAttempt = new ArrayList<ColorPegs>();
			listIndex = this.view.getIndexSequence(seqLength, true);
			if (listIndex.contains(0)) {
				this.toggleGiveUp();
				break;
			}
			listIndex.stream().map(index -> ColorPegs.values()[index - 1]).forEach(listAttempt::add);
		} while (combinationAttempts.contains(listAttempt));
		return listAttempt;
	}

}

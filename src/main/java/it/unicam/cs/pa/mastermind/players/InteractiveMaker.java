package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Estensione di <code>CodeMaker</code> mirata ad una gestione del comportamento del giocatore tramite interazioni con l'utente umano.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMaker extends CodeMaker {

	private InteractionView view;
	
	public InteractiveMaker(InteractionView newView) {
		view = newView;
	}
	
	@Override
	public List<ColorPegs> getCodeToGuess() {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		this.view.getIndexSequence(false).stream().map(index -> ColorPegs.values()[index - 1])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}

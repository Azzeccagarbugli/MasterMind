package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.GameView;

/**
 * Particolare estensione di <code>CodeMaker</code>, rappresentante un giocatore
 * umano. Nello specifico l'utente umano può effettuare decisioni ed impartire
 * comandi passando da un'istanza di <code>GameView</code>.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class InteractiveMaker extends CodeMaker {

	/**
	 * La vista con la quale avere l'interazione con l'utente fisico.
	 */
	private GameView view;

	private int seqLength;
	
	public InteractiveMaker(GameView newView, int seqLength) {
		view = newView;
		this.seqLength = seqLength;
	}

	@Override
	public List<ColorPegs> getCodeToGuess() {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		this.view.getIndexSequence(seqLength, false).stream().map(index -> ColorPegs.values()[index - 1])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}

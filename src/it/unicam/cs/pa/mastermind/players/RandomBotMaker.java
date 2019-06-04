package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Estensione di <code>CodeMaker</code> mirata ad una gestione del comportamento del giocatore totalmente random.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotMaker extends CodeMaker {

	@Override
	public List<ColorPegs> getCodeToGuess(InteractionView intView) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		new Random().ints(intView.getCurrentSequenceLength(), 0, ColorPegs.values().length).mapToObj(index -> ColorPegs.values()[index])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}

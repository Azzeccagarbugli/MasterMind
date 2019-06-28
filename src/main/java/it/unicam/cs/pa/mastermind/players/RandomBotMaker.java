package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Estensione di <code>CodeMaker</code> mirata ad una gestione del comportamento
 * del giocatore totalmente random.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class RandomBotMaker extends CodeMaker {

	private int seqLength;

	public RandomBotMaker(int seqLength, int attempts) {
		this.seqLength = seqLength;
	}

	@Override
	public List<ColorPegs> getCodeToGuess() {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		new Random().ints(this.seqLength, 0, ColorPegs.values().length).mapToObj(index -> ColorPegs.values()[index])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}

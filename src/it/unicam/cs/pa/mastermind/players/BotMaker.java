package it.unicam.cs.pa.mastermind.players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.unicam.cs.pa.mastermind.pegs.ColorPegs;

/**
 * La seguente classe definisce lo standard per cui un Bot possa essere colui
 * che effettua la scelta della sequenza da indovinare. Questa sequenza poi
 * potrà essere decoficata da altri Bot aventi la sua stessa natura o da player
 * di natura Human.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public class BotMaker implements CodeMaker {

	@Override
	public List<ColorPegs> getCodeToGuess(int sequenceLength) {
		List<ColorPegs> listToGuess = new ArrayList<ColorPegs>();
		new Random().ints(sequenceLength, 1, ColorPegs.values().length).mapToObj(index -> ColorPegs.values()[index])
				.forEach(listToGuess::add);
		return listToGuess;
	}

}

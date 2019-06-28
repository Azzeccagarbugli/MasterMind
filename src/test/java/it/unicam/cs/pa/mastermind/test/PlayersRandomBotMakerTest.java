package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Test di controllo utili alla generazione di un player codficatore di natura
 * bot.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersRandomBotMakerTest {
	
	private List<ColorPegs> listToGuess;

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.RandomBotMaker#getCodeToGuess(int, it.unicam.cs.pa.mastermind.ui.InteractionManager)}.
	 */
	@Test
	void testGetCodeToGuess() {
		BoardModel boardTemp = new BoardModel(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		listToGuess = new ArrayList<ColorPegs>();
		boardController.insertCodeToGuess(listToGuess);
		assertEquals(listToGuess, boardTemp.getSequenceToGuess());
	}
}

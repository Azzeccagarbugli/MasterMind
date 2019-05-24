package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.Board;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;

/**
 * Test di controllo utili alla generazione di un player codficatore di natura
 * bot.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersRandomBotMakerTest {

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.RandomBotMaker#getCodeToGuess(int, it.unicam.cs.pa.mastermind.ui.InteractionManager)}.
	 */
	@Test
	void testGetCodeToGuess() {
		RandomBotMaker newBotMaker = new RandomBotMaker();
		Board boardTemp = new Board(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		List<ColorPegs> listToGuess = newBotMaker.getCodeToGuess(boardTemp.getSequenceLength(), null);
		boardController.insertCodeToGuess(listToGuess);
		assertEquals(listToGuess, boardTemp.getSequenceToGuess());
	}
}

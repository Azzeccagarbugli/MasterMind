package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.players.RandomBotBreaker;
import it.unicam.cs.pa.mastermind.players.RandomBotMaker;

/**
 * Test di controllo utili alla generazione di un player decodficatore di natura
 * bot.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersRandomBotBreakerTest {

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.RandomBotBreaker#getAttempt(int, it.unicam.cs.pa.mastermind.ui.InteractionManager)}.
	 */
	@Test
	void testGetAttempt() {
		RandomBotBreaker newBotBreaker = new RandomBotBreaker();
		RandomBotMaker newBotMaker = new RandomBotMaker();
		BoardModel boardTemp = new BoardModel(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		boardController.insertCodeToGuess(newBotMaker.getCodeToGuess(boardTemp.getSequenceLength(), null));
		assertTrue(boardController.insertNewAttempt(newBotBreaker.getAttempt(boardTemp.getSequenceLength(), null)));
		boardController.insertCodeToGuess(newBotMaker.getCodeToGuess(boardTemp.getSequenceLength(), null));
		assertEquals(9 - boardTemp.leftAttempts(), boardTemp.attemptsInserted());
	}
}

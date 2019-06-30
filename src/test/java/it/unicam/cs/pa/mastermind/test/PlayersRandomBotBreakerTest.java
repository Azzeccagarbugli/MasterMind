package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;

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
		BoardModel boardTemp = new BoardModel(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		boardController
				.insertCodeToGuess(Arrays.asList(ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.GREEN));
		boardController.insertNewAttempt(Arrays.asList(ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.BLUE));
		assertEquals(9 - boardTemp.leftAttempts(), boardTemp.attemptsInserted());
	}
}

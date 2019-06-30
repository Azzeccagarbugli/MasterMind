package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofMillis;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Il seguente test simula il corretto funzionamento di una singola partita.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class SimulationGame {

	private int sequenceLenght = 4;
	private int maxAttempts = 9;

	private BoardModel board;
	private BoardController boardController;
	
	@Test
	void testSimulationGame() {
		assertTimeout(ofMillis(5000), () -> {
			board = new BoardModel(sequenceLenght, maxAttempts);
			boardController = new BoardController(board);
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
			boardController
					.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.RED));
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.WHITE, ColorPegs.BLUE));
			assertEquals(maxAttempts - board.attemptsInserted(), board.leftAttempts());
			assertFalse(board.hasBreakerGuessed());
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());

			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.WHITE));
			List<ColorPegs> list = board.getLastClue();
			assertEquals(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK), list);
			
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.GREEN, ColorPegs.RED, ColorPegs.WHITE, ColorPegs.WHITE));
			list = board.getLastClue();
			assertEquals(Arrays.asList(ColorPegs.WHITE, ColorPegs.WHITE), list);
			
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.RED));
			assertTrue(board.hasBreakerGuessed());
		});
	}

}

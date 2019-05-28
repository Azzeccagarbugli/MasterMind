package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
			assertEquals(maxAttempts - board.leftAttempts(), boardController.numberOfAttemptsInserted());
			boardController
					.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN));
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.WHITE, ColorPegs.BLUE));
			assertTrue(boardController.hasLeftAttempts());
			assertFalse(boardController.hasBreakerGuessed());
			assertEquals(maxAttempts - board.leftAttempts(), boardController.numberOfAttemptsInserted());
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.WHITE, ColorPegs.YELLOW));
			assertFalse(board.isEmpty());
			assertEquals(Arrays.asList(ColorPegs.WHITE),
					boardController.getClueFromAttempt(
							Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.WHITE, ColorPegs.YELLOW),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.BLUE)));
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.CYAN, ColorPegs.WHITE));
			assertEquals(Arrays.asList(ColorPegs.WHITE, ColorPegs.WHITE),
					boardController.getClueFromAttempt(
							Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.CYAN, ColorPegs.WHITE),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN)));
			assertEquals(maxAttempts - board.leftAttempts(), boardController.numberOfAttemptsInserted());
			assertFalse(boardController.hasBreakerGuessed());
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN));
			assertEquals(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK),
					boardController.getClueFromAttempt(
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN)));
			assertEquals(maxAttempts - board.leftAttempts(), boardController.numberOfAttemptsInserted());
			assertFalse(board.isEmpty());
			assertTrue(boardController.hasBreakerGuessed());
		});
	}

}

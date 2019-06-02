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
		assertTrue(true);
		assertTimeout(ofMillis(5000), () -> {
			board = new BoardModel(sequenceLenght, maxAttempts);
			boardController = new BoardController(board);
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
			boardController
					.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN));
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.WHITE, ColorPegs.BLUE));
			assertEquals(maxAttempts - board.attemptsInserted(), board.leftAttempts());
			assertFalse(board.hasBreakerGuessed());
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.WHITE, ColorPegs.YELLOW));
			assertEquals(Arrays.asList(ColorPegs.WHITE),
					board.getClueFromAttempt(
							Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.WHITE, ColorPegs.YELLOW),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.BLUE)));
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.CYAN, ColorPegs.WHITE));
			assertEquals(Arrays.asList(ColorPegs.WHITE, ColorPegs.WHITE),
					board.getClueFromAttempt(
							Arrays.asList(ColorPegs.WHITE, ColorPegs.RED, ColorPegs.CYAN, ColorPegs.WHITE),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN)));
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
			assertFalse(board.hasBreakerGuessed());
			boardController
					.insertNewAttempt(Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN));
			assertEquals(Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK),
					board.getClueFromAttempt(
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN),
							Arrays.asList(ColorPegs.RED, ColorPegs.GREEN, ColorPegs.BLUE, ColorPegs.CYAN)));
			assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
			assertTrue(board.hasBreakerGuessed());
		});
	}

}

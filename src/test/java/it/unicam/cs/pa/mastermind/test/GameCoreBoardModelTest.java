package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.gamecore.MatchState;

/**
 * Test di controllo all'interno della board.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class GameCoreBoardModelTest {

	private BoardModel board;
	private BoardController boardContr;

	private int sequenceLenght = 4;
	private int maxAttempts = 9;

	List<ColorPegs> toGuess = new ArrayList<ColorPegs>(
			Arrays.asList(ColorPegs.RED, ColorPegs.WHITE, ColorPegs.BLUE, ColorPegs.BLUE));

	List<ColorPegs> attempt = new ArrayList<ColorPegs>(
			Arrays.asList(ColorPegs.RED, ColorPegs.BLACK, ColorPegs.GREEN, ColorPegs.BLUE));

	/**
	 * Setup of the board runned before each other test.
	 */
	@BeforeEach
	void setUp() {
		board = new BoardModel(sequenceLenght, maxAttempts);
		boardContr = new BoardController(board);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#Board(int, int)}.
	 */
	@Test
	void testBoard() {
		assertEquals(4, board.getSequenceLength());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#setSequenceToGuess(java.util.List)}.
	 */
	@Test
	void testSetSequenceToGuess() {
		toGuess = new ArrayList<ColorPegs>(
				Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK));

		Assertions.assertThrows(IllegalArgumentException.class, () -> board.setSequenceToGuess(toGuess));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#leftAttempts()}.
	 */
	@Test
	void testLeftAttempts() {
		boardContr.insertCodeToGuess(toGuess);
		boardContr.insertNewAttempt(attempt);
		assertEquals(maxAttempts - 1, board.leftAttempts());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#attemptsInserted()}.
	 */
	@Test
	void testAttemptsInserted() {
		boardContr.insertCodeToGuess(toGuess);
		boardContr.insertNewAttempt(attempt);
		assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		boardContr.insertCodeToGuess(toGuess);
		boardContr.insertNewAttempt(attempt);
		assertFalse(board.isBoardEmpty());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#addAttempt(java.util.List, java.util.List)}.
	 */
	@Test
	void testAddAttempt() {
		boardContr.insertCodeToGuess(toGuess);
		assertTrue(board.addAttempt(attempt));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardModel#lastAttemptAndClue()}.
	 */
	@Test
	void testLastAttemptAndClue() {
		boardContr.insertCodeToGuess(toGuess);
		board.addAttempt(attempt);

		Map.Entry<List<ColorPegs>, List<ColorPegs>> map = new AbstractMap.SimpleEntry<>(
				Arrays.asList(ColorPegs.RED, ColorPegs.BLACK, ColorPegs.GREEN, ColorPegs.BLUE),
				Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK));

		assertEquals(board.lastAttemptAndClue(), map);
	}
}

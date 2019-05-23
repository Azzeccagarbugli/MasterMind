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

import it.unicam.cs.pa.mastermind.gamecore.Board;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Test di controllo all'interno della board.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class GameCoreBoardTest {

	private Board board;

	private int sequenceLenght = 4;
	private int maxAttempts = 9;

	/**
	 * Setup of the board runned before each other test.
	 */
	@BeforeEach
	void setUp() {
		board = new Board(sequenceLenght, maxAttempts);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#Board(int, int)}.
	 */
	@Test
	void testBoard() {
		assertEquals(4, board.getSequenceLength());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#setSequenceToGuess(java.util.List)}.
	 */
	@Test
	void testSetSequenceToGuess() {
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght + 1; i++) {
			toGuess.add(ColorPegs.CYAN);
		}

		Assertions.assertThrows(IllegalArgumentException.class, () -> board.setSequenceToGuess(toGuess));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#leftAttempts()}.
	 */
	@Test
	void testLeftAttempts() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> clue = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			clue.add(ColorPegs.WHITE);
		}

		board.addAttempt(attempt, clue);
		assertEquals(maxAttempts - 1, board.leftAttempts());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#attemptsInserted()}.
	 */
	@Test
	void testAttemptsInserted() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> clue = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			clue.add(ColorPegs.WHITE);
		}

		board.addAttempt(attempt, clue);
		assertEquals(maxAttempts - board.leftAttempts(), board.attemptsInserted());
	}

	/**
	 * Test method for {@link it.unicam.cs.pa.mastermind.gamecore.Board#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> clue = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			clue.add(ColorPegs.WHITE);
		}

		board.addAttempt(attempt, clue);
		assertFalse(board.isEmpty());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#addAttempt(java.util.List, java.util.List)}.
	 */
	@Test
	void testAddAttempt() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> clue = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			clue.add(ColorPegs.WHITE);
		}

		assertTrue(board.addAttempt(attempt, clue));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.Board#lastAttemptAndClue()}.
	 */
	@Test
	void testLastAttemptAndClue() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> clue = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			clue.add(ColorPegs.WHITE);
		}

		board.addAttempt(attempt, clue);

		Map.Entry<List<ColorPegs>, List<ColorPegs>> map = new AbstractMap.SimpleEntry<>(
				Arrays.asList(ColorPegs.CYAN, ColorPegs.CYAN, ColorPegs.CYAN, ColorPegs.CYAN),
				Arrays.asList(ColorPegs.WHITE, ColorPegs.WHITE, ColorPegs.WHITE, ColorPegs.WHITE));

		assertEquals(board.lastAttemptAndClue(), map);
	}
}

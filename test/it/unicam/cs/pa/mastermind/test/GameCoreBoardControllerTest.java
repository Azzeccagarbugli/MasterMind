package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.Board;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Test di controllo utili alle meccaniche del coordinatore di gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class GameCoreBoardControllerTest {

	private Board board;
	private BoardController boardCord;

	private int sequenceLenght = 4;
	private int maxAttempts = 9;

	/**
	 * Setup of the board runned before each other test.
	 */
	@BeforeEach
	void setUp() {
		board = new Board(sequenceLenght, maxAttempts);
		boardCord = new BoardController(board);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#insertNewAttempt(java.util.List)}.
	 */
	@Test
	void testInsertNewAttempt() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < this.sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			toGuess.add(ColorPegs.RED);
		}

		board.setSequenceToGuess(toGuess);
		assertTrue(boardCord.insertNewAttempt(attempt));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#hasLeftAttempts()}.
	 */
	@Test
	void testHasLeftAttempts() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			toGuess.add(ColorPegs.RED);
		}

		board.setSequenceToGuess(toGuess);
		boardCord.insertNewAttempt(attempt);
		assertTrue(boardCord.hasLeftAttempts());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#hasBreakerGuessed()}.
	 */
	@Test
	void testHasBreakerGuessed() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			toGuess.add(ColorPegs.CYAN);
		}

		board.setSequenceToGuess(toGuess);
		boardCord.insertNewAttempt(attempt);
		assertTrue(boardCord.hasBreakerGuessed());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#numberOfAttemptsInserted()}.
	 */
	@Test
	void testNumberOfAttemptsInserted() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			toGuess.add(ColorPegs.RED);
		}

		board.setSequenceToGuess(toGuess);
		boardCord.insertNewAttempt(attempt);
		assertEquals(maxAttempts - board.leftAttempts(), boardCord.numberOfAttemptsInserted());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#getSequenceToGuess()}.
	 */
	@Test
	void testGetSequenceToGuess() {
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>(
				Arrays.asList(ColorPegs.BLUE, ColorPegs.RED, ColorPegs.BLUE, ColorPegs.CYAN));
		boardCord.insertCodeToGuess(toGuess);
		assertEquals(toGuess, boardCord.getSequenceToGuess());
	}
	
	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#insertCodeToGuess(java.util.List)}.
	 */
	@Test
	void testInsertCodeToGuess() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>();
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>();

		for (int i = 0; i < sequenceLenght; i++) {
			attempt.add(ColorPegs.CYAN);
			toGuess.add(ColorPegs.RED);
		}

		board.setSequenceToGuess(toGuess);
		assertTrue(boardCord.insertCodeToGuess(attempt));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#getClueFromAttempt(java.util.List, java.util.List)}.
	 */
	@Test
	void testGetClueFromAttempt() {
		List<ColorPegs> attempt = new ArrayList<ColorPegs>(
				Arrays.asList(ColorPegs.BLUE, ColorPegs.RED, ColorPegs.BLUE, ColorPegs.YELLOW));
		List<ColorPegs> toGuess = new ArrayList<ColorPegs>(
				Arrays.asList(ColorPegs.BLUE, ColorPegs.RED, ColorPegs.BLUE, ColorPegs.CYAN));
		List<ColorPegs> clues = new ArrayList<ColorPegs>(
				Arrays.asList(ColorPegs.BLACK, ColorPegs.BLACK, ColorPegs.BLACK));

		boardCord.insertCodeToGuess(toGuess);
		boardCord.insertNewAttempt(attempt);
		assertEquals(clues, boardCord.getClueFromAttempt(attempt, toGuess));
	}
}

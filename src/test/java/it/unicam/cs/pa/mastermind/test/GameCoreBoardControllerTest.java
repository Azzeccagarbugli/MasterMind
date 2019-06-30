package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.gamecore.MatchState;

/**
 * Test di controllo utili alle meccaniche del coordinatore di gioco.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class GameCoreBoardControllerTest {

	private BoardModel board;
	private BoardController boardCord;

	private int sequenceLenght = 4;
	private int maxAttempts = 9;

	List<ColorPegs> toGuess = new ArrayList<ColorPegs>(
			Arrays.asList(ColorPegs.RED, ColorPegs.WHITE, ColorPegs.BLUE, ColorPegs.BLUE));
	
	List<ColorPegs> attempt = new ArrayList<ColorPegs>(
			Arrays.asList(ColorPegs.RED, ColorPegs.BLACK, ColorPegs.GREEN, ColorPegs.BLUE));
	
	private MatchState gameState;
	
	/**
	 * Setup of the board runned before each other test.
	 */
	@BeforeEach
	void setUp() {
		board = new BoardModel(sequenceLenght, maxAttempts);
		gameState = new MatchState();
		board.addObserver(gameState);
		boardCord = new BoardController(board);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#BoardController(it.unicam.cs.pa.mastermind.gamecore.BoardModel)}.
	 */
	@Test
	void testBoardController() {
		assertNotNull(boardCord);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#insertNewAttempt(java.util.List)}.
	 */
	@Test
	void testInsertNewAttempt() {
		boardCord.insertCodeToGuess(toGuess);
		assertTrue(boardCord.insertNewAttempt(attempt));
		assertFalse(board.hasBreakerGuessed());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#insertCodeToGuess(java.util.List)}.
	 */
	@Test
	void testInsertCodeToGuess() {
		assertTrue(boardCord.insertCodeToGuess(toGuess));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#getSequenceToGuess()}.
	 */
	@Test
	void testGetSequenceToGuess() {
		boardCord.insertCodeToGuess(toGuess);
		assertEquals(board.getSequenceToGuess(), toGuess);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.gamecore.BoardController#getSequenceLength()}.
	 */
	@Test
	void testGetSequenceLength() {
		assertEquals(sequenceLenght, board.getSequenceLength());
	}

}

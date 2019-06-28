package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;

/**
 * Test di controllo utili alla generazione di un player codficatore di natura
 * umana.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersInteractiveMakerTest {

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.InteractiveMaker#getCodeToGuess(int, it.unicam.cs.pa.mastermind.ui.InteractionView)}.
	 */
	@Test
	void testGetCodeToGuess() {
		BoardModel tempBoard = new BoardModel(4, 9);
		BoardController boardController = new BoardController(tempBoard);
		boardController.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		assertEquals(tempBoard.getSequenceToGuess(),
				Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		boardController.insertNewAttempt(Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		assertTrue(tempBoard.hasBreakerGuessed());
	}

}

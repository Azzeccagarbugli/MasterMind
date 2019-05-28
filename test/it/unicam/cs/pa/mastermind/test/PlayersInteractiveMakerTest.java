package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.InteractiveMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Test di controllo utili alla generazione di un player codficatore di natura
 * umana.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersInteractiveMakerTest {

	private List<Integer> listToGuess;

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.InteractiveMaker#getCodeToGuess(int, it.unicam.cs.pa.mastermind.ui.InteractionView)}.
	 */
	@Test
	void testGetCodeToGuess() {
		BoardModel tempBoard = new BoardModel(4, 9);
		BoardController boardController = new BoardController(tempBoard);
		InteractionView intManager = new InteractionView() {
			@Override
			public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) {
				listToGuess = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 3));
				return listToGuess;
			}

			@Override
			public void showGame(List<Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
				// TODO Auto-generated method stub

			}

			@Override
			public void showGameDebug(List<ColorPegs> toGuess,
					List<Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean[] ending(String gameEndingMessage, List<ColorPegs> toGuess) {
				// TODO Auto-generated method stub
				return null;
			}

		};
		boardController.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		assertEquals(boardController.getSequenceToGuess(),
				Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		InteractiveMaker interactivePlayer = new InteractiveMaker();
		boardController.insertNewAttempt(interactivePlayer.getCodeToGuess(tempBoard.getSequenceLength(), intManager));
		assertTrue(boardController.hasBreakerGuessed());
	}
}

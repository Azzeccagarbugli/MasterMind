package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.InteractiveBreaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Test di controllo utili alla generazione di un player decodficatore di natura
 * umana.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersInteractiveBreakerTest {

	private List<Integer> listAttempt;

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.InteractiveBreaker#getAttempt(int, it.unicam.cs.pa.mastermind.ui.InteractionView)}.
	 */
	@Test
	void testGetAttempt() {
		BoardModel tempBoard = new BoardModel(4, 9);
		BoardController boardController = new BoardController(tempBoard);
		InteractionView intManager = new InteractionView() {
			@Override
			public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess) {
				listAttempt = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 4));
				return listAttempt;
			}

			@Override
			public void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}

		};
		boardController.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		assertEquals(boardController.getSequenceToGuess(),
				Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		InteractiveBreaker interactiveBreaker = new InteractiveBreaker();
		boardController.insertNewAttempt(interactiveBreaker.getAttempt(tempBoard.getSequenceLength(), intManager));
		assertEquals(tempBoard.attemptsInserted(), 1);
		boardController.insertNewAttempt(interactiveBreaker.getAttempt(tempBoard.getSequenceLength(), intManager));
		assertFalse(tempBoard.hasBreakerGuessed());
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.InteractiveBreaker#InteractiveBreaker()}.
	 */
	@Test
	void testInteractiveBreaker() {
		InteractiveBreaker interactivePlayer = new InteractiveBreaker();
		assertNotNull(interactivePlayer);
	}

}

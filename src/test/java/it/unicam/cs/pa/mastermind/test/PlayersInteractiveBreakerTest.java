package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
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

	private List<ColorPegs> listAttempt;

	private CodeBreaker breaker;

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
			public void update() {
				// TODO Auto-generated method stub

			}

			@Override
			public List<Integer> getIndexSequence(boolean toGuess) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<ColorPegs> getCodeToGuess(CodeMaker maker) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<ColorPegs> getAttempt(CodeBreaker breaker) {
				listAttempt = new ArrayList<ColorPegs>(
						Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
				return listAttempt;
			}

			@Override
			public void endingScreen(String gameEndingMessage) {
				// TODO Auto-generated method stub

			}
		};
		boardController.insertCodeToGuess(Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		assertEquals(tempBoard.getSequenceToGuess(),
				Arrays.asList(ColorPegs.RED, ColorPegs.RED, ColorPegs.RED, ColorPegs.YELLOW));
		boardController.insertNewAttempt(intManager.getAttempt(breaker));
		assertEquals(tempBoard.attemptsInserted(), 1);
		boardController.insertNewAttempt(intManager.getAttempt(breaker));
		assertTrue(tempBoard.hasBreakerGuessed());
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

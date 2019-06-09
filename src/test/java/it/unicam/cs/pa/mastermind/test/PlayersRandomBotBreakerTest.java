package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.gamecore.BoardModel;
import it.unicam.cs.pa.mastermind.gamecore.ColorPegs;
import it.unicam.cs.pa.mastermind.gamecore.BoardController;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.ui.InteractionView;

/**
 * Test di controllo utili alla generazione di un player decodficatore di natura
 * bot.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersRandomBotBreakerTest {

	List<ColorPegs> listToGuess;
	
	private CodeBreaker breaker;
	
	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.RandomBotBreaker#getAttempt(int, it.unicam.cs.pa.mastermind.ui.InteractionManager)}.
	 */
	@Test
	void testGetAttempt() {
		BoardModel boardTemp = new BoardModel(4, 9);
		BoardController boardController = new BoardController(boardTemp);
		InteractionView intMan = new InteractionView() {
			
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
				// TODO Auto-generated method stub
				listToGuess = new ArrayList<ColorPegs>();
				return listToGuess;
			}
			
			@Override
			public void endingScreen(String gameEndingMessage) {
				// TODO Auto-generated method stub
				
			}
		};
		boardController
				.insertCodeToGuess(Arrays.asList(ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.GREEN, ColorPegs.GREEN));
		boardController.insertNewAttempt(intMan.getAttempt(breaker));
		assertEquals(9 - boardTemp.leftAttempts(), boardTemp.attemptsInserted());
	}
}

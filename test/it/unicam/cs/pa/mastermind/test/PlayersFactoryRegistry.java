package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;
import it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry;

/**
 * Test di controllo utili alla generazione delle factory relativi ai player.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
class PlayersFactoryRegistry {

	private CodeMaker codeMaker;
	private CodeBreaker codeBreaker;

	private MakerFactory codeMakerFactory;
	private BreakerFactory codeBreakerFactory;
	
	List<String> playersFactory;
	
	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry#BreakerFactoryRegistry()}.
	 */
	@Test
	void testBreakerFactoryRegistry() {
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry();
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("interactive player");
		codeBreaker = codeBreakerFactory.getBreaker();
		assertNotNull(codeBreaker);
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("random bot");
		codeBreaker = codeBreakerFactory.getBreaker();
		assertNotNull(codeBreaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry#MakerFactoryRegistry()}.
	 */
	@Test
	void testMakerFactoryRegistry() {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry();
		playersFactory = makerFactory.getPlayersNames();
		assertEquals(Arrays.asList("interactive player", "random bot"), playersFactory);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("Interactive Player");
		codeMaker = codeMakerFactory.getMaker();
		assertNotNull(codeMaker);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("Random Bot");
		codeMaker = codeMakerFactory.getMaker();
		assertNotNull(codeMaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry#getFactoryByName(java.lang.String)}.
	 */
	@Test
	void testGetFactoryByName() {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry();
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry();
		assertNull(makerFactory.getFactoryByName("42"));
		assertNull(breakerFactory.getFactoryByName("Guida Galattica per Autostoppisti"));
		assertNotNull(makerFactory.getFactoryByName("Interactive Player"));
		assertNotNull(makerFactory.getFactoryByName("Random Bot"));
		assertNotNull(breakerFactory.getFactoryByName("Interactive Player"));
		assertNotNull(breakerFactory.getFactoryByName("Random Bot"));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry#getPlayersNames()}.
	 */
	@Test
	void testGetPlayersNames() {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry();
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry();
		playersFactory = Arrays.asList("interactive player", "random bot");
		assertEquals(playersFactory, makerFactory.getPlayersNames());
		assertEquals(playersFactory, breakerFactory.getPlayersNames());
	}

}

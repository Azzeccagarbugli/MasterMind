package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.factories.BadRegistryException;
import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry;
import it.unicam.cs.pa.mastermind.players.CodeBreaker;
import it.unicam.cs.pa.mastermind.players.CodeMaker;

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
	 * Test method for the check of the existence of the path name passed in the
	 * constructor.
	 * 
	 * @throws BadRegistryException
	 * @throws IOException 
	 */
	@Test
	void testCheckRightPathName() throws BadRegistryException, IOException {
		Assertions.assertThrows(BadRegistryException.class,
				() -> new BreakerFactoryRegistry("./The Hitchhiker's Guide to the Galaxy"));
		Assertions.assertThrows(BadRegistryException.class,
				() -> new MakerFactoryRegistry("./Francesco Stelluti uomo di mondo"));
		Files.deleteIfExists(Paths.get("./The Hitchhiker's Guide to the Galaxy")); 
		Files.deleteIfExists(Paths.get("./Francesco Stelluti uomo di mondo"));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.factories.BreakerFactoryRegistry#BreakerFactoryRegistry()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testBreakerFactoryRegistry() throws BadRegistryException {
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./GameResources/BreakerFactories.txt");
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("Interactive");
		codeBreaker = codeBreakerFactory.getBreaker(null, 4, 11);
		assertNotNull(codeBreaker);
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("Random Bot");
		codeBreaker = codeBreakerFactory.getBreaker(null, 4, 11);
		assertNotNull(codeBreaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.factories.MakerFactoryRegistry#MakerFactoryRegistry()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testMakerFactoryRegistry() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./GameResources/MakerFactories.txt");
		playersFactory = makerFactory.getPlayersNames();
		assertEquals(Arrays.asList("Interactive", "Random Bot"), playersFactory);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("Interactive");
		codeMaker = codeMakerFactory.getMaker(null, 4, 11);
		assertNotNull(codeMaker);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("Random Bot");
		codeMaker = codeMakerFactory.getMaker(null, 4, 11);
		assertNotNull(codeMaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry#getFactoryByName(java.lang.String)}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testGetFactoryByName() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./GameResources/MakerFactories.txt");
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./GameResources/BreakerFactories.txt");
		Assertions.assertThrows(BadRegistryException.class,
				() -> makerFactory.getFactoryByName("42"));		
		Assertions.assertThrows(BadRegistryException.class,
				() -> makerFactory.getFactoryByName("Guida Galattica per Autostoppisti"));
		assertNotNull(makerFactory.getFactoryByName("Interactive"));
		assertNotNull(makerFactory.getFactoryByName("Random Bot"));
		assertNotNull(breakerFactory.getFactoryByName("Interactive"));
		assertNotNull(breakerFactory.getFactoryByName("Random Bot"));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.factories.PlayerFactoryRegistry#getPlayersNames()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testGetPlayersNames() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./GameResources/MakerFactories.txt");
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./GameResources/BreakerFactories.txt");
		playersFactory = Arrays.asList("Interactive", "Random Bot");
		assertEquals(playersFactory, makerFactory.getPlayersNames());
		playersFactory = Arrays.asList("Interactive", "Random Bot", "Knuth");
		assertEquals(playersFactory, breakerFactory.getPlayersNames());
	}

}

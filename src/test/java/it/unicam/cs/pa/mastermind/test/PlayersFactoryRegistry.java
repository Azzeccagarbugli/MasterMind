package it.unicam.cs.pa.mastermind.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.mastermind.factories.BreakerFactory;
import it.unicam.cs.pa.mastermind.factories.MakerFactory;
import it.unicam.cs.pa.mastermind.players.BadRegistryException;
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
	 * {@link it.unicam.cs.pa.mastermind.players.BreakerFactoryRegistry#BreakerFactoryRegistry()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testBreakerFactoryRegistry() throws BadRegistryException {
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./Breaker Factories.txt");
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("interactive player breaker");
		codeBreaker = codeBreakerFactory.getBreaker();
		assertNotNull(codeBreaker);
		codeBreakerFactory = (BreakerFactory) breakerFactory.getFactoryByName("random bot breaker");
		codeBreaker = codeBreakerFactory.getBreaker();
		assertNotNull(codeBreaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.MakerFactoryRegistry#MakerFactoryRegistry()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testMakerFactoryRegistry() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./Maker Factories.txt");
		playersFactory = makerFactory.getPlayersNames();
		assertEquals(Arrays.asList("interactive player maker", "random bot maker"), playersFactory);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("interactive player maker");
		codeMaker = codeMakerFactory.getMaker();
		assertNotNull(codeMaker);
		codeMakerFactory = (MakerFactory) makerFactory.getFactoryByName("random bot maker");
		codeMaker = codeMakerFactory.getMaker();
		assertNotNull(codeMaker);
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry#getFactoryByName(java.lang.String)}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testGetFactoryByName() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./Maker Factories.txt");
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./Breaker Factories.txt");
		assertNull(makerFactory.getFactoryByName("42"));
		assertNull(breakerFactory.getFactoryByName("Guida Galattica per Autostoppisti"));
		assertNotNull(makerFactory.getFactoryByName("Interactive Player Maker"));
		assertNotNull(makerFactory.getFactoryByName("Random Bot Maker"));
		assertNotNull(breakerFactory.getFactoryByName("Interactive Player Breaker"));
		assertNotNull(breakerFactory.getFactoryByName("Random Bot Breaker"));
	}

	/**
	 * Test method for
	 * {@link it.unicam.cs.pa.mastermind.players.PlayerFactoryRegistry#getPlayersNames()}.
	 * 
	 * @throws BadRegistryException
	 */
	@Test
	void testGetPlayersNames() throws BadRegistryException {
		MakerFactoryRegistry makerFactory = new MakerFactoryRegistry("./Maker Factories.txt");
		BreakerFactoryRegistry breakerFactory = new BreakerFactoryRegistry("./Breaker Factories.txt");
		playersFactory = Arrays.asList("interactive player maker", "random bot maker");
		assertEquals(playersFactory, makerFactory.getPlayersNames());
		playersFactory = Arrays.asList("interactive player breaker", "random bot breaker");
		assertEquals(playersFactory, breakerFactory.getPlayersNames());
	}

}

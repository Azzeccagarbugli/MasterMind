package it.unicam.cs.pa.mastermind.players;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.factories.PlayerFactory;

/**
 * <b>Responsabilità</b>: gestione dinamica delle implementazioni delle classi factory di <code>CodeMaker</code> e <code>CodeBreaker</code>.
 * Classe astratta estendibile da classi rappresentanti registri contenenti
 * informazioni sulle classi factory impiegate per istanziare le implementazioni
 * dei giocatori.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class PlayerFactoryRegistry {

	/**
	 * Il registro che contiene le associazioni tra stringhe e istanze di
	 * implementazioni di <code>PlayerFactory</code>
	 */
	private Map<String, PlayerFactory> registryFactoryPlayers;

	/**
	 * Costruttore di <code>PlayerFactoryRegistry</code>.
	 * 
	 * @param pathLettura associato al file da cui leggere informazioni da inserire
	 *                    all'interno di <code>registryFactoryPlayers</code>.
	 * @throws BadRegistryException in caso ci siano stati errori nell'inizializzazione del registro
	 */
	public PlayerFactoryRegistry(String pathLettura) throws BadRegistryException {
		registryFactoryPlayers = new LinkedHashMap<String, PlayerFactory>();
		try {
			load(pathLettura);
		} catch (FileNotFoundException e) {
			throw new BadRegistryException(e.getMessage());
		} catch (BadRegistryException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo privato che esegue la lettura delle righe del file di input.
	 * 
	 * @param pathLettura associato al file da cui leggere le informazioni
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws BadRegistryException in caso ci siano stati errori nell'inizializzazione del registro
	 */
	private void load(String pathLettura)
			throws IOException, ClassNotFoundException, InstantiationException, BadRegistryException {
		File f = new File(pathLettura);
		if (f.exists() && !f.isDirectory()) {
			List<String> data = Files.readAllLines(f.toPath(), Charset.defaultCharset());
			for(String line : data) {
				register(line);
			}
		} else {
			List<String> newLines = Arrays.asList(
					"Please insert here the name of the new player you want to insert in the game followed by a / character and the name of the package that contains the factory class for that player implementation.",
					"For example you can insert the following entries:", "Player One/it.unicam.cs.pa.playeronefactory",
					"Player Two/it.unicam.cs.pa.playertwofactory");

			Path fileBreaker = Paths.get(pathLettura);
			Files.write(fileBreaker, newLines, Charset.forName("UTF-8"));
			throw new BadRegistryException("The file at path " + pathLettura
					+ ", used to load the players, wasn't present and it was created.\nPlease check it out to start the game correctly.");
		}
	}

	/**
	 * Aggiunta di informazioni relative ad una implementazione di
	 * <code>PlayerFactory</code>.
	 * 
	 * @param line stringa contenente il nome di una implementazione di
	 *             <code>PlayerFactory</code> e il relativo nome qualificato
	 * @throws BadRegistryException in caso ci siano stati errori nell'inizializzazione del registro
	 */
	private void register(String line) throws BadRegistryException {

		String[] elementi = line.split("/");
		if (elementi.length == 2) {
			registerClass(elementi[0], elementi[1]);
		} else {
			throw new BadRegistryException(
					"There have been problems loading the players from one of the source files.\nPlease check them out.\n");
		}
	}

	/**
	 * Registrazione del nome di una implementazione di <code>PlayerFactory</code> e
	 * del relativo nome qualificato all'interno di
	 * <code>registryFactoryPlayers</code>.
	 * 
	 * @param nomeFactory   nome associato alla implementazione di
	 *                      <code>PlayerFactory</code>
	 * @param classeFactory nome qualificato della implementazione di
	 *                      <code>PlayerFactory</code>
	 * @throws BadRegistryException in caso ci siano stati errori nell'inizializzazione del registro
	 */
	private void registerClass(String nomeFactory, String classeFactory) throws BadRegistryException {
		try {
			Class<? extends PlayerFactory> factory = Class.forName(classeFactory).asSubclass(PlayerFactory.class);
			this.registryFactoryPlayers.put(nomeFactory.toLowerCase(), factory.getConstructor().newInstance());
		} catch (ClassNotFoundException e) {
			throw new BadRegistryException("The factory class \"" + e.getMessage()
					+ "\" defined in one of the player source files is not present into the project.\nPlease modify the source files or add that class.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Ottenimento di istanze di <code>PlayerFactory</code>.
	 * 
	 * @param name nome associato all'istanza di <code>PlayerFactory</code>
	 * @return PlayerFactory associato al nome
	 */
	public PlayerFactory getFactoryByName(String name) {
		return registryFactoryPlayers.get(name.toLowerCase());
	}

	/**
	 * 
	 * @return List contenente i nomi associati alle istanze di
	 *         <code>PlayerFactory</code> presenti in
	 *         <code>registryFactoryPlayers</code>
	 */
	public List<String> getPlayersNames() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(namesPlayers::add);
		return namesPlayers;
	}

	/**
	 * 
	 * @return List contenente le istanze di <code>PlayerFactory</code> presenti in
	 *         <code>registryFactoryPlayers</code>
	 */
	public List<PlayerFactory> getPlayerFactoriesInstances() {
		List<PlayerFactory> factories = new ArrayList<PlayerFactory>();
		registryFactoryPlayers.keySet().stream().map(name -> registryFactoryPlayers.get(name)).forEach(factories::add);
		return factories;
	}

}

package it.unicam.cs.pa.mastermind.players;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.unicam.cs.pa.mastermind.factories.PlayerFactory;

/**
 * <b>Responsabilità</b>: gestione dinamica delle implementazioni delle classi
 * factory di <code>CodeMaker</code> e <code>CodeBreaker</code>. Classe astratta
 * estendibile da classi rappresentanti registri contenenti informazioni sulle
 * classi factory impiegate per istanziare le implementazioni dei giocatori.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class PlayerFactoryRegistry {

	/**
	 * Il registro che contiene le associazioni tra stringhe e istanze di
	 * implementazioni di <code>PlayerFactory</code>
	 */
	private Map<List<String>, PlayerFactory> registryFactoryPlayers;

	/**
	 * Costruttore di <code>PlayerFactoryRegistry</code>.
	 * 
	 * @param pathLettura associato al file da cui leggere informazioni da inserire
	 *                    all'interno di <code>registryFactoryPlayers</code>.
	 * @throws BadRegistryException in caso ci siano stati errori
	 *                              nell'inizializzazione del registro
	 */
	public PlayerFactoryRegistry(String pathLettura) throws BadRegistryException {
		registryFactoryPlayers = new LinkedHashMap<List<String>, PlayerFactory>();
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

	// TODO Aggiornare JavaDoc
	private void load(String pathLettura)
			throws IOException, ClassNotFoundException, InstantiationException, BadRegistryException {
		File f = new File(pathLettura);
		if (f.exists() && !f.isDirectory()) {
			List<String> data = Files.readAllLines(f.toPath(), Charset.defaultCharset());
			for (String line : data) {
				register(line);
			}
		} else {
			if (f.createNewFile()) {
				FileWriter writer = new FileWriter(f);
				writer.write("Prova di scrittura");
				writer.close();
			}
			throw new BadRegistryException("The file at path " + pathLettura
					+ ", used to load the players, wasn't present and it was created.\nPlease check it out to start the game correctly.");
		}
	}

	// TODO Aggiornare JavaDoc
	private void register(String line) throws BadRegistryException {
		registerClass(line);
	}

	// TODO Aggiornare Javadoc
	private void registerClass(String classeFactory) throws BadRegistryException {
		try {
			Class<? extends PlayerFactory> factory = Class.forName(classeFactory).asSubclass(PlayerFactory.class);
			PlayerFactory newFactory = factory.getConstructor().newInstance();
			this.registryFactoryPlayers.put(List.of(newFactory.getName(), newFactory.getDescription()), newFactory);
		} catch (ClassNotFoundException e) {
			throw new BadRegistryException("The factory class \"" + e.getMessage()
					+ "\" defined in one of the player source files is not present into the project.\nPlease modify the source files or add that class.");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	// TODO Aggiornare JavaDoc
	public PlayerFactory getFactoryByName(String name) throws BadRegistryException {
		for (List<String> key : registryFactoryPlayers.keySet()) {
			if (key.get(0).toLowerCase().equals(name.toLowerCase())) {
				return registryFactoryPlayers.get(key);
			}
		}
		throw new BadRegistryException("You tried to get a factory not present in the registry");
	}

	// TODO Aggiornare JavaDoc
	public List<String> getPlayersNames() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(key -> namesPlayers.add(key.get(0)));
		return namesPlayers;
	}

	// TODO Aggiornare JavaDoc
	public List<String> getPlayersDescription() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(key -> namesPlayers.add(key.get(1)));
		return namesPlayers;
	}

	// TODO Aggiornare JavaDoc
	public List<PlayerFactory> getPlayerFactoriesInstances() {
		List<PlayerFactory> factories = new ArrayList<PlayerFactory>();
		registryFactoryPlayers.keySet().stream().forEach(key -> factories.add(registryFactoryPlayers.get(key)));
		return factories;
	}

}

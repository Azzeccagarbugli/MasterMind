package it.unicam.cs.pa.mastermind.factories;

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

/**
 * <b>Responsabilità</b>: gestione dinamica delle implementazioni delle classi
 * factory implementazione di <code>PlayerFactory</code>. Classe astratta
 * estendibile da classi rappresentanti registri contenenti informazioni sulle
 * classi factory impiegate per istanziare le implementazioni dei giocatori.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class PlayerFactoryRegistry {

	/**
	 * Struttura dati di base in cui sono contenute le istanze di oggetti
	 * <code>PlayerFactory</code> e informazioni quali nome (a indice 0 all'interno
	 * delle List valide come key) e descrizione (a indice 1 all'interno delle List
	 * valide come key).
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

	/**
	 * Caricamento all'interno della struttura dati delle informazioni relative al
	 * file letto in input. In caso il file non fosse presente viene creato con
	 * indicazioni utili per un corretto avvio del programma.
	 * 
	 * @param pathLettura pathname associato al file a cui recuperare le
	 *                    informazioni
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws BadRegistryException   in caso ci siano stati errori nella gestione
	 *                                del file
	 */
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
				writer.write(
						"Please insert here the qualified names of all of the factories of the player implementations you added to the game."
								+ "Please insert only one factory's qualified name per line.");
				writer.close();
			}
			throw new BadRegistryException("The file at path " + pathLettura
					+ ", used to load the players, wasn't present and it was created.\nPlease check it out to start the game correctly.");
		}
	}

	/**
	 * Caricamento all'interno della struttura dati delle informazioni relative ad
	 * una singola riga del file letto in input.
	 * 
	 * @param line contenente le informazioni utili per il caricamento
	 * @throws BadRegistryException in caso ci siano stati errori nel caricamento
	 */
	private void register(String line) throws BadRegistryException {
		registerClass(line);
	}

	/**
	 * Caricamento all'interno della struttura dati delle informazioni relative ad
	 * un nome qualificato rappresentante una classe implementazione di
	 * <code>PlayerFactory</code>.
	 * 
	 * @param classeFactory nome qualificato della classe da caricare nella
	 *                      struttura dati
	 * @throws BadRegistryException in caso ci siano stati errori nel caricamento
	 */
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

	/**
	 * Ottenimento di un'istanza di <code>PlayerFactory</code> dalla struttura dati
	 * di base conoscendo il suo nome.
	 * 
	 * @param name della particolare <code>PlayerFactory</code> richiesta
	 * @return PlayerFactory richiesta
	 * @throws BadRegistryException in caso la particolare
	 *                              <code>PlayerFactory</code> con il nome
	 *                              specificato tramite argomento non sia presente
	 */
	public PlayerFactory getFactoryByName(String name) throws BadRegistryException {
		for (List<String> key : registryFactoryPlayers.keySet()) {
			if (key.get(0).toLowerCase().equals(name.toLowerCase())) {
				return registryFactoryPlayers.get(key);
			}
		}
		throw new BadRegistryException("You tried to get a factory not present in the registry");
	}

	/**
	 * 
	 * @return List contenente tutti i nomi delle istanze <code>PlayerFactory</code>
	 *         caricate
	 */
	public List<String> getPlayersNames() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(key -> namesPlayers.add(key.get(0)));
		return namesPlayers;
	}

	/**
	 * 
	 * @return List contenente tutte le descrizioni delle istanze
	 *         <code>PlayerFactory</code> caricate
	 */
	public List<String> getPlayersDescription() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(key -> namesPlayers.add(key.get(1)));
		return namesPlayers;
	}

	/**
	 * 
	 * @return List contenente tutte le istanze <code>PlayerFactory</code> caricate
	 */
	public List<PlayerFactory> getPlayerFactoriesInstances() {
		List<PlayerFactory> factories = new ArrayList<PlayerFactory>();
		registryFactoryPlayers.keySet().stream().forEach(key -> factories.add(registryFactoryPlayers.get(key)));
		return factories;
	}

}

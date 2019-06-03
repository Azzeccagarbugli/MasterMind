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
 * La classe astratta mostrata qui di seguito dispone il codice per l'utilizzo
 * di un <i>factory registry</i> pubblico nel quale andare a iscrivere i player
 * che si vogliono registrare ad un match.
 * 
 * @author Francesco Pio Stelluti, Francesco Coppola
 *
 */
public abstract class PlayerFactoryRegistry {

	/**
	 * Mappa privata composta da <code>stringhe</code> e <code>PlayerFactory</code>
	 * utilizzata come registro pubblico di player.
	 */
	private Map<String, PlayerFactory> registryFactoryPlayers;

	/**
	 * Il costruttore decide il ciò da farsi basandosi sul parametro locale
	 * <code>pathLettura</code> che andà a determinare il nome del file dal quale
	 * attingere le informazioni fondamentali per la disputa del game.
	 * 
	 * @param pathLettura il nome del file in questione
	 */
	public PlayerFactoryRegistry(String pathLettura) {
		registryFactoryPlayers = new LinkedHashMap<String, PlayerFactory>();
		try {
			load(pathLettura);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo privato che esegue la lettura delle righe del file di input.
	 * 
	 * @param pathLettura il nome del file in questione
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	private void load(String pathLettura) throws IOException, ClassNotFoundException, InstantiationException {
		File f = new File(pathLettura);
		if (f.exists() && !f.isDirectory()) {
			List<String> data = Files.readAllLines(f.toPath(), Charset.defaultCharset());
			data.stream().forEach(l -> register(l));
		} else {
			List<String> newLines = Arrays.asList(
					"Please insert here the name of the new player you want to insert in the game followed by a / character and the name of the package that contains the factory class for that player implementation.",
					"For example you can insert the following entries:", "Player One/it.unicam.cs.pa.playeronefactory",
					"Player Two/it.unicam.cs.pa.playertwofactory");

			Path fileBreaker = Paths.get(pathLettura);
			Files.write(fileBreaker, newLines, Charset.forName("UTF-8"));
			throw new FileNotFoundException("The file at path " + pathLettura
					+ ", used to load the players, wasn't present and it was created.\nPlease check it out to start the game correctly.");
		}
	}

	/**
	 * Il seguente metodo consente l'iscrizione al registro ai player.
	 * 
	 * @param lineaFile la stringa di testo che verrà utilizzata come riferimento al
	 *                  player
	 */
	private void register(String lineaFile) {
		try {
			String[] elementi = lineaFile.split("/");
			if (elementi.length == 2) {
				registerClass(elementi[0], elementi[1]);
			} else {
				throw new IllegalArgumentException();
			}
		} catch (IllegalArgumentException e) {
			System.out.println(
					"There have been problems loading the players from one of the source files.\nPlease check them out.\n");
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Metodo necessario alla registrazione della classe all'interno del registro di
	 * gioco.
	 * 
	 * @param nomeFactory   il nome della factory che si vuole adottare
	 * @param classeFactory il nome della classe che si vuole adottare
	 */
	public void registerClass(String nomeFactory, String classeFactory) {
		try {
			Class<? extends PlayerFactory> factory = Class.forName(classeFactory).asSubclass(PlayerFactory.class);
			this.registryFactoryPlayers.put(nomeFactory.toLowerCase(), factory.getConstructor().newInstance());
		} catch (ClassNotFoundException e) {
			System.out.println("The factory class \"" + e.getMessage()
					+ "\" defined in one of the player source files is not present into the project.\nPlease modify the source files or add that class.");
			System.exit(-1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Metodo getter che restituisce il PlayerFactory in base alla stringa che gli
	 * viene passata come parametro locale del metodo stesso.
	 * 
	 * @param name il nome della factory che si vuole ottenere
	 * @return il PlayerFactory corrispondente
	 */
	public PlayerFactory getFactoryByName(String name) {
		return registryFactoryPlayers.get(name.toLowerCase());
	}

	/**
	 * Metodo provato che restituisce tutti i nomi dei players all'interno della
	 * factory.
	 * 
	 * @return la lista contenente i nomi dei players
	 */
	public List<String> getPlayersNames() {
		List<String> namesPlayers = new ArrayList<String>();
		registryFactoryPlayers.keySet().stream().forEach(namesPlayers::add);
		return namesPlayers;
	}

}

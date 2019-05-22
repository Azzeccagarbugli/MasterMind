package it.unicam.cs.pa.mastermind.players;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

public abstract class PlayerFactoryRegistry {

	private Map<String, PlayerFactory> registroFactoryGiocatori;

	public PlayerFactoryRegistry(String pathLettura) {
		registroFactoryGiocatori = new LinkedHashMap<String, PlayerFactory>();
		try {
			load(pathLettura);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void load(String pathLettura) throws IOException, ClassNotFoundException, InstantiationException {
		File f = new File(pathLettura);
		if (f.exists() && !f.isDirectory()) {
			List<String> data = Files.readAllLines(f.toPath(), Charset.defaultCharset());
			data.stream().forEach(l -> register(l));
		} else if (pathLettura == "./BreakerFactoryLista.txt") {
			List<String> linesCodeBreaker = Arrays.asList(
					"Interactive it.unicam.cs.pa.mastermind.factories.InteractiveBreakerFactory",
					"RandomBot it.unicam.cs.pa.mastermind.factories.RandomBotBreakerFactory");

			Path fileBreaker = Paths.get("BreakerFactoryLista.txt");

			Files.write(fileBreaker, linesCodeBreaker, Charset.forName("UTF-8"));
		} else if (pathLettura == "./MakerFactoryLista.txt") {
			List<String> linesCodeMaker = Arrays.asList(
					"Interactive it.unicam.cs.pa.mastermind.factories.InteractiveMakerFactory",
					"RandomBot it.unicam.cs.pa.mastermind.factories.RandomBotMakerFactory");
			Path fileMaker = Paths.get("MakerFactoryLista.txt");
			Files.write(fileMaker, linesCodeMaker, Charset.forName("UTF-8"));
		}

	}

	

	private void register(String lineaFile) {
		try {
			String[] elementi = lineaFile.split(" ");
			if (elementi.length == 2) {
				registerClasse(elementi[0], elementi[1]);
			} else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void registerClasse(String nomeFactory, String classeFactory)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<? extends PlayerFactory> factory = Class.forName(classeFactory).asSubclass(PlayerFactory.class);
		this.registroFactoryGiocatori.put(nomeFactory.toLowerCase(), factory.getConstructor().newInstance());
	}

	public PlayerFactory getFactoryByName(String name) {
		return registroFactoryGiocatori.get(name.toLowerCase());
	}

	public List<String> getPlayersNames() {
		List<String> nomi = new ArrayList<String>();
		registroFactoryGiocatori.keySet().stream().forEach(nomi::add);
		return nomi;
	}

}

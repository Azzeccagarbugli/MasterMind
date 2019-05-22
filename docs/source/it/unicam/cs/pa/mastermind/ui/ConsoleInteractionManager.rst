.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

ConsoleInteractionManager
=========================

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleInteractionManager implements InteractionManager

   Interazione con l'utente durante il gioco via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
beautifyGeneral
^^^^^^^^^^^^^^^

.. java:method:: public String beautifyGeneral(ColorPegs color)
   :outertype: ConsoleInteractionManager

   Dato un colore sottoforma di ColorPegs viene restituito il suo corrispetivo secondo i canoni della decodifica ANSI.

   :param color: il colore che si vuole codificare in una stringa colorata
   :return: la stringa contenente i valori della stringa visualizzati in modalità colorata

ending
^^^^^^

.. java:method:: @Override public boolean[] ending(String gameEndingMessage, List<ColorPegs> toGuess)
   :outertype: ConsoleInteractionManager

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(int sequenceLength, boolean isBreaker)
   :outertype: ConsoleInteractionManager

getIstance
^^^^^^^^^^

.. java:method:: public static ConsoleInteractionManager getIstance()
   :outertype: ConsoleInteractionManager

   Il metodo getInstance garantisce la singolarità della classe all'interno del parco software.

   :return: l'instanza della classe se presente o meno

init
^^^^

.. java:method:: public void init(BufferedReader newReader)
   :outertype: ConsoleInteractionManager

   Inietto all'interno della classe il parametro desiderato che ha nataura \ ``BufferReader``\ .

   :param newReader: il BufferReader necessario all'instanza della classe

isBreakerMessageGiveUp
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void isBreakerMessageGiveUp(boolean isBreaker)
   :outertype: ConsoleInteractionManager

   Mostra la possibilità di resa al player durante la selezione dei colori.

   :param isBreaker: booleano che conferma se il player è un breaker

selectionColor
^^^^^^^^^^^^^^

.. java:method:: public String selectionColor(int index)
   :outertype: ConsoleInteractionManager

   Metodo necessario alla corretta formattazione tabluare della modalità di inserimento dei colori.

   :param index: l'indice restituito dallo stream
   :return: la stringa formattata secondo dei canoni tabulari

showGame
^^^^^^^^

.. java:method:: @Override public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: ConsoleInteractionManager

showGameBasingOnLenght
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void showGameBasingOnLenght(int size, String attemptLabel, String clueLabel)
   :outertype: ConsoleInteractionManager

   Metodo necessario alla creazione del disegno tabulare che contiene le informazioni di gioco.

   :param size: la launghezza dell'array che viene inserito come parametro locale
   :param attemptLabel: il nome dell'etichetta che si vuole dare al titolo dei tentativi inseriti
   :param clueLabel: il nome dell'etichetta che si vuole dare al titolo degli indizi generati

showGameDebug
^^^^^^^^^^^^^

.. java:method:: @Override public void showGameDebug(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: ConsoleInteractionManager

showMenuColor
^^^^^^^^^^^^^

.. java:method:: public void showMenuColor(String labelMsg1, String labelMsg2, boolean isBreaker)
   :outertype: ConsoleInteractionManager

   Metodo necessario alla stampa della scelta dei colori da parte di un player qualsiasi.

   :param labelMsg1: il primo messaggio da visualizzare
   :param labelMsg2: il secondo messaggio da visualizzare


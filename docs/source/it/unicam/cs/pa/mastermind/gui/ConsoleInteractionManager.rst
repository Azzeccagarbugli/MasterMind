.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.exceptions BreakerGiveUpException

.. java:import:: it.unicam.cs.pa.mastermind.exceptions EndingException

ConsoleInteractionManager
=========================

.. java:package:: it.unicam.cs.pa.mastermind.gui
   :noindex:

.. java:type:: public class ConsoleInteractionManager implements InteractionManager

   Interazione con l'utente durante il gioco via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
ConsoleInteractionManager
^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ConsoleInteractionManager(BufferedReader newReader)
   :outertype: ConsoleInteractionManager

   Costruisco l'elemento \ ``CommandLineInteractionManager``\ , il quale permette l'interazione tra il gioco e i vari player disponibili.

   :param newReader: il BufferReader necessario alla generazione della classe

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

.. java:method:: @Override public boolean[] ending(EndingException exe, List<ColorPegs> toGuess)
   :outertype: ConsoleInteractionManager

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(int sequenceLength, boolean isBreaker) throws BreakerGiveUpException
   :outertype: ConsoleInteractionManager

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


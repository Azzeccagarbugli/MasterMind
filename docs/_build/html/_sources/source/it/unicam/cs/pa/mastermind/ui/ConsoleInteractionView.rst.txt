.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

ConsoleInteractionView
======================

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleInteractionView extends InteractionView

   Interazione con l'utente durante il gioco via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
beautifyGeneral
^^^^^^^^^^^^^^^

.. java:method:: public String beautifyGeneral(ColorPegs color)
   :outertype: ConsoleInteractionView

   Dato un colore sottoforma di ColorPegs viene restituito il suo corrispetivo secondo i canoni della decodifica ANSI.

   :param color: il colore che si vuole codificare in una stringa colorata
   :return: la stringa contenente i valori della stringa visualizzati in modalità colorata

endingScreen
^^^^^^^^^^^^

.. java:method:: @Override public void endingScreen(String gameEndingMessage, List<ColorPegs> toGuess)
   :outertype: ConsoleInteractionView

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(boolean isBreaker)
   :outertype: ConsoleInteractionView

getInstance
^^^^^^^^^^^

.. java:method:: public static ConsoleInteractionView getInstance()
   :outertype: ConsoleInteractionView

   Il metodo getInstance garantisce la singolarità della classe all'interno del parco software.

   :return: l'instanza della classe se presente o meno

init
^^^^

.. java:method:: public void init(BufferedReader newReader)
   :outertype: ConsoleInteractionView

   Inietto all'interno della classe il parametro desiderato che ha nataura \ ``BufferReader``\ .

   :param newReader: il BufferReader necessario all'instanza della classe

isBreakerMessageGiveUp
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void isBreakerMessageGiveUp(boolean isBreaker)
   :outertype: ConsoleInteractionView

   Mostra la possibilità di resa al player durante la selezione dei colori.

   :param isBreaker: booleano che conferma se il player è un breaker

selectionColor
^^^^^^^^^^^^^^

.. java:method:: public String selectionColor(int index)
   :outertype: ConsoleInteractionView

   Metodo necessario alla corretta formattazione tabluare della modalità di inserimento dei colori.

   :param index: l'indice restituito dallo stream
   :return: la stringa formattata secondo dei canoni tabulari

showMenuColor
^^^^^^^^^^^^^

.. java:method:: public void showMenuColor(String labelMsg1, String labelMsg2, boolean isBreaker)
   :outertype: ConsoleInteractionView

   Metodo necessario alla stampa della scelta dei colori da parte di un player qualsiasi.

   :param labelMsg1: il primo messaggio da visualizzare
   :param labelMsg2: il secondo messaggio da visualizzare

update
^^^^^^

.. java:method:: @Override public void update()
   :outertype: ConsoleInteractionView


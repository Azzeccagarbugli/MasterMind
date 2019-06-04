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

   Implementazione con interazione via console della classe \ ``InteractionView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: @Override public void endingScreen(String gameEndingMessage)
   :outertype: ConsoleInteractionView

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(boolean isBreaker)
   :outertype: ConsoleInteractionView

getInstance
^^^^^^^^^^^

.. java:method:: public static ConsoleInteractionView getInstance()
   :outertype: ConsoleInteractionView

   :return: ConsoleStartView istanza singleton di \ ``ConsoleInteractionView``\ .

init
^^^^

.. java:method:: public void init(BufferedReader newReader)
   :outertype: ConsoleInteractionView

   Inizializzazione del reader associato all'istanza di \ ``ConsoleInteractionView``\ .

   :param newReader: reader da associare all'istanza.

update
^^^^^^

.. java:method:: @Override public void update()
   :outertype: ConsoleInteractionView


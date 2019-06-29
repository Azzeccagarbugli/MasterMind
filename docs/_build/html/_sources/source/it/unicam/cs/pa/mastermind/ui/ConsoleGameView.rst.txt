.. java:import:: java.io BufferedReader

.. java:import:: java.io FilterInputStream

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

ConsoleGameView
===============

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleGameView extends GameView

   Implementazione di una vista con interazione via console della classe \ ``GameView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
ConsoleGameView
^^^^^^^^^^^^^^^

.. java:constructor:: public ConsoleGameView()
   :outertype: ConsoleGameView

   Inizializzazione della vista con un \ ``FilterInputStream``\  che non porta alla chiusura di \ ``System.in``\  all'interno del suo metodo \ ``close()``\ .

Methods
-------
endingScreen
^^^^^^^^^^^^

.. java:method:: @Override public void endingScreen(String gameEndingMessage)
   :outertype: ConsoleGameView

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(boolean isBreaker)
   :outertype: ConsoleGameView

showGame
^^^^^^^^

.. java:method:: @Override public void showGame()
   :outertype: ConsoleGameView

update
^^^^^^

.. java:method:: @Override public void update()
   :outertype: ConsoleGameView


.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.util ArrayList

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: java.util.stream IntStream

CommandLineInteractionManager
=============================

.. java:package:: it.unicam.cs.pa.mastermind.gui
   :noindex:

.. java:type:: public class CommandLineInteractionManager implements InteractionManager

   Interazione con l'utente durante il gioco via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
CommandLineInteractionManager
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CommandLineInteractionManager(BufferedReader newReader)
   :outertype: CommandLineInteractionManager

Methods
-------
ending
^^^^^^

.. java:method:: @Override public boolean[] ending()
   :outertype: CommandLineInteractionManager

getIndexSequence
^^^^^^^^^^^^^^^^

.. java:method:: @Override public List<Integer> getIndexSequence(int sequenceLength, boolean toGuess)
   :outertype: CommandLineInteractionManager

showGame
^^^^^^^^

.. java:method:: @Override public void showGame(List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: CommandLineInteractionManager

showGame
^^^^^^^^

.. java:method:: public void showGame(List<ColorPegs> toGuess, List<Map.Entry<List<ColorPegs>, List<ColorPegs>>> attemptsAndClues)
   :outertype: CommandLineInteractionManager

showGameBasingOnLenght
^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void showGameBasingOnLenght(int size, String attemptLabel, String clueLabel)
   :outertype: CommandLineInteractionManager


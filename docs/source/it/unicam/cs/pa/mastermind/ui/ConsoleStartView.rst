.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util List

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.gamecore NewGameStats

.. java:import:: it.unicam.cs.pa.mastermind.players PlayerFactoryRegistry

ConsoleStartView
================

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleStartView extends StartView

   Implementazione con interazione via console della classe \ ``StartView``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
askNewAttempts
^^^^^^^^^^^^^^

.. java:method:: @Override protected int askNewAttempts()
   :outertype: ConsoleStartView

askNewGameSettings
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected NewGameStats askNewGameSettings()
   :outertype: ConsoleStartView

askNewLength
^^^^^^^^^^^^

.. java:method:: @Override protected int askNewLength()
   :outertype: ConsoleStartView

askNewSettings
^^^^^^^^^^^^^^

.. java:method:: @Override protected boolean askNewSettings()
   :outertype: ConsoleStartView

badEnding
^^^^^^^^^

.. java:method:: @Override protected void badEnding(String reason)
   :outertype: ConsoleStartView

ending
^^^^^^

.. java:method:: @Override protected void ending()
   :outertype: ConsoleStartView

getInstance
^^^^^^^^^^^

.. java:method:: public static ConsoleStartView getInstance()
   :outertype: ConsoleStartView

   :return: ConsoleStartView istanza singleton di \ ``ConsoleStartView``\ .

getInteractionView
^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected InteractionView getInteractionView()
   :outertype: ConsoleStartView

getPlayerName
^^^^^^^^^^^^^

.. java:method:: @Override protected String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker)
   :outertype: ConsoleStartView

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: ConsoleStartView

showLogo
^^^^^^^^

.. java:method:: @Override protected void showLogo()
   :outertype: ConsoleStartView

showNewGameStarting
^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override protected void showNewGameStarting()
   :outertype: ConsoleStartView


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

   La seguente classe è il cuore pulsante dell'intero parco software, essa racchiude al suo interno tutti le componenti descritte fino adesso e ha la responsabilità più elevata di tutte, far usufruire all'utente del gioco Master Mind mediante il lancio del \ ``main``\  che si cela al suo interno.

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

ending
^^^^^^

.. java:method:: @Override protected void ending()
   :outertype: ConsoleStartView

getInstance
^^^^^^^^^^^

.. java:method:: public static ConsoleStartView getInstance()
   :outertype: ConsoleStartView

   Il metodo getInstance garantisce la singolarità della classe all'interno del parco software.

   :return: l'instanza della classe se presente o meno

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


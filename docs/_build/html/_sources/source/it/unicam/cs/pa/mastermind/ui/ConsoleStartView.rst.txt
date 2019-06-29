.. java:import:: java.io BufferedReader

.. java:import:: java.io FilterInputStream

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util List

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.factories PlayerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.gamecore StartupSettings

ConsoleStartView
================

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleStartView implements StartView

   Implementazione con interazione via console della classe \ ``StartView``\ . Integra il pattern \ **Singleton**\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
askNewAttempts
^^^^^^^^^^^^^^

.. java:method:: @Override public int askNewAttempts(int lowTreshold)
   :outertype: ConsoleStartView

askNewLength
^^^^^^^^^^^^

.. java:method:: @Override public int askNewLength(int lowTreshold, int highTreshhold)
   :outertype: ConsoleStartView

askNewLengthsAndAttempts
^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public boolean askNewLengthsAndAttempts()
   :outertype: ConsoleStartView

askNewStartupSettings
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public StartupSettings askNewStartupSettings()
   :outertype: ConsoleStartView

badEnding
^^^^^^^^^

.. java:method:: @Override public void badEnding(String reason)
   :outertype: ConsoleStartView

ending
^^^^^^

.. java:method:: @Override public void ending()
   :outertype: ConsoleStartView

getInstance
^^^^^^^^^^^

.. java:method:: public static ConsoleStartView getInstance()
   :outertype: ConsoleStartView

   :return: ConsoleStartView istanza \ **Singleton**\  di \ ``ConsoleStartView``\ .

getPlayerName
^^^^^^^^^^^^^

.. java:method:: @Override public String getPlayerName(PlayerFactoryRegistry registry, boolean isBreaker)
   :outertype: ConsoleStartView

showLogo
^^^^^^^^

.. java:method:: @Override public void showLogo()
   :outertype: ConsoleStartView

showNewMatchStarting
^^^^^^^^^^^^^^^^^^^^

.. java:method:: @Override public void showNewMatchStarting()
   :outertype: ConsoleStartView


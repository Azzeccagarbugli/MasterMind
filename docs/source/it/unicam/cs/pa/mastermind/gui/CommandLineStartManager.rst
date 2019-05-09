.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util.function Function

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.core SingleGame

CommandLineStartManager
=======================

.. java:package:: it.unicam.cs.pa.mastermind.gui
   :noindex:

.. java:type:: public class CommandLineStartManager implements StartManager

   Interazione iniziale con l'utente via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
CommandLineStartManager
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CommandLineStartManager()
   :outertype: CommandLineStartManager

Methods
-------
clearScreen
^^^^^^^^^^^

.. java:method:: public void clearScreen()
   :outertype: CommandLineStartManager

   Clear della console.

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: CommandLineStartManager

start
^^^^^

.. java:method:: @Override public void start()
   :outertype: CommandLineStartManager


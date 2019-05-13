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

Fields
------
highTresholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int highTresholdLength
   :outertype: CommandLineStartManager

lowTreshholdAttempts
^^^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTreshholdAttempts
   :outertype: CommandLineStartManager

lowTreshholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTreshholdLength
   :outertype: CommandLineStartManager

Constructors
------------
CommandLineStartManager
^^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public CommandLineStartManager()
   :outertype: CommandLineStartManager

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: CommandLineStartManager

start
^^^^^

.. java:method:: @Override public void start()
   :outertype: CommandLineStartManager


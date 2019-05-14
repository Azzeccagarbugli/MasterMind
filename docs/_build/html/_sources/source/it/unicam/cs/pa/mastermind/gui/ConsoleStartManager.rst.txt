.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.core SingleGame

ConsoleStartManager
===================

.. java:package:: it.unicam.cs.pa.mastermind.gui
   :noindex:

.. java:type:: public class ConsoleStartManager implements StartManager

   Interazione iniziale con l'utente via linea di comando

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
bFactory
^^^^^^^^

.. java:field::  BreakerFactory bFactory
   :outertype: ConsoleStartManager

currentGame
^^^^^^^^^^^

.. java:field::  SingleGame currentGame
   :outertype: ConsoleStartManager

highTresholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int highTresholdLength
   :outertype: ConsoleStartManager

lowTreshholdAttempts
^^^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTreshholdAttempts
   :outertype: ConsoleStartManager

lowTreshholdLength
^^^^^^^^^^^^^^^^^^

.. java:field::  int lowTreshholdLength
   :outertype: ConsoleStartManager

mFactory
^^^^^^^^

.. java:field::  MakerFactory mFactory
   :outertype: ConsoleStartManager

Constructors
------------
ConsoleStartManager
^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public ConsoleStartManager()
   :outertype: ConsoleStartManager

Methods
-------
main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: ConsoleStartManager

start
^^^^^

.. java:method:: @Override public void start()
   :outertype: ConsoleStartManager


.. java:import:: java.io BufferedReader

.. java:import:: java.io IOException

.. java:import:: java.io InputStreamReader

.. java:import:: java.util List

.. java:import:: java.util.stream IntStream

.. java:import:: it.unicam.cs.pa.mastermind.gamecore SingleGame

.. java:import:: it.unicam.cs.pa.mastermind.players BreakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.players CodeBreaker

.. java:import:: it.unicam.cs.pa.mastermind.players CodeMaker

.. java:import:: it.unicam.cs.pa.mastermind.players MakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.players PlayerFactoryRegistry

ConsoleStartManager
===================

.. java:package:: it.unicam.cs.pa.mastermind.ui
   :noindex:

.. java:type:: public class ConsoleStartManager implements StartManager

   Interazione iniziale con l'utente via linea di comando.

   :author: Francesco Pio Stelluti, Francesco Coppola

Fields
------
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

Methods
-------
getIstance
^^^^^^^^^^

.. java:method:: public static ConsoleStartManager getIstance()
   :outertype: ConsoleStartManager

   Il metodo getInstance garantisce la singolarità della classe all'interno del parco software.

   :return: l'instanza della classe se presente o meno

main
^^^^

.. java:method:: public static void main(String[] args)
   :outertype: ConsoleStartManager

start
^^^^^

.. java:method:: @Override public void start()
   :outertype: ConsoleStartManager


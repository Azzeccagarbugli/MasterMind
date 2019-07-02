.. java:import:: java.util ArrayList

.. java:import:: java.util Collections

.. java:import:: java.util Iterator

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.gamecore BoardModel

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

DonaldKnuthBreaker
==================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class DonaldKnuthBreaker extends CodeBreaker

   Estensione di \ ``CodeBreaker``\  mirata ad una gestione del comportamento è basato sull'algoritmo di risoluzione teorizzato dal matematico Donald Knuth, il quale attesta di risolvere il gioco del Mastermind in cinque mosse al massimo mediante una precisa serie di passaggi.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
DonaldKnuthBreaker
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public DonaldKnuthBreaker(int seqLength, int attempts)
   :outertype: DonaldKnuthBreaker

   Viene inizializzato il player \ ``DonaldKnuthBreaker``\  mediante il suo costruttore.

   :param seqLength: la lunghezza della sequenza segreto
   :param attempts: il numero di tentativi disponibili

Methods
-------
generateSet
^^^^^^^^^^^

.. java:method:: public void generateSet()
   :outertype: DonaldKnuthBreaker

   Viene generato il set contenente le 1296 combinazioni possibili.

getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt()
   :outertype: DonaldKnuthBreaker


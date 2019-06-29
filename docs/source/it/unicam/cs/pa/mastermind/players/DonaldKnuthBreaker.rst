.. java:import:: java.util ArrayList

.. java:import:: java.util List

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

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt()
   :outertype: DonaldKnuthBreaker


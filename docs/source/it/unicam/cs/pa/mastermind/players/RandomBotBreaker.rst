.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Random

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

RandomBotBreaker
================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class RandomBotBreaker extends CodeBreaker

   Estensione di \ ``CodeBreaker``\  mirata ad una gestione del comportamento del giocatore in maniera casuale.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
RandomBotBreaker
^^^^^^^^^^^^^^^^

.. java:constructor:: public RandomBotBreaker(int seqLength)
   :outertype: RandomBotBreaker

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt()
   :outertype: RandomBotBreaker

   Potrebbe capitare che la generazione casuale delle sequenze porti ad una sequenza di \ ``ColorPegs``\  già inserita precedentemente. In tal caso verrà ripetuta l'azione di definizione di una nuova sequenza.


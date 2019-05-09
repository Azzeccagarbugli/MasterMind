.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Random

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.pegs ColorPegs

BotBreaker
==========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class BotBreaker implements CodeBreaker

   La classe di seguito permette la creazione di un player avente sembianze da Bot. Ciò implica che le sue scelte e azioni siano semplicemente dettate da meri e puri algoritmi che andranno ad influenzare l'esito della partita.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BotBreaker
^^^^^^^^^^

.. java:constructor:: public BotBreaker()
   :outertype: BotBreaker

   Costruisco un BotBreaker e lo rendo disponibile per una partita qualsisi.

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt(int sequenceLength)
   :outertype: BotBreaker

isGiveUp
^^^^^^^^

.. java:method:: @Override public boolean isGiveUp()
   :outertype: BotBreaker

setGiveUp
^^^^^^^^^

.. java:method:: @Override public void setGiveUp(boolean giveUp)
   :outertype: BotBreaker


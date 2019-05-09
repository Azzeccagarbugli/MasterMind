.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gui InteractionManager

.. java:import:: it.unicam.cs.pa.mastermind.pegs ColorPegs

HumanBreaker
============

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class HumanBreaker implements CodeBreaker

   La classe qui definita permette al giocatore umano di andare a creare una sequenza da decodificare.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
HumanBreaker
^^^^^^^^^^^^

.. java:constructor:: public HumanBreaker(InteractionManager intManager)
   :outertype: HumanBreaker

   Costruisco lo HumanBreaker utilizzando l'\ ``InteractionManager``\  per gestire le varie interazioni.

   :param intManager: un \ ``InteractionManager``\  per definire le sue interazioni

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt(int sequenceLength)
   :outertype: HumanBreaker

isGiveUp
^^^^^^^^

.. java:method:: @Override public boolean isGiveUp()
   :outertype: HumanBreaker

setGiveUp
^^^^^^^^^

.. java:method:: @Override public void setGiveUp(boolean giveUp)
   :outertype: HumanBreaker


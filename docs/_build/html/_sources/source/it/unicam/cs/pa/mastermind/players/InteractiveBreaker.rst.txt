.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionManager

InteractiveBreaker
==================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveBreaker extends CodeBreaker

   La classe qui definita permette al giocatore umano di andare a creare una sequenza da decodificare.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
InteractiveBreaker
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public InteractiveBreaker(InteractionManager intManager)
   :outertype: InteractiveBreaker

   Costruisco lo HumanBreaker utilizzando l'\ ``InteractionManager``\  per gestire le varie interazioni.

   :param intManager: un \ ``InteractionManager``\  per definire le sue interazioni

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt(int sequenceLength)
   :outertype: InteractiveBreaker


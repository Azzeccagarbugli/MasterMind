.. java:import:: java.util ArrayList

.. java:import:: java.util HashSet

.. java:import:: java.util List

.. java:import:: java.util Set

.. java:import:: it.unicam.cs.pa.mastermind.gamecore ColorPegs

.. java:import:: it.unicam.cs.pa.mastermind.ui InteractionView

InteractiveBreaker
==================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public class InteractiveBreaker extends CodeBreaker

   Estensione di \ ``CodeBreaker``\  mirata ad una gestione del comportamento del giocatore tramite interazioni con l'utente umano.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
InteractiveBreaker
^^^^^^^^^^^^^^^^^^

.. java:constructor:: public InteractiveBreaker()
   :outertype: InteractiveBreaker

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: @Override public List<ColorPegs> getAttempt(InteractionView intView)
   :outertype: InteractiveBreaker


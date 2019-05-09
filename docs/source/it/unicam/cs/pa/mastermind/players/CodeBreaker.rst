.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.pegs ColorPegs

CodeBreaker
===========

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public interface CodeBreaker

   Interfaccia relativa ai giocatori che cercano di indovinare la sequenza.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getAttempt
^^^^^^^^^^

.. java:method:: public List<ColorPegs> getAttempt(int sequenceLength)
   :outertype: CodeBreaker

   Restituisce la sequenza di pioli valida come singolo tentativo.

   :param sequenceLength: la lunghezza della sequenza
   :return: la lista dei valori ottenuta

isGiveUp
^^^^^^^^

.. java:method:: public boolean isGiveUp()
   :outertype: CodeBreaker

   Definisce o meno una potenziale arresa da parte del player.

   :return: un booleano a seconda della sua scelta di resa

setGiveUp
^^^^^^^^^

.. java:method:: public void setGiveUp(boolean giveUp)
   :outertype: CodeBreaker

   Setta lo stato di resa da parte del player.

   :param giveUp: un booleano a seconda della sua scelta di resa


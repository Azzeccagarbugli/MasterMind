.. java:import:: java.util List

.. java:import:: it.unicam.cs.pa.mastermind.exceptions BreakerGiveUpException

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

.. java:method:: public List<ColorPegs> getAttempt(int sequenceLength) throws BreakerGiveUpException
   :outertype: CodeBreaker

   Restituisce la sequenza di pioli valida come singolo tentativo.

   :param sequenceLength: la lunghezza della sequenza
   :throws BreakerGiveUpException: eccezione lanciata quando il player decide di effettuare la resa
   :return: la lista dei valori ottenuta


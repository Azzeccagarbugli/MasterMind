PlayerFactory
=============

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public interface PlayerFactory

   \ **Responsabilità**\ : fornire istanze di implementazioni dei giocatori. Interfaccia finalizzata all'implementazione di classi factory per le particolari implementazioni dei giocatori.

   :author: Francesco Pio Stelluti, Francesco Coppola

Methods
-------
getDescription
^^^^^^^^^^^^^^

.. java:method::  String getDescription()
   :outertype: PlayerFactory

   :return: String descrizione della particolare implementazione di un giocatore

getName
^^^^^^^

.. java:method::  String getName()
   :outertype: PlayerFactory

   :return: String nome della particolare implementazione di un giocatore


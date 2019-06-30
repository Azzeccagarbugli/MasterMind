.. java:import:: java.io File

.. java:import:: it.unicam.cs.pa.mastermind.factories BadRegistryException

.. java:import:: it.unicam.cs.pa.mastermind.factories BreakerFactoryRegistry

.. java:import:: it.unicam.cs.pa.mastermind.factories MakerFactoryRegistry

GlobalSettings
==============

.. java:package:: it.unicam.cs.pa.mastermind.gamecore
   :noindex:

.. java:type:: public class GlobalSettings

   \ **Responsabilità**\ : tenere traccia delle impostazioni globali del gioco, comuni a tutte le partite. \ **Contratto**\ : le istanze vengono gestite all'interno di \ ``MainManager``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
GlobalSettings
^^^^^^^^^^^^^^

.. java:constructor:: public GlobalSettings() throws BadRegistryException
   :outertype: GlobalSettings

   Inizializzazione con generazione dei registri

   :throws BadRegistryException: in caso di errori con la generazione dei \ ``PlayerFactoryRegistry``\ .

Methods
-------
getBreakers
^^^^^^^^^^^

.. java:method:: public BreakerFactoryRegistry getBreakers()
   :outertype: GlobalSettings

getMakers
^^^^^^^^^

.. java:method:: public MakerFactoryRegistry getMakers()
   :outertype: GlobalSettings


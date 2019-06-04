.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io IOException

.. java:import:: java.nio.charset Charset

.. java:import:: java.nio.file Files

.. java:import:: java.nio.file Path

.. java:import:: java.nio.file Paths

.. java:import:: java.util ArrayList

.. java:import:: java.util Arrays

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

.. java:import:: it.unicam.cs.pa.mastermind.factories PlayerFactory

PlayerFactoryRegistry
=====================

.. java:package:: it.unicam.cs.pa.mastermind.players
   :noindex:

.. java:type:: public abstract class PlayerFactoryRegistry

   \ **Responsabilità**\ : gestione dinamica delle implementazioni delle classi factory di \ ``CodeMaker``\  e \ ``CodeBreaker``\ . Classe astratta estendibile da classi rappresentanti registri contenenti informazioni sulle classi factory impiegate per istanziare le implementazioni dei giocatori.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
PlayerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PlayerFactoryRegistry(String pathLettura) throws BadRegistryException
   :outertype: PlayerFactoryRegistry

   Costruttore di \ ``PlayerFactoryRegistry``\ .

   :param pathLettura: associato al file da cui leggere informazioni da inserire all'interno di \ ``registryFactoryPlayers``\ .
   :throws BadRegistryException: in caso ci siano stati errori nell'inizializzazione del registro

Methods
-------
getFactoryByName
^^^^^^^^^^^^^^^^

.. java:method:: public PlayerFactory getFactoryByName(String name)
   :outertype: PlayerFactoryRegistry

   Ottenimento di istanze di \ ``PlayerFactory``\ .

   :param name: nome associato all'istanza di \ ``PlayerFactory``\
   :return: PlayerFactory associato al nome

getPlayerFactoriesInstances
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<PlayerFactory> getPlayerFactoriesInstances()
   :outertype: PlayerFactoryRegistry

   :return: List contenente le istanze di \ ``PlayerFactory``\  presenti in \ ``registryFactoryPlayers``\

getPlayersNames
^^^^^^^^^^^^^^^

.. java:method:: public List<String> getPlayersNames()
   :outertype: PlayerFactoryRegistry

   :return: List contenente i nomi associati alle istanze di \ ``PlayerFactory``\  presenti in \ ``registryFactoryPlayers``\


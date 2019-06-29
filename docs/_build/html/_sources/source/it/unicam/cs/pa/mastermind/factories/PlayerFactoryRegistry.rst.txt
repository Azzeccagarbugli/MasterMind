.. java:import:: java.io File

.. java:import:: java.io FileNotFoundException

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

.. java:import:: java.nio.charset Charset

.. java:import:: java.nio.file Files

.. java:import:: java.util ArrayList

.. java:import:: java.util LinkedHashMap

.. java:import:: java.util List

.. java:import:: java.util Map

PlayerFactoryRegistry
=====================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public abstract class PlayerFactoryRegistry

   \ **Responsabilità**\ : gestione dinamica delle implementazioni delle classi factory implementazione di \ ``PlayerFactory``\ . Classe astratta estendibile da classi rappresentanti registri contenenti informazioni sulle classi factory impiegate per istanziare le implementazioni dei giocatori.

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

.. java:method:: public PlayerFactory getFactoryByName(String name) throws BadRegistryException
   :outertype: PlayerFactoryRegistry

   Ottenimento di un'istanza di \ ``PlayerFactory``\  dalla struttura dati di base conoscendo il suo nome.

   :param name: della particolare \ ``PlayerFactory``\  richiesta
   :throws BadRegistryException: in caso la particolare \ ``PlayerFactory``\  con il nome specificato tramite argomento non sia presente
   :return: PlayerFactory richiesta

getPlayerFactoriesInstances
^^^^^^^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<PlayerFactory> getPlayerFactoriesInstances()
   :outertype: PlayerFactoryRegistry

   :return: List contenente tutte le istanze \ ``PlayerFactory``\  caricate

getPlayersDescription
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public List<String> getPlayersDescription()
   :outertype: PlayerFactoryRegistry

   :return: List contenente tutte le descrizioni delle istanze \ ``PlayerFactory``\  caricate

getPlayersNames
^^^^^^^^^^^^^^^

.. java:method:: public List<String> getPlayersNames()
   :outertype: PlayerFactoryRegistry

   :return: List contenente tutti i nomi delle istanze \ ``PlayerFactory``\  caricate


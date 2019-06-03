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

   La classe astratta mostrata qui di seguito dispone il codice per l'utilizzo di un \ *factory registry*\  pubblico nel quale andare a iscrivere i player che si vogliono registrare ad un match.

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
PlayerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public PlayerFactoryRegistry(String pathLettura)
   :outertype: PlayerFactoryRegistry

   Il costruttore decide il ciò da farsi basandosi sul parametro locale \ ``pathLettura``\  che andà a determinare il nome del file dal quale attingere le informazioni fondamentali per la disputa del game.

   :param pathLettura: il nome del file in questione

Methods
-------
getFactoryByName
^^^^^^^^^^^^^^^^

.. java:method:: public PlayerFactory getFactoryByName(String name)
   :outertype: PlayerFactoryRegistry

   Metodo getter che restituisce il PlayerFactory in base alla stringa che gli viene passata come parametro locale del metodo stesso.

   :param name: il nome della factory che si vuole ottenere
   :return: il PlayerFactory corrispondente

getPlayersNames
^^^^^^^^^^^^^^^

.. java:method:: public List<String> getPlayersNames()
   :outertype: PlayerFactoryRegistry

   Metodo provato che restituisce tutti i nomi dei players all'interno della factory.

   :return: la lista contenente i nomi dei players

registerClass
^^^^^^^^^^^^^

.. java:method:: public void registerClass(String nomeFactory, String classeFactory)
   :outertype: PlayerFactoryRegistry

   Metodo necessario alla registrazione della classe all'interno del registro di gioco.

   :param nomeFactory: il nome della factory che si vuole adottare
   :param classeFactory: il nome della classe che si vuole adottare


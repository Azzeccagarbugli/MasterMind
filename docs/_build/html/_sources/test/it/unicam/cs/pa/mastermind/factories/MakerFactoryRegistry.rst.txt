MakerFactoryRegistry
====================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class MakerFactoryRegistry extends PlayerFactoryRegistry

   Estensione di \ ``PlayerFactoryRegistry``\  per poter contenere informazioni circa le implementazioni di \ ``MakerFactory``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
MakerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public MakerFactoryRegistry(String path) throws BadRegistryException
   :outertype: MakerFactoryRegistry

   :param path: associato al file da cui recuperare le informazioni sulle classi da caricare dinamicamente
   :throws BadRegistryException: in caso le istanze caricate non siano appartenenti a classi implementazione di \ ``MakerFactory``\


BreakerFactoryRegistry
======================

.. java:package:: it.unicam.cs.pa.mastermind.factories
   :noindex:

.. java:type:: public class BreakerFactoryRegistry extends PlayerFactoryRegistry

   Estensione di \ ``PlayerFactoryRegistry``\  per poter contenere informazioni circa le implementazioni di \ ``BreakerFactory``\ .

   :author: Francesco Pio Stelluti, Francesco Coppola

Constructors
------------
BreakerFactoryRegistry
^^^^^^^^^^^^^^^^^^^^^^

.. java:constructor:: public BreakerFactoryRegistry(String path) throws BadRegistryException
   :outertype: BreakerFactoryRegistry

   :param path: associato al file da cui recuperare le informazioni sulle classi da caricare dinamicamente
   :throws BadRegistryException: in caso le istanze caricate non siano appartenenti a classi implementazione di \ ``BreakerFactory``\


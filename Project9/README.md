# MediLabo Solution. 

Outil de détection de risque de diabète sur les patients à risques. 
Architecture en microservice, au nombre de cinq microservices indépents. 

# Prérequis. 

## Avant de débuter, s'assurer que tous les logiciels suivants sont installés sur la machine : 
  -- Docker. //
  -- Le projet. 

# Configuration des ports. 
## Ports utilisés : 
  9010 : project9 //
  9011 : gateway  //
  8888 : patientMService  //
  9003 : NotesMServices //
  9002 : AssessmentMService  //
  27017 : mongodb

# Connexion à l'application. 
  ##Démarrer l'application avec la commande :
    docker-compose up

  ## Identifiants de connexion :
  username  //
  password

# Recommandation pour l'utilisation du Green Code. 
  Réduire l'utilisation de certaines dépendances pour alléger le projet, et l'imiter son empreinte. 
  Programmer des logiciels qui limitent la consommation d’énergie en mettant en veille le périphérique non utilisé. 
  Ne pas surcharger le code en boucle qui peuvent être synthétisées autrement, et plus efficacement. 
  Rendre ce logiciel évolutif de manière simple, sans qu'une refont totale soit nécessaire à chaque mise à jour. 
  

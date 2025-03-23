GESTION DES EXAMENS

Ce projet est une application de gestion des examens Il permet de gérer les examens, les étudiants et leurs inscriptions aux examens. L'application est développée en Java avec une base de données MySQL pour la persistance des données.

Fonctionnalités
Ajouter/Supprimer un examen : Permet de créer ou de supprimer un examen.

Inscrire un étudiant à un examen : Permet d'inscrire un étudiant à un examen.

Filtrer les examens par matière : Permet de lister les examens en fonction de la matière.

Rechercher un étudiant inscrit à un examen : Permet de rechercher les étudiants inscrits à un examen donné.

Structure de la Base de Données
La base de données MySQL est composée des tables suivantes :

Tables
Examen : Contient les informations sur les examens.

Étudiant : Contient les informations sur les étudiants.

InscriptionExamen : Contient les informations sur les inscriptions des étudiants aux examens.

Schéma de la Base de Données                                                                
CREATE TABLE Examen (

    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    
    matiere VARCHAR(50) NOT NULL,
    
    date DATE NOT NULL,
    
    salle VARCHAR(50) NOT NULL
);

CREATE TABLE Étudiant (

    id(11) INT AUTO_INCREMENT PRIMARY KEY,
    
    nom VARCHAR(50) NOT NULL,
    
    prénom VARCHAR(50) NOT NULL,
    
    email VARCHAR(80) NOT NULL UNIQUE
);

CREATE TABLE InscriptionExamen (

    examen_id(11) INT NOT NULL,
    
    etudiant_id(11) INT NOT NULL,
    
    FOREIGN KEY (examen_id) REFERENCES Examen(id),
    
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id)
);

Technologies et outils utilisés dans le projet
1. Langage de programmation
Java : Langage principal pour le développement de l'application, permettant une gestion robuste de la logique métier et une intégration facile avec des bases de données et des interfaces graphiques.

2. Interface graphique (UI)
Java Swing : Framework utilisé pour créer une interface utilisateur interactive et intuitive . Swing est intégré directement à Java et: Framework utilisé pour créer une interface utilisateur interactive et intuitive. Swing est intégré directement à Java et permet de concevoir des fenêtres, des boutons, des menus et autres éléments graphiques.

3. Base de données
MySQL : Système de gestion de base de données relationnelle utilisé pour stocker les informations relatives aux examens , étudiants , et: Système de gestion de base de données relationnelle utilisé pour stocker les informations relatives aux examens, étudiants et inscriptions. MySQL est populaire pour sa simplicité et sa fiabilité.

phpMyAdmin : Outil web pour gérer MySQL, offrant une interface graphique pour interagir avec la base de données, effectuer des requêtes SQL et gérer les structures de données.

4. Bibliothèque pour Le graphe
JFreeChart : Bibliothèque Java pour créer des graphiques comme des histogrammes, des courbes ou des camemberts. Utilisée pour visualiser des données telles que le nombre d'étudiants inscrits par examen ou d'autres statistiques.
5. Outils de développement
NetBeans : IDE Java pour le développement, qui fournit des outils intégrés pour gérer le code, déboguer, et travailler avec des interfaces graphiques et des bases de données.

MagicDraw : Outil de modélisation UML pour la création de diagrammes de classes, de cas d'utilisation, et d'autres artefacts de conception logicielle. Il permet de visualiser la structure de l'application avant de commencer le développement.

6. Accès aux données
JDBC (Java Database Connectivity) : API Java utilisée pour connecter l'application à la base de données MySQL, permettant l'exécution de requêtes SQL pour ajouter, supprimer, ou modifier des données dans la base de données.

Diagramme de classe

![Image](https://github.com/user-attachments/assets/b113f602-608c-40dc-9957-7b048ac5a5ee)


Diagramme de cas d'utilisation 

![Image](https://github.com/user-attachments/assets/fd92ac72-583f-4036-a9f3-81e233b39263)
Demo Video
https://github.com/user-attachments/assets/ffc427fe-000f-45fb-a8dd-7646e2ec706c



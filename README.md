
![Image](https://github.com/user-attachments/assets/039d5bfb-3a6f-48f6-a3d7-08f45f9e330a)

GESTION DES EXAMENS

Contexte

Dans le cadre de la gestion des examens au sein d'une institution académique, il est essentiel de disposer d'un outil efficace pour le suivi des examens, des étudiants et de leurs inscriptions. Cet outil permettra de centraliser les informations relatives aux examens, aux étudiants et aux salles, facilitant ainsi l'organisation, la supervision et la production de rapports précis.

Problématique

Actuellement, la gestion des examens est réalisée de manière fragmentée, utilisant des méthodes manuelles ou des outils disparates. Cela entraîne des difficultés dans la gestion des informations, la communication entre les acteurs et la production de rapports précis. Par exemple :

Les inscriptions des étudiants ne sont pas centralisées.

La recherche d'informations spécifiques (comme les examens par matière ou les étudiants inscrits) est laborieuse.
Le suivi des statistiques (comme le nombre d'étudiants inscrits par examen) est inexistant ou manuel.

Objectifs

Centraliser les informations :
Regrouper toutes les données relatives aux examens, aux étudiants et aux inscriptions dans une base de données unique.

Faciliter la gestion :
Offrir une interface conviviale pour la création, la modification et la suppression des examens et des inscriptions.

Améliorer le suivi :
Permettre aux administrateurs de suivre les inscriptions des étudiants et de générer des rapports.

Optimiser la recherche :
Permettre une recherche efficace des examens par matière et un filtrage des étudiants inscrits.

Tables
Examen : Contient les informations sur les examens.

Étudiant : Contient les informations sur les étudiants.

InscriptionExamen : Contient les informations sur les inscriptions des étudiants aux examens.

Script Base de Donnees                                                              
-- Table Examen
CREATE TABLE Examen (

    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    
    matiere VARCHAR(50) NOT NULL,
    
    date DATE NOT NULL,
    
    salle VARCHAR(50) NOT NULL
);

-- Table Étudiant
CREATE TABLE Etudiant (

    id INT(11) AUTO_INCREMENT PRIMARY KEY,
    
    nom VARCHAR(50) NOT NULL,
    
    prenom VARCHAR(50) NOT NULL,
    
    email VARCHAR(80) NOT NULL UNIQUE
);

-- Table InscriptionExamen
CREATE TABLE InscriptionExamen (

    examen_id INT(11) NOT NULL,
    
    etudiant_id INT(11) NOT NULL,
    
    PRIMARY KEY (examen_id, etudiant_id),
    
    FOREIGN KEY (examen_id) REFERENCES Examen(id) ON DELETE CASCADE,
    
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id) ON DELETE CASCADE
);

Technologies et outils utilisés dans le projet

. Langage de programmation

Java : Langage principal pour le développement de l'application, permettant une gestion robuste de la logique métier et une intégration facile avec des bases de données et des interfaces graphiques.

. Interface graphique (UI)

Java Swing : Framework utilisé pour créer une interface utilisateur interactive et intuitive . Swing est intégré directement à Java et: Framework utilisé pour créer une interface utilisateur interactive et intuitive. Swing est intégré directement à Java et permet de concevoir des fenêtres, des boutons, des menus et autres éléments graphiques.

. Base de données

MySQL : Système de gestion de base de données relationnelle utilisé pour stocker les informations relatives aux examens , étudiants , et: Système de gestion de base de données relationnelle utilisé pour stocker les informations relatives aux examens, étudiants et inscriptions. MySQL est populaire pour sa simplicité et sa fiabilité.

phpMyAdmin : Outil web pour gérer MySQL, offrant une interface graphique pour interagir avec la base de données, effectuer des requêtes SQL et gérer les structures de données.

. Bibliothèque pour Le graphe

JFreeChart : Bibliothèque Java pour créer des graphiques comme des histogrammes, des courbes ou des camemberts. Utilisée pour visualiser des données telles que le nombre d'étudiants inscrits par examen ou d'autres statistiques.
. Outils de développement
NetBeans : IDE Java pour le développement, qui fournit des outils intégrés pour gérer le code, déboguer, et travailler avec des interfaces graphiques et des bases de données.

MagicDraw : Outil de modélisation UML pour la création de diagrammes de classes, de cas d'utilisation, et d'autres artefacts de conception logicielle. Il permet de visualiser la structure de l'application avant de commencer le développement.

. Accès aux données

JDBC (Java Database Connectivity) : API Java utilisée pour connecter l'application à la base de données MySQL, permettant l'exécution de requêtes SQL pour ajouter, supprimer, ou modifier des données dans la base de données.

Architecture du Projet : Gestion des Examens

 Couches Principales

UI (Java Swing) :

Fenêtres pour gérer examens, étudiants, inscriptions et visualiser les données.

Logique Métier (Java) :

Services pour gérer examens, étudiants, inscriptions et statistiques.

Base de Données (MySQL) :

Tables : Examen, Étudiant, InscriptionExamen.

Accès via JDBC.

Visualisation (JFreeChart) :

Graphique (Bar chart) : Nombre d'étudiants inscrits par examen.

Diagramme de classe

![Image](https://github.com/user-attachments/assets/b113f602-608c-40dc-9957-7b048ac5a5ee)


Diagramme de cas d'utilisation 

![Image](https://github.com/user-attachments/assets/fd92ac72-583f-4036-a9f3-81e233b39263)


Demo Video
https://github.com/user-attachments/assets/ffc427fe-000f-45fb-a8dd-7646e2ec706c



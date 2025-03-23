Gestion des Examens 
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
    date_inscription DATE NOT NULL,
    FOREIGN KEY (examen_id) REFERENCES Examen(id),
    FOREIGN KEY (etudiant_id) REFERENCES Étudiant(id)
);
Diagramme de classe 
![Image](https://github.com/user-attachments/assets/b113f602-608c-40dc-9957-7b048ac5a5ee)

Diagramme de cas d'utilisation 
![Image](https://github.com/user-attachments/assets/fd92ac72-583f-4036-a9f3-81e233b39263)


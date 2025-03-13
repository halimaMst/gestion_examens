/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Etudiant;
import beans.Examen;
import beans.InscriptionExamen;
import Services.EtudiantService;
import Services.ExamenService;
import Services.InscriptionExamenService;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author adhmin
 */
public class Test {
    public static void main(String[] args) {

        ExamenService examenService = new ExamenService();
        EtudiantService etudiantService = new EtudiantService();
        InscriptionExamenService inscriptionExamenService = new InscriptionExamenService();

        System.out.println("=== Ajout des examens ===");
        examenService.create(new Examen("Mathématiques", new Date(System.currentTimeMillis()), "Salle A1"));
        examenService.create(new Examen("Physique", new Date(System.currentTimeMillis()), "Salle B2"));
        examenService.create(new Examen("Informatique", new Date(System.currentTimeMillis()), "Salle C3"));

        System.out.println("\n=== Liste des examens ===");
        List<Examen> examens = examenService.findAll();
        for (Examen e : examens) {
            System.out.println("ID: " + e.getId() + " - Matière: " + e.getMatiere() + " - Date: " + e.getDate() + " - Salle: " + e.getSalle());
        }

        System.out.println("\n=== Suppression d'un examen ===");
        Examen examenToDelete = examenService.findById(1);
        if (examenToDelete != null) {
            boolean isDeleted = examenService.delete(examenToDelete);
            if (isDeleted) {
                System.out.println("Examen supprimé : " + examenToDelete.getMatiere());
            } else {
                System.out.println("La suppression de l'examen a échoué.");
            }
        } else {
            System.out.println("Aucun examen trouvé avec l'ID : 1");
        }

        System.out.println("\n=== Liste des examens après suppression ===");
        examens = examenService.findAll();
        for (Examen e : examens) {
            System.out.println("ID: " + e.getId() + " - Matière: " + e.getMatiere() + " - Date: " + e.getDate() + " - Salle: " + e.getSalle());
        }

        System.out.println("\n=== Ajout des étudiants ===");
        etudiantService.create(new Etudiant("Miss", "Abdo", "MissAbdo@example.com"));
        etudiantService.create(new Etudiant("Marghoub", "Abla", "MarghoubAbla@example.com"));

        System.out.println("\n=== Liste des étudiants ===");
        List<Etudiant> etudiants = etudiantService.findAll();
        for (Etudiant e : etudiants) {
            System.out.println("ID: " + e.getId() + " - Nom: " + e.getNom() + " - Prénom: " + e.getPrenom() + " - Email: " + e.getEmail());
        }

        System.out.println("\n=== Inscription des étudiants aux examens ===");
        Examen examen1 = examenService.findById(2);
        Examen examen2 = examenService.findById(3);
        Etudiant etudiant1 = etudiantService.findById(1);
        Etudiant etudiant2 = etudiantService.findById(2);

        if (examen1 != null && etudiant1 != null) {
            boolean isInscribed = inscriptionExamenService.create(new InscriptionExamen(examen1, etudiant1));
            if (isInscribed) {
                System.out.println("Inscription réussie pour l'étudiant " + etudiant1.getNom() + " à l'examen " + examen1.getMatiere());
            } else {
                System.out.println("Échec de l'inscription pour l'étudiant " + etudiant1.getNom() + " à l'examen " + examen1.getMatiere());
            }
        } else {
            System.out.println("Examen ou étudiant non trouvé pour l'inscription 1.");
        }

        if (examen2 != null && etudiant2 != null) {
            boolean isInscribed = inscriptionExamenService.create(new InscriptionExamen(examen2, etudiant2));
            if (isInscribed) {
                System.out.println("Inscription réussie pour l'étudiant " + etudiant2.getNom() + " à l'examen " + examen2.getMatiere());
            } else {
                System.out.println("Échec de l'inscription pour l'étudiant " + etudiant2.getNom() + " à l'examen " + examen2.getMatiere());
            }
        } else {
            System.out.println("Examen ou étudiant non trouvé pour l'inscription 2.");
        }

        System.out.println("\n=== Liste des inscriptions ===");
        List<InscriptionExamen> inscriptions = inscriptionExamenService.findAll();
        for (InscriptionExamen i : inscriptions) {
            System.out.println("Examen: " + i.getExamen().getMatiere() + " - Étudiant: " + i.getEtudiant().getNom() + " " + i.getEtudiant().getPrenom());
        }

        System.out.println("\n=== Filtrage des examens par matière ===");
        String matiereRecherchee = "Physique";
        System.out.println("Examens de la matière : " + matiereRecherchee);
        for (Examen e : examens) {
            if (e.getMatiere().equals(matiereRecherchee)) {
                System.out.println("ID: " + e.getId() + " - Matière: " + e.getMatiere() + " - Date: " + e.getDate() + " - Salle: " + e.getSalle());
            }
        }

        System.out.println("\n=== Recherche des étudiants inscrits à un examen ===");
        int examenId = 2;
        System.out.println("Étudiants inscrits à l'examen (ID: " + examenId + ") :");
        for (InscriptionExamen i : inscriptions) {
            if (i.getExamen().getId() == examenId) {
                System.out.println("ID: " + i.getEtudiant().getId() + " - Nom: " + i.getEtudiant().getNom() + " - Prénom: " + i.getEtudiant().getPrenom());
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import connexion.Connexion;
import java.sql.Date;
/**
 *
 * @author adhmin
 */
public class InscriptionExamen {

    private Examen examen;
    private Etudiant etudiant;

    
    public InscriptionExamen(Examen examen, Etudiant etudiant) {
        this.examen = examen;
        this.etudiant = etudiant;

    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

}

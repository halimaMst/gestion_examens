/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.sql.Date;

public class Examen {

    private int id;
    private String matiere;
    private Date date;
    private String salle;

 
    public Examen(int id, String matiere, Date date, String salle) {
        this.id = id;
        this.matiere = matiere;
        this.date = date;
        this.salle = salle;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

}
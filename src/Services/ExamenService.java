/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import beans.dao.IDao;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Examen;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;



/**
 *
 * @author adhmin
 */
public class ExamenService implements IDao<Examen>{

    private Connexion connexion;
  
    

    public ExamenService() {
        connexion = Connexion.getInstance();
      
    }

     public boolean create(Examen o) {
        String req = "insert into Examen (id,matiere,date,salle) values (null, ?, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getMatiere());
            ps.setDate(3, new Date(o.getDate().getTime()));
            ps.setString(3, o.getSalle());
      
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Examen o) {
      String req = "delete from Etudiant where id = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Examen o) {
        String req = "UPDATE Examen SET matiere = ?, date = ?, salle = ? WHERE id = ?";
    try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
        ps.setString(1, o.getMatiere());
         ps.setDate(3, new Date(o.getDate().getTime()));
        ps.setString(3, o.getSalle());
        ps.setInt(4, o.getId());
        int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la mise à jour de l'examen : " + ex.getMessage());
        }
        return false;
    }

    
}
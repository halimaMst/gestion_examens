/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dao.IDao;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.Examen;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adhmin
 */
public class ExamenService implements IDao<Examen> {

    private Connexion connexion;

    public ExamenService() {
        connexion = Connexion.getInstance();

    }

    @Override
    public boolean create(Examen o) {
        String req = "INSERT INTO Examen (matiere, date, salle) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getMatiere());
            ps.setDate(2, new java.sql.Date(o.getDate().getTime()));
            ps.setString(3, o.getSalle());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la création de l'examen : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Examen o) {
        String req = "DELETE FROM Examen WHERE id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {

            if (o == null || o.getId() <= 0) {
                System.out.println("Erreur : ID d'examen invalide.");
                return false;
            }

            ps.setInt(1, o.getId());

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Examen supprimé : " + o.getMatiere() + " (ID: " + o.getId() + ")");
                return true;
            } else {
                System.out.println("Aucun examen trouvé avec l'ID : " + o.getId());
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression de l'examen (ID: " + o.getId() + ") : " + ex.getMessage());
            return false;
        }
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

    @Override

    public Examen findById(int id) {
        String req = "SELECT * FROM Examen WHERE id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Examen(
                            rs.getInt("id"),
                            rs.getString("matiere"),
                            rs.getDate("date"),
                            rs.getString("salle")
                    );
                }
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la recherche de l'examen par ID : " + ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Examen> findAll() {
        List<Examen> examens = new ArrayList<>();
        String req = "SELECT * FROM Examen";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                examens.add(new Examen(
                        rs.getInt("id"),
                        rs.getString("matiere"),
                        rs.getDate("date"),
                        rs.getString("salle")
                ));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la récupération de tous les examens : " + ex.getMessage());
        }

        return examens;
    }

}

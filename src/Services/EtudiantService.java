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
import beans.Etudiant;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adhmin
 */
public class EtudiantService implements IDao<Etudiant> {

    private Connexion connexion;

    public EtudiantService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Etudiant etudiant) {
        String req = "INSERT INTO Etudiant (nom, prenom, email) VALUES (?, ?, ?)";
        try {
            String checkReq = "SELECT id FROM Etudiant WHERE email = ?";
            PreparedStatement checkPs = connexion.getCn().prepareStatement(checkReq);
            checkPs.setString(1, etudiant.getEmail());
            ResultSet rs = checkPs.executeQuery();
            if (rs.next()) {
                System.out.println("Erreur : L'email " + etudiant.getEmail() + " existe déjà.");
                return false;
            }
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la création de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Etudiant o) {
        String req = "DELETE FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, o.getId());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la suppression de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Etudiant o) {
        String req = "UPDATE Etudiant SET nom = ?, prenom = ?, email = ? WHERE id = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la mise à jour de l'étudiant : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public Etudiant findById(int id) {
        String req = "select * from Etudiant where id  = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String req = "select * from Etudiant";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etudiants;
    }

}

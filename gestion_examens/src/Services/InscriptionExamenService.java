/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import beans.Examen;
import beans.Etudiant;
import beans.InscriptionExamen;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adhmin
 */
public class InscriptionExamenService implements IDao<InscriptionExamen> {

    private Connexion connexion;
    private ExamenService examenService;
    private EtudiantService etudiantService;

    public InscriptionExamenService() {
        connexion = Connexion.getInstance();
        examenService = new ExamenService();
        etudiantService = new EtudiantService();
    }

    @Override
    public boolean create(InscriptionExamen inscription) {
        String req = "insert into InscriptionExamen (examen_id, etudiant_id) values (?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, inscription.getExamen().getId());
            ps.setInt(2, inscription.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'inscription : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(InscriptionExamen o) {
        String req = "DELETE FROM InscriptionExamen WHERE examen_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getExamen().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override

    public boolean update(InscriptionExamen o) {
        String req;
        req = "UPDATE InscriptionExamen SET WHERE examen_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);

            ps.setInt(2, o.getExamen().getId());
            ps.setInt(3, o.getEtudiant().getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public InscriptionExamen findById(int id) {

//on ne peut pas appliquer cette méthode vu qu'on a pas d'id dans la classe d'association
        return null;
    }

    @Override
    public List<InscriptionExamen> findAll() {
        List<InscriptionExamen> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM InscriptionExamen";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Examen examen = examenService.findById(rs.getInt("examen_id"));
                Etudiant etudiant = etudiantService.findById(rs.getInt("etudiant_id"));

                if (examen != null && etudiant != null) {
                    inscriptions.add(new InscriptionExamen(examen, etudiant));
                } else {
                    System.out.println("Avertissement : Examen ou étudiant non trouvé pour l'inscription ID " + rs.getInt("id"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des inscriptions : " + ex.getMessage());
        }
        return inscriptions;
    }

}

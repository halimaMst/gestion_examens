/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Utilisateur;
import connexion.Connexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author adhmin
 */
public class UtilisateurService {

    private Connexion connexion;

    public UtilisateurService() {
        connexion = Connexion.getInstance();
    }

    public boolean addUtilisateur(Utilisateur utilisateur) {
        String req = "INSERT INTO user (login, password) VALUES (?, SHA1(?))";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, utilisateur.getLogin());
            ps.setString(2, utilisateur.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'ajout de l'utilisateur : " + ex.getMessage());
        }
        return false;
    }

    public Utilisateur findUtilisateurByLogin(String login) {
        String req = "SELECT login, password FROM user WHERE login = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Utilisateur(rs.getString("login"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la recherche de l'utilisateur : " + ex.getMessage());
        }
        return null;
    }

    public boolean authenticate(String login, String password) {
        String req = "SELECT * FROM user WHERE login = ? AND password = SHA1(?)";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de l'authentification : " + ex.getMessage());
        }
        return false;
    }

    public boolean changerMotDePasse(String login, String nouveauMotDePasse) {
        String req = "UPDATE user SET password = SHA1(?) WHERE login = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, nouveauMotDePasse);
            ps.setString(2, login);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("Erreur lors du changement de mot de passe : " + ex.getMessage());
        }
        return false;
    }

    public boolean checkUtilisateurExists(String login) {
        String req = "SELECT 1 FROM user WHERE login = ?";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la vérification de l'utilisateur : " + ex.getMessage());
        }
        return false;
    }
}

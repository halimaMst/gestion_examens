/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Utilisateur;

/**
 *
 * @author adhmin
 */
public interface IUtilisateurDao {

    boolean addUtilisateur(Utilisateur user);

    Utilisateur findUtilisateurByLogin(String login);

    boolean authenticate(String login, String password);
}

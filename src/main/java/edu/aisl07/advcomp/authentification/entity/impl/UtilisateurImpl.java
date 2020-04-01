package edu.aisl07.advcomp.authentification.entity.impl;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import edu.aisl07.advcomp.authentification.entity.Role;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;

/**
 * Utilisateur de l'application AdvComp
 */
@Entity
public class UtilisateurImpl implements Utilisateur, Serializable  {

	private static final long serialVersionUID = 1L;
	/**
	 * Identifiant de conexion pour l'utilisateur
	 */
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
	private String login;
	
	/**
	 * Mot e passe de l'utilisateur
	 */
	private String password;
	
	/**
	 * Nom de l'utilisateur
	 */
	private String nom;
	
	/**
	 * Indicateur d'activit� pour autoriser ou non
	 * la connexion de cet utilisateur
	 */
	private Boolean actif;
	
	/**
	 * Role attribu� � l'utilisateur
	 */
	private Role role;
	
	public UtilisateurImpl() {
	}

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public Boolean getActif() {
		return actif;
	}

	@Override
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public void setRole(Role role) {
		this.role = role;
	}

}

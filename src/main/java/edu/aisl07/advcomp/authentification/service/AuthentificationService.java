package edu.aisl07.advcomp.authentification.service;

/**
 * Service dédié à l'authentification des utilisateurs  
 */
public interface AuthentificationService {

	/**
	 * Vérifie qu'un utilisateur avec ce login et ce password existe
	 * et qu'il est autorisé à se connecter.
	 * 
	 * @param login
	 * @param password
	 * @return True si l'utilisateur est autorisé à ce connecter et false dans les autres cas
	 */
	public Boolean authentifier(String login, String password);
		
}

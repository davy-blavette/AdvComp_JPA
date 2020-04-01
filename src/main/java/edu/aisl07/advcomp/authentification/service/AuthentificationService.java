package edu.aisl07.advcomp.authentification.service;

/**
 * Service d�di� � l'authentification des utilisateurs  
 */
public interface AuthentificationService {

	/**
	 * V�rifie qu'un utilisateur avec ce login et ce password existe
	 * et qu'il est autoris� � se connecter.
	 * 
	 * @param login
	 * @param password
	 * @return True si l'utilisateur est autoris� � ce connecter et false dans les autres cas
	 */
	public Boolean authentifier(String login, String password);
		
}

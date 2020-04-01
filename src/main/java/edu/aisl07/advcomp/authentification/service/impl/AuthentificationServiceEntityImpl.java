package edu.aisl07.advcomp.authentification.service.impl;

import com.google.inject.Inject;

import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.authentification.service.AuthentificationService;
import edu.aisl07.advcomp.fmk.AdvCompServiceLocator;

public class AuthentificationServiceEntityImpl implements AuthentificationService {

	/**
	 * Dépendance vers UtilisateurDao
	 */
	@Inject // (injection par propriété)
	private UtilisateurDao utilisateurDao;
		
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
	protected UtilisateurDao getUtilisateurDao() {
		if(utilisateurDao == null) {
			utilisateurDao = AdvCompServiceLocator.getInstance().getUtilisateurDao();
		}
		return utilisateurDao;
	}

	public AuthentificationServiceEntityImpl() {
	}

	@Override
	public Boolean authentifier(String login, String password) {
		Utilisateur utilisateur = getUtilisateurDao().retrieve(login);
		return utilisateur != null 
				&& utilisateur.getActif()				
				&& utilisateur.getPassword().equals(password);
	}

}

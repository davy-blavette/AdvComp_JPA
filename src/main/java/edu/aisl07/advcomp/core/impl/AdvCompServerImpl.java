package edu.aisl07.advcomp.core.impl;

import com.google.inject.Inject;
import com.google.inject.Provider;

import edu.aisl07.advcomp.AdvCompException;
import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.authentification.service.AuthentificationService;
import edu.aisl07.advcomp.core.AdvCompServer;
import edu.aisl07.advcomp.core.AdvCompService;
import edu.aisl07.advcomp.core.AdvCompServiceFactory;
import edu.aisl07.advcomp.fmk.AdvCompServiceLocator;

public class AdvCompServerImpl implements AdvCompServer {

	
	@Inject // (injection par propri�t� d'un fournisseur d'instances)
	protected Provider<AdvCompService> advCompServiceProvider;
	
	/**
	 * D�pendance vers service Authentification
	 */
	protected AuthentificationService authentificationService;
	
	protected AuthentificationService getAuthentificationService() {
		if(authentificationService == null) {
			authentificationService = AdvCompServiceLocator.getInstance().getAuthentificationService();
		}
		return authentificationService;
	}
	
	@Inject // (injection par Setter)
	public void setAuthentificationService(AuthentificationService authentificationService) {
		this.authentificationService = authentificationService;
	}

	/**
	 * D�pendance vers UtilisateurDao
	 */
	protected UtilisateurDao utilisateurDao;
	
	protected UtilisateurDao getUtilisateurDao() {
		if(utilisateurDao == null) {
			utilisateurDao = AdvCompServiceLocator.getInstance().getUtilisateurDao();
		}
		return utilisateurDao;
	}

	@Inject // (injection par Setter)
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
		
	
	protected AdvCompServiceFactory advCompServiceFactory;
	protected AdvCompServiceFactory getAdvCompServiceFactory() {
		return advCompServiceFactory;
	}
	public void setAdvCompServiceFactory(AdvCompServiceFactory advCompServiceFactory) {
		this.advCompServiceFactory = advCompServiceFactory;
	}
	
	
	
	
	public AdvCompServerImpl() {
	}

	@Override
	public AdvCompService connect(String login, String password) throws AdvCompException {
		// Tentative d'authentification
		Boolean authentifie = getAuthentificationService().authentifier(login, password);
		if(authentifie) {
			// Authentifi� : on cr�e et retourne son service advComp au client
			Utilisateur client = getUtilisateurDao().retrieve(login);
			if(client == null) {
				throw new AdvCompException("Un probl�me avec votre compte nous emp�che....");
			}
			
			//XXX Peut mieux faire  !!!
			//new AdvComServiceImpl(client);
			//AdvCompService advCompService = advCompServiceFactory.creerAdvCompServicePourCeClient(client); 
			
			//AdvCompService advCompService = AdvCompServiceLocator.getInstance().getAdvcompService(client);

			// Obtention d'une instance dAdvCompService fournie par le provider
			AdvCompService advCompService = advCompServiceProvider.get();
			advCompService.setClient(client);
			
			// Retour � l'utilisateur
			return advCompService;
			
		} else {
			// Non authentifi�
			throw new AdvCompException("Echec Authentification.");
		}
	}
	


}

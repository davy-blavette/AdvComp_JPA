package edu.aisl07.advcomp.fmk;

import java.lang.reflect.Constructor;

import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.authentification.service.AuthentificationService;
import edu.aisl07.advcomp.calcul.Calculateur;
import edu.aisl07.advcomp.core.AdvCompServer;
import edu.aisl07.advcomp.core.AdvCompService;
import edu.aisl07.advcomp.facturation.dao.FactureDao;
import edu.aisl07.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl07.advcomp.facturation.service.FacturationService;

/**
 * Singleton fournisseur des services 
 * pour l'application AdvComp
 */
public class AdvCompServiceLocator {

	/**
	 * Le Singleton
	 */
	private static AdvCompServiceLocator instance;
	
	public static AdvCompServiceLocator getInstance() {
		if(instance == null) {
			instance = new AdvCompServiceLocator();
		}
		return instance;
	}
	
	private AdvCompServiceLocator() {
	}
	
	private AdvCompServer advCompServer;
	private UtilisateurDao utilisateurDao;
	private AuthentificationService authentificationService;
	private FacturationService facturationService;
	private HistoriqueOperationDao historiqueOperationDao;	
	private FactureDao factureDao;
	private Calculateur calculateur;

	/**
	 * Constructeur de la Classe d'implémentation de {@link AdvCompService}
	 */
	private Constructor<? extends AdvCompService> constructeurAdvCopmService;
			
	public AdvCompServer getAdvCompServer() {
		return advCompServer;
	}
	public void setAdvCompServer(AdvCompServer advCompServer) {
		this.advCompServer = advCompServer;
	}

	public void setAdvCompServiceClass(Class<? extends AdvCompService> advCompServiceClass) throws Exception {
		// On obtient et référence le constructeur de l'implémentation AdvCompService à utiliser
		constructeurAdvCopmService = advCompServiceClass.getConstructor(Utilisateur.class);
	}
	
	public AdvCompService getAdvcompService(Utilisateur client) {
		try {
			AdvCompService advCompServicePourLeClient = constructeurAdvCopmService.newInstance(client);
			return advCompServicePourLeClient;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}
	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}
	
	public AuthentificationService getAuthentificationService() {
		return authentificationService;
	}
	public void setAuthentificationService(AuthentificationService authentificationService) {
		this.authentificationService = authentificationService;
	}
	
	public FacturationService getFacturationService() {
		return facturationService;
	}
	public void setFacturationService(FacturationService facturationService) {
		this.facturationService = facturationService;
	}
	
	public FactureDao getFactureDao() {
		return factureDao;
	}
	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}
	
	public HistoriqueOperationDao getHistoriqueOperationDao() {
		return historiqueOperationDao;
	}
	public void setHistoriqueOperationDao(HistoriqueOperationDao historiqueOperationDao) {
		this.historiqueOperationDao = historiqueOperationDao;
	}
	
	public Calculateur getCalculateur() {
		return calculateur;
	}
	public void setCalculateur(Calculateur calculateur) {
		this.calculateur = calculateur;
	}
	
	
	
	
}

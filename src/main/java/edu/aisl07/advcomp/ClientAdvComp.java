package edu.aisl07.advcomp;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.dao.impl.UtilisateurDaoImpl;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.authentification.service.AuthentificationService;
import edu.aisl07.advcomp.authentification.service.impl.AuthentificationServiceEntityImpl;
import edu.aisl07.advcomp.calcul.Calculateur;
import edu.aisl07.advcomp.calcul.impl.CalculateurDebile;
import edu.aisl07.advcomp.calcul.impl.CalculateurSimple;
import edu.aisl07.advcomp.core.AdvCompServer;
import edu.aisl07.advcomp.core.AdvCompService;
import edu.aisl07.advcomp.core.AdvCompServiceFactory;
import edu.aisl07.advcomp.core.impl.AdvComServiceImpl;
import edu.aisl07.advcomp.core.impl.AdvCompServerImpl;
import edu.aisl07.advcomp.facturation.dao.FactureDao;
import edu.aisl07.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl07.advcomp.facturation.dao.impl.FactureDaoImpl;
import edu.aisl07.advcomp.facturation.dao.impl.HistoriqueOperationDaoImpl;
import edu.aisl07.advcomp.facturation.service.FacturationService;
import edu.aisl07.advcomp.facturation.service.impl.FacturationServiceImpl;
import edu.aisl07.advcomp.fmk.AdvCompServiceLocator;

public class ClientAdvComp {

	public static AdvCompServer initApp() {
		AdvCompServerImpl advCompServer = new AdvCompServerImpl();
		
		UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
		advCompServer.setUtilisateurDao(utilisateurDao);
		
		// D�finition Authentification service pour le AdvCompServer
		AuthentificationServiceEntityImpl authentificationService = new AuthentificationServiceEntityImpl();
		authentificationService.setUtilisateurDao(utilisateurDao);
		advCompServer.setAuthentificationService(authentificationService);

		
		// Cr�ation de la Factory de AdvCompService
		// POur cr�er et initialiser le AdvCompService avec les d�pendance
		// de notre choix
		AdvCompServiceFactory advCompServiceFactory = new AdvCompServiceFactory() {
			@Override
			public AdvCompService creerAdvCompServicePourCeClient(Utilisateur client) {
				// Cr�ation de l'AdvCompService Choisi
				AdvComServiceImpl advCompService = new AdvComServiceImpl(client);
				// On lui fournit ses d�pendances				
				// Le facturation service est pr�t pour l'AdvCompService 
				FacturationServiceImpl facturationService = new FacturationServiceImpl();
				facturationService.setFactureDao(new FactureDaoImpl());
				facturationService.setHistoriqueOperationDao(new HistoriqueOperationDaoImpl());
				advCompService.setFacturationService(facturationService);

				// Le Calculateur est pr�t mais c'est AdvCompService qui en a besoin ?
				Calculateur calculateur = new CalculateurSimple();
				advCompService.setCalculateur(calculateur);

				return advCompService;
			}
		};
		
		// On fournit la factory au serveur
		advCompServer.setAdvCompServiceFactory(advCompServiceFactory);
		
		return advCompServer;
	}
	
	public static AdvCompServer initAppV2() {
		AdvCompServerImpl advCompServer = new AdvCompServerImpl();
		
		UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
		advCompServer.setUtilisateurDao(utilisateurDao);
		
		// D�finition Authentification service pour le AdvCompServer
		AuthentificationServiceEntityImpl authentificationService = new AuthentificationServiceEntityImpl();
		authentificationService.setUtilisateurDao(utilisateurDao);
		advCompServer.setAuthentificationService(authentificationService);

		
		// Cr�ation de la Factory de AdvCompService
		// POur cr�er et initialiser le AdvCompService avec les d�pendance
		// de notre choix
		AdvCompServiceFactory advCompServiceFactory = new AdvCompServiceFactory() {
			@Override
			public AdvCompService creerAdvCompServicePourCeClient(Utilisateur client) {
				// Cr�ation de l'AdvCompService Choisi
				AdvComServiceImpl advCompService = new AdvComServiceImpl(client);
				// On lui fournit ses d�pendances				
				// Le facturation service est pr�t pour l'AdvCompService 
				FacturationServiceImpl facturationService = new FacturationServiceImpl();
				facturationService.setFactureDao(new FactureDaoImpl());
				facturationService.setHistoriqueOperationDao(new HistoriqueOperationDaoImpl());
				advCompService.setFacturationService(facturationService);

				// Le Calculateur est pr�t mais c'est AdvCompService qui en a besoin ?
				Calculateur calculateur = new CalculateurDebile();
				advCompService.setCalculateur(calculateur);

				return advCompService;
			}
		};
		
		// On fournit la factory au serveur
		advCompServer.setAdvCompServiceFactory(advCompServiceFactory);
		
		return advCompServer;
	}
	
	/**
	 * Initializer du servicelocator
	 * @throws Exception
	 */
	public static void initServiceLocator_V1() throws Exception {
		// Initialisativoidon du service Locator (Initializer)
		AdvCompServiceLocator.getInstance().setAdvCompServer(new AdvCompServerImpl());
		AdvCompServiceLocator.getInstance().setAdvCompServiceClass(AdvComServiceImpl.class);
		AdvCompServiceLocator.getInstance().setAuthentificationService(new AuthentificationServiceEntityImpl());
		AdvCompServiceLocator.getInstance().setCalculateur(new CalculateurSimple());
		AdvCompServiceLocator.getInstance().setFacturationService(new FacturationServiceImpl());
		AdvCompServiceLocator.getInstance().setFactureDao(new FactureDaoImpl());
		AdvCompServiceLocator.getInstance().setHistoriqueOperationDao(new HistoriqueOperationDaoImpl());
		AdvCompServiceLocator.getInstance().setUtilisateurDao(new UtilisateurDaoImpl());
	}
	
	public static AdvCompServer initAppV3_ServieLocator() {
		return AdvCompServiceLocator.getInstance().getAdvCompServer();
	}
	
	
	public static Injector initInjectionDependanceGuice_V1() {
		Module guiceModule = new Module() {

			// alimente les binding : Interface -> Implementation
			@Override
			public void configure(Binder binder) {
				binder.bind(AdvCompServer.class).to(AdvCompServerImpl.class).asEagerSingleton();
				binder.bind(AuthentificationService.class).to(AuthentificationServiceEntityImpl.class).asEagerSingleton();
				binder.bind(Calculateur.class).to(CalculateurDebile.class).asEagerSingleton();
				binder.bind(FacturationService.class).to(FacturationServiceImpl.class).asEagerSingleton();
				binder.bind(FactureDao.class).to(FactureDaoImpl.class).asEagerSingleton();
				binder.bind(HistoriqueOperationDao.class).to(HistoriqueOperationDaoImpl.class).asEagerSingleton();
				binder.bind(UtilisateurDao.class).to(UtilisateurDaoImpl.class).asEagerSingleton();
				binder.bind(AdvCompService.class).to(AdvComServiceImpl.class);								
			}
		};
		
		return Guice.createInjector(guiceModule);
		
	}
	
	public static void main(String[] args) {
		
		try {
			
			// Cr�ation du serveur
			AdvCompServer advCompServer = initInjectionDependanceGuice_V1().getInstance(AdvCompServer.class);
			
			// Connexion au serveur pour obtenir mon AdvCompService
			AdvCompService advCompService = advCompServer.connect("test", "secret");
			
			// Test de calcul 
			Double resultat = advCompService.faireCalculBasic(1d, 2d, "+");
			
			System.out.println(" 1 + 2 = " + resultat);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

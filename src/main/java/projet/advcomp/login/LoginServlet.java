package projet.advcomp.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.dao.impl.UtilisateurDaoImpl;
import edu.aisl07.advcomp.authentification.service.AuthentificationService;
import edu.aisl07.advcomp.authentification.service.impl.AuthentificationServiceEntityImpl;
import edu.aisl07.advcomp.calcul.Calculateur;
import edu.aisl07.advcomp.calcul.impl.CalculateurDebile;
import edu.aisl07.advcomp.core.AdvCompServer;
import edu.aisl07.advcomp.core.AdvCompService;
import edu.aisl07.advcomp.core.impl.AdvComServiceImpl;
import edu.aisl07.advcomp.core.impl.AdvCompServerImpl;
import edu.aisl07.advcomp.facturation.dao.FactureDao;
import edu.aisl07.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl07.advcomp.facturation.dao.impl.FactureDaoImpl;
import edu.aisl07.advcomp.facturation.dao.impl.HistoriqueOperationDaoImpl;
import edu.aisl07.advcomp.facturation.service.FacturationService;
import edu.aisl07.advcomp.facturation.service.impl.FacturationServiceImpl;

@WebServlet(name="/LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
	
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	
    	try {
			
    		// Création du serveur
    		AdvCompServer advCompServer = initInjectionDependanceGuice_V1().getInstance(AdvCompServer.class);
    		
    		// Connexion au serveur pour obtenir mon AdvCompService
    		AdvCompService advCompService = advCompServer.connect(request.getParameter("login"), request.getParameter("password"));
			
			// Test de calcul 
			Double resultat = advCompService.faireCalculBasic(1d, 2d, "+");
			
			System.out.println(" 1 + 2 = " + resultat);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

    	
    }
	
}

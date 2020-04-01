package projet.advcomp.facturation;

import java.io.IOException;
import java.sql.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.advcomp.facturation.Facturation;
import projet.advcomp.facturation.FacturationDao;

/**
 * Servlet implementation class FacturationServlet
 */
@WebServlet(name="/FacturationServlet", urlPatterns={"/facturation"})
public class FacturationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    // Injection DAO EJB:
    @EJB FacturationDao facturationDao;


    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Afficher la liste des factures:
        request.setAttribute("factures", facturationDao.getAllFactures());
        request.getRequestDispatcher("/facturation.jsp").forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Ajouter une facture:
        String numero = request.getParameter("numero");
        Date date = new Date(System.currentTimeMillis());

        Double montant = Double.valueOf((String) request.getParameter("montant"));
        String client = request.getParameter("client");
        
        if (numero != null)
        	facturationDao.persist(new Facturation(numero, date, montant, client));

        //Affiche les factures:
        doGet(request, response);
    }

}

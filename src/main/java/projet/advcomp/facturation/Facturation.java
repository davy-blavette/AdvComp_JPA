package projet.advcomp.facturation;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
Package Facturation utilisé pour test
Class Facturation
Class FacturationDao
Class FacturationServlet
*/

@Entity
public class Facturation implements Serializable {
	
	private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String numero;
    private Date date;
    private Double montant;
    private String client;
    
    // Constructors:
    public Facturation() {
    }

    public Facturation(String numero, Date date, Double montant, String client) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
        this.client = client;
    }

    // String Representation:
    @Override
    public String toString() {
        return "<div class='row mb-1'>"
        		+ "<div class='col-md-2'>" + client + "</div>"
        		+ "<div class='col-md-2'>" + numero + "</div>"
        		+ "<div class='col-md-2'>" + date + "</div>"
        		+ "<div class='col-md-2'>" + montant + "</div>"
        		+ "<div class='col-md-4'>"
           		+ "<button class='btn btn-warning btn-sm w-50' type='submit'>Update</button>"
        		+ "<button class='btn btn-danger btn-sm w-50' type='submit'>Del</button>"
        		+ "</div>"
        		+ "</div>";
    }
}

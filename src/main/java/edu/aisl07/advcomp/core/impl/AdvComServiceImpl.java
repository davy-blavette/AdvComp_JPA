package edu.aisl07.advcomp.core.impl;

import com.google.inject.Inject;

import edu.aisl07.advcomp.AdvCompException;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.calcul.Calculateur;
import edu.aisl07.advcomp.calcul.CalcultateurException;
import edu.aisl07.advcomp.core.AdvCompService;
import edu.aisl07.advcomp.facturation.service.FacturationService;
import edu.aisl07.advcomp.fmk.AdvCompServiceLocator;

public class AdvComServiceImpl implements AdvCompService {

	/**
	 * D�pendance vers le service de calcul
	 */
	@Inject
	protected Calculateur calculateur;
	
	public void setCalculateur(Calculateur calculateur) {
		this.calculateur = calculateur;
	}
	protected Calculateur getCalculateur() {
		if(calculateur == null) {
			calculateur = AdvCompServiceLocator.getInstance().getCalculateur();
		}
		return calculateur;
	}
	
	/**
	 * D�pendance vers le service de facturation pour historise
	 */
	protected FacturationService facturationService;

	@Inject
	public void setFacturationService(FacturationService facturationService) {
		this.facturationService = facturationService;
	}
	protected FacturationService getFacturationService() {
		if(facturationService == null) {
			facturationService = AdvCompServiceLocator.getInstance().getFacturationService();
		}
		return facturationService;
	}

	/**
	 * Client utilisateur du service
	 */
	private Utilisateur client;

	/**
	 * Valeurinterm�diaire durant un calcul chain�
	 */
	private Double valeurCourante;
	
	
	/**
	 * Etats des calcul chain�s pour contr�ler l'autorisation
	 * de r�aliser des actions
	 */
	protected static enum EtatCalculChaine {
		INACTIF,
		EN_COURS
	}
	private EtatCalculChaine etatCalculChaine = EtatCalculChaine.INACTIF;
	
	public AdvComServiceImpl() {
	}

	public AdvComServiceImpl(Utilisateur client) {
		this.setClient(client);
	}

	public Utilisateur getClient() {
		return client;
	}
	public void setClient(Utilisateur client) {
		this.client = client;
	}
	
	protected Double getValeurCourante() {
		return valeurCourante;
	}
	protected void setValeurCourante(Double valeurCourante) {
		this.valeurCourante = valeurCourante;
	}

	
	
	/**
	 * 
	 * @param f1
	 * @param f2
	 * @param operateur
	 * @return
	 */
	@Override
	public Double faireCalculBasic(Double f1, Double f2, String operateur) throws AdvCompException {
		try {
			// Calcul
			Double resultat;
			String descriptionOperation;
			switch (operateur) {
			case "+":
				descriptionOperation = f1 + "+" + f2;
				resultat = getCalculateur().additionner(f1, f2);
				break;
			case "-":
				descriptionOperation = f1 + "-" + f2;
				resultat = getCalculateur().soustraire(f1, f2);
				break;
			case "*":
				descriptionOperation = f1 + "*" + f2;
				resultat = getCalculateur().multiplier(f1, f2);
				break;
			case "/":
				descriptionOperation = f1 + "/" + f2;
				resultat = getCalculateur().diviser(f1, f2);
				break;
			default:
				throw new AdvCompException("Op�rateur " + operateur + " invalide.");
			}

			// Historisation pour facturer ult�rieurement
			getFacturationService().historiserOperation(client, descriptionOperation);

			// retour du r�sultat si tout c'est bien pass�
			return resultat;
						
		} catch (CalcultateurException e) {
			e.printStackTrace();
			throw new AdvCompException("Echec calcul basique", e);
		} catch (Exception e) {
			throw new AdvCompException("Erreur inattendue durant calcul basique", e);
		}

	}

	/**
	 * @throws AdvCompException 
	 * 
	 */
	@Override
	public void commencerCalculChaine() throws AdvCompException {
		if(etatCalculChaine != EtatCalculChaine.INACTIF) {
			throw new AdvCompException("Impossible de commencer une calcul chain�");
		}
		valeurCourante = 0d;
		etatCalculChaine =EtatCalculChaine.EN_COURS; 
	}
	
	/**
	 * @throws AdvCompException 
	 * 
	 */
	@Override
	public void faireCalculElement(Double f, String operateur) throws AdvCompException {
		if(etatCalculChaine != EtatCalculChaine.EN_COURS) {
			throw new AdvCompException("Action impossible, Aucun calcul chain� en cours");
		}
		valeurCourante = faireCalculBasic(valeurCourante, f, operateur);				
	}
	
	@Override
	public Double termineCalculChaine() throws AdvCompException {
		if(etatCalculChaine != EtatCalculChaine.EN_COURS) {
			throw new AdvCompException("Action impossible, Aucun calcul chain� en cours");
		}		
		etatCalculChaine =EtatCalculChaine.INACTIF; 
		return valeurCourante;		
	}



}

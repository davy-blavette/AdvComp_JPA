package edu.aisl07.advcomp.core;

import edu.aisl07.advcomp.AdvCompException;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;

public interface AdvCompService {

	/**
	 * Affectation du client associé
	 * @param client
	 */
	public void setClient(Utilisateur client);
	
	/**
	 * 
	 * @param f1
	 * @param f2
	 * @param operateur
	 * @return
	 */
	Double faireCalculBasic(Double f1, Double f2, String operateur) throws AdvCompException;

	/**
	 * @throws AdvCompException 
	 * 
	 */
	void commencerCalculChaine() throws AdvCompException;

	/**
	 * @throws AdvCompException 
	 * 
	 */
	void faireCalculElement(Double f, String operateur) throws AdvCompException;

	Double termineCalculChaine() throws AdvCompException;

}
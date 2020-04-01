package edu.aisl07.advcomp.core;

import edu.aisl07.advcomp.authentification.entity.Utilisateur;

public interface AdvCompServiceFactory {

	/**
	 * Crée et retourne une instance de {@link AdvCompService} pour le client.
	 * @param client
	 * @return
	 */
	public AdvCompService creerAdvCompServicePourCeClient(Utilisateur client);
	
}

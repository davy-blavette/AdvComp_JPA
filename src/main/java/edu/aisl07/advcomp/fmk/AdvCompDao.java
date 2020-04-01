package edu.aisl07.advcomp.fmk;

import java.util.List;

public interface AdvCompDao<ENTITY_TYPE, ID_TYPE> {

	/**
	 * Cr�ation de l'entit�
	 * @param entity
	 * @return
	 */
	public ENTITY_TYPE create(ENTITY_TYPE entity);
	
	/**
	 * Retourne l'entit� par son id 
	 * @param id
	 * @return
	 */
	public ENTITY_TYPE retrieve(ID_TYPE id);

	/**
	 * Mise � jour de l'entit�
	 * @param entity
	 * @return
	 */
	public ENTITY_TYPE update(ENTITY_TYPE entity);
	
	/**
	 * Suppression de l'entit�
	 * @param entity
	 * @return
	 */
	public void delete(ENTITY_TYPE entity);

	/**
	 * Retourne la liste de toutes les entit�s
	 * @return
	 */
	public List<ENTITY_TYPE> getAll();

	/**
	 * Retourne une nouvelle instance
	 * @return
	 */
	public ENTITY_TYPE getNew();
	
}

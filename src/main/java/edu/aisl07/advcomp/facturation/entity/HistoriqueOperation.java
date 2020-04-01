package edu.aisl07.advcomp.facturation.entity;

import java.util.Date;

public interface HistoriqueOperation {

	Long getId();
	void setId(Long id);
	
	/**
	 * @return the dateOperation
	 */
	Date getDateOperation();

	/**
	 * @param dateOperation the dateOperation to set
	 */
	void setDateOperation(Date dateOperation);

	/**
	 * @return the description
	 */
	String getDescription();

	/**
	 * @param description the description to set
	 */
	void setDescription(String description);

}
/**
 * 
 */
package edu.aisl07.advcomp.facturation.entity.impl;

import java.util.Date;

import edu.aisl07.advcomp.facturation.entity.HistoriqueOperation;

/**
 * @author Musa
 *
 */
public class HistoriqueOperationImpl implements HistoriqueOperation {

	private Long id;
	private Date dateOperation;
	private String description;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.facture.impl.HistoriqueOperation#getDateOperation()
	 */
	@Override
	public Date getDateOperation() {
		return dateOperation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.aisl07.advcomp.facture.impl.HistoriqueOperation#setDateOperation(java.
	 * util.Date)
	 */
	@Override
	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.facture.impl.HistoriqueOperation#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.aisl07.advcomp.facture.impl.HistoriqueOperation#setDescription(java.lang.
	 * String)
	 */
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

}

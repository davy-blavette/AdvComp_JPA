/**
 * 
 */
package edu.aisl07.advcomp.facturation.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aisl07.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl07.advcomp.facturation.entity.HistoriqueOperation;
import edu.aisl07.advcomp.facturation.entity.impl.HistoriqueOperationImpl;

/**
 * @author Musa
 *
 */
public class HistoriqueOperationDaoImpl implements HistoriqueOperationDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#create(java.lang.Object)
	 */
	@Override
	public HistoriqueOperation create(HistoriqueOperation entity) {
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#retrieve(java.lang.Object)
	 */
	@Override
	public HistoriqueOperation retrieve(Long id) {
//		if ("test".equals(id)) {
//			HistoriqueOperation historiqueOperation = this.getNew();
//			historiqueOperation.setDateOperation(new Date());
//			historiqueOperation.setDescription("Operation description...");
//			return historiqueOperation;
//		} else {
//			return null;
//		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#update(java.lang.Object)
	 */
	@Override
	public HistoriqueOperation update(HistoriqueOperation entity) {
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(HistoriqueOperation entity) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#getAll()
	 */
	@Override
	public List<HistoriqueOperation> getAll() {
		return new ArrayList<HistoriqueOperation>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.aisl07.advcomp.fmk.ADVCompDao#getNew()
	 */
	@Override
	public HistoriqueOperation getNew() {
		return new HistoriqueOperationImpl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.aisl07.advcomp.facture.dao.HistoriqueOperationDao#getHistoriquePeriode(
	 * java.util.Date, java.util.Date)
	 */
	@Override
	public List<HistoriqueOperation> getHistoriquePeriode(Date debut, Date fin) {
		return new ArrayList<HistoriqueOperation>();
	}

}

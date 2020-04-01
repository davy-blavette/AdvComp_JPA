package edu.aisl07.advcomp.facturation.service.impl;

import java.util.Date;

import com.google.inject.Inject;

import edu.aisl07.advcomp.AdvCompException;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.facturation.dao.FactureDao;
import edu.aisl07.advcomp.facturation.dao.HistoriqueOperationDao;
import edu.aisl07.advcomp.facturation.entity.HistoriqueOperation;
import edu.aisl07.advcomp.facturation.service.FacturationService;
import edu.aisl07.advcomp.fmk.AdvCompServiceLocator;

public class FacturationServiceImpl implements FacturationService {

	/**
	 * Dépendance vers HistoriqueOperationDao
	 */
	private HistoriqueOperationDao historiqueOperationDao;

	public void setHistoriqueOperationDao(HistoriqueOperationDao historiqueOperationDao) {
		this.historiqueOperationDao = historiqueOperationDao;
	}

	protected HistoriqueOperationDao getHistoriqueOperationDao() {
		if(historiqueOperationDao == null) {
			historiqueOperationDao = AdvCompServiceLocator.getInstance().getHistoriqueOperationDao();
		}
		return historiqueOperationDao;
	}
	
	/**
	 * Dépendance vers FactureDao
	 */
	private FactureDao factureDao;

	public void setFactureDao(FactureDao factureDao) {
		this.factureDao = factureDao;
	}

	protected FactureDao getFactureDao() {
		if(factureDao == null) {
			factureDao = AdvCompServiceLocator.getInstance().getFactureDao();
		}
		return factureDao;
	}
	
	public FacturationServiceImpl() {		
	}
	
	@Inject // (injection par constructeur)
	public FacturationServiceImpl(FactureDao factureDao, HistoriqueOperationDao historiqueOperationDao) {
		this.factureDao = factureDao;
		this.historiqueOperationDao = historiqueOperationDao;
	}

	@Override
	public void lancerFacturation(Date dateDebut, Date dateFin) throws AdvCompException {
		// TODO Auto-generated method stub

	}

	@Override
	public void historiserOperation(Utilisateur utilisateur, String description) throws AdvCompException {
		HistoriqueOperation historiqueOperation = getHistoriqueOperationDao().getNew();
		historiqueOperation.setDateOperation(new Date());
		historiqueOperation.setDescription(description);
		getHistoriqueOperationDao().create(historiqueOperation);
	}

}

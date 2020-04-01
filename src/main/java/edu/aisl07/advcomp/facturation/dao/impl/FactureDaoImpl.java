package edu.aisl07.advcomp.facturation.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.aisl07.advcomp.facturation.dao.FactureDao;
import edu.aisl07.advcomp.facturation.entity.Facture;
import edu.aisl07.advcomp.facturation.entity.impl.FactureImpl;

public class FactureDaoImpl implements FactureDao {

    public FactureDaoImpl() {

    }


    @Override
    public Facture getNew() {
        return new FactureImpl();
    }


	@Override
	public Facture create(Facture entity) {
		return entity;
	}


	@Override
	public Facture retrieve(String id) {
		return null;
	}


	@Override
	public Facture update(Facture entity) {
		return entity;
	}


	@Override
	public void delete(Facture entity) {
	}


	@Override
	public List<Facture> getAll() {
		return new ArrayList<Facture>();
	}

}

package edu.aisl07.advcomp.authentification.dao.impl;

import java.util.ArrayList;
import java.util.List;

import edu.aisl07.advcomp.authentification.dao.UtilisateurDao;
import edu.aisl07.advcomp.authentification.entity.Role;
import edu.aisl07.advcomp.authentification.entity.Utilisateur;
import edu.aisl07.advcomp.authentification.entity.impl.UtilisateurImpl;

public class UtilisateurDaoImpl implements UtilisateurDao {

	public UtilisateurDaoImpl() {
	}

	@Override
	public Utilisateur create(Utilisateur entity) {
		return entity;
	}

	@Override
	public Utilisateur retrieve(String login) {
		// Bouchon pour nos tests
		if("test".equals(login)) {
			Utilisateur utilisateur = getNew();
			utilisateur.setLogin("test");
			utilisateur.setPassword("secret");
			utilisateur.setNom("Utilisateur Test");
			utilisateur.setActif(true);
			utilisateur.setRole(Role.CLIENT);
			return utilisateur;
		} else {
			return null;			
		}
	}

	@Override
	public Utilisateur update(Utilisateur entity) {
		return entity;
	}

	@Override
	public void delete(Utilisateur entity) {
	}

	@Override
	public List<Utilisateur> getAll() {
		return new ArrayList<Utilisateur>();
	}

	@Override
	public Utilisateur getNew() {
		return new UtilisateurImpl();
	}

}

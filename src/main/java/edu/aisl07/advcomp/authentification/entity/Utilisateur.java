package edu.aisl07.advcomp.authentification.entity;

public interface Utilisateur {

	String getLogin();

	void setLogin(String login);

	String getPassword();

	void setPassword(String password);

	String getNom();

	void setNom(String nom);

	Boolean getActif();

	void setActif(Boolean actif);

	Role getRole();

	void setRole(Role role);

}
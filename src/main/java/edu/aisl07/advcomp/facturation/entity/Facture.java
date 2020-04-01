package edu.aisl07.advcomp.facturation.entity;

import java.util.Date;

import edu.aisl07.advcomp.authentification.entity.Utilisateur;

public interface Facture {

    String getNumero();

    void setNumero( String numero );

    Date getDate();

    void setDate( Date date );

    Double getMontant();

    void setMontant( Double montant );

    Utilisateur getClient();

    void setClient( Utilisateur utilisateur );

}

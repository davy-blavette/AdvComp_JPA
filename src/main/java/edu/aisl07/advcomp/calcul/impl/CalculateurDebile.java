/**
 * 
 */
package edu.aisl07.advcomp.calcul.impl;

import edu.aisl07.advcomp.calcul.Calculateur;
import edu.aisl07.advcomp.calcul.CalcultateurException;

/**
 * @author loict
 *
 */
public class CalculateurDebile implements Calculateur {

	
	@Override
	public double additionner(double f1, double f2) throws CalcultateurException {
		try {
			return 33;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalcultateurException("Echec additionner " + f1 + " " + f2 , e);
		}
	}

	
	@Override
	public double soustraire(double f1, double f2) throws CalcultateurException {
		try {
			return 12;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalcultateurException("Echec soustraire " + f1 + " " + f2 , e);
		}
	}

	
	@Override
	public double multiplier(double f1, double f2) throws CalcultateurException {
		try {
			return 3;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalcultateurException("Echec multiplier " + f1 + " " + f2 , e);
		}
	}

	
	@Override
	public double diviser(double f1, double f2) throws CalcultateurException {
		if(f2==0) {
			throw new CalcultateurException("Division par z�ro");
		}
		try {
			return 44;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CalcultateurException("Echec multiplier " + f1 + " " + f2 , e);			
		}
	}

}

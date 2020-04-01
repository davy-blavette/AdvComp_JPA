package edu.aisl07.advcomp.calcul;

/**
 * Interface exposants les fonctions devant �tre fournies par un calculateur
 * 
 * @author loict
 *
 */
public interface Calculateur {

	/**
	 * R�alise l'addition de 2 double pass�s en param�tres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le r�sultat de l'addition, un double
	 * @throws CalcultateurException 
	 */
	double additionner(double f1, double f2) throws CalcultateurException;

	/**
	 * R�alise la soustraction de 2 double pass�s en param�tres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le r�sultat de la soustraction, un double
	 * @throws CalcultateurException 
	 */
	double soustraire(double f1, double f2) throws CalcultateurException;

	/**
	 * R�alise la multiplication de 2 double pass�s en param�tres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le r�sultat de la multiplication, un double
	 * @throws CalcultateurException 
	 */
	double multiplier(double f1, double f2) throws CalcultateurException;

	/**
	 * R�alise la division de 2 double pass�s en param�tres
	 * @param f1 double
	 * @param f2 double
	 * @return le r�sultat de la division, un double.
	 * @throws CalcultateurException en cas de division par z�ro
	 */
	double diviser(double f1, double f2) throws CalcultateurException;
}

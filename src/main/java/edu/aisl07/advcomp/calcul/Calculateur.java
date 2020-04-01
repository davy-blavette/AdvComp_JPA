package edu.aisl07.advcomp.calcul;

/**
 * Interface exposants les fonctions devant être fournies par un calculateur
 * 
 * @author loict
 *
 */
public interface Calculateur {

	/**
	 * Réalise l'addition de 2 double passés en paramètres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le résultat de l'addition, un double
	 * @throws CalcultateurException 
	 */
	double additionner(double f1, double f2) throws CalcultateurException;

	/**
	 * Réalise la soustraction de 2 double passés en paramètres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le résultat de la soustraction, un double
	 * @throws CalcultateurException 
	 */
	double soustraire(double f1, double f2) throws CalcultateurException;

	/**
	 * Réalise la multiplication de 2 double passés en paramètres
	 * 
	 * @param f1 double
	 * @param f2 double
	 * @return le résultat de la multiplication, un double
	 * @throws CalcultateurException 
	 */
	double multiplier(double f1, double f2) throws CalcultateurException;

	/**
	 * Réalise la division de 2 double passés en paramètres
	 * @param f1 double
	 * @param f2 double
	 * @return le résultat de la division, un double.
	 * @throws CalcultateurException en cas de division par zéro
	 */
	double diviser(double f1, double f2) throws CalcultateurException;
}

/**
 * 
 */
package edu.aisl07.advcomp.facturation.dao;

import java.util.Date;
import java.util.List;

import edu.aisl07.advcomp.facturation.entity.HistoriqueOperation;
import edu.aisl07.advcomp.fmk.AdvCompDao;


/**
 * @author Musa
 *
 */
public interface HistoriqueOperationDao extends AdvCompDao<HistoriqueOperation, Long> {

	/**
	 * 
	 * @param debut
	 * @param fin
	 * @return
	 */
	List<HistoriqueOperation> getHistoriquePeriode(Date debut, Date fin);
}

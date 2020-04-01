package projet.advcomp.facturation;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import projet.advcomp.facturation.Facturation;

@Stateless
public class FacturationDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;

    // Stores a new facture:
    public void persist(Facturation facturation) {
        em.persist(facturation);
    }

    // Retrieves all factures:
    public List<Facturation> getAllFactures() {
        TypedQuery<Facturation> query = em.createQuery(
            "SELECT g FROM Facturation g ORDER BY g.id", Facturation.class);
        return query.getResultList();
    }
}

package db.DataAccesObjetcs;

import db.Band.Musician;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Patrik Procházka
 */
@Repository
@Transactional
public class MusicianDAOImpl implements MusicianDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Musician getMusicianById(Long id) {
        return entityManager.createQuery(
                "select Musician " +
                   "from Musician Musician " +
                   "where Musician.id = :id",  Musician.class
                ).setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Musician> getMusicianByName(String name) {
        return entityManager
                .createQuery(
                        "from Musician Musician " +
                           "where Musician.name = :name", Musician.class)
                .setParameter("name", name)
                .getResultList();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Musician> getMusicianByCountry(String country) {
        return entityManager
                .createQuery(
                        "from Musician Musician " +
                           "where Musician.country = :country", Musician.class)
                .setParameter("country", country)
                .getResultList();
    }

    @Override
    public void createNewMusician(Musician musician) {
        entityManager.persist(musician);
    }

    @Override
    public void deleteMusician(Musician musician) {
        entityManager.remove(musician);
    }

    @Override
    public Musician updateMusician(Musician musician) {
        return entityManager.merge(musician);
    }

    @Override
    public List<Musician> getAllMusicians() {
        return entityManager
                .createQuery(
                        "from Musician", Musician.class)
                .getResultList();
    }
}

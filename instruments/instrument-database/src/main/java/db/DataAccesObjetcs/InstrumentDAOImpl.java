package db.DataAccesObjetcs;


import db.Instruments.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Patrik Procházka
 */
@Repository
public class InstrumentDAOImpl implements InstrumentDAO {

    final static Logger log = LoggerFactory.getLogger(InstrumentDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Instrument getInstrumentById(Long id) {
        try {
            log.info("Retrieving Instrument by primary key Id");
            return entityManager
                    .createQuery(
                            "Select instrument " +
                                    "from Instrument instrument " +
                                    "where instrument.id = :id", Instrument.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException nre){
            log.error("System failed why performing getInstrumentById", nre);
            return null;
        }

    }

    @Override
    public List<Instrument> getInstrumentByName(String name) {
        log.info("Retrieving Instrument by Name");
        try {
        return entityManager
                .createQuery(
                                "from Instrument instrument " +
                                "where instrument.name = :name", Instrument.class)
                .setParameter("name", name)
                .getResultList();
        }catch (NoResultException nre){
            log.error("System failed why performing getInstrumentByName", nre);
            return null;
        }
    }

    @Override
    public List<Instrument> getInstrumentByCountry(String country) {
        log.info("Retrieving Instrument by country");
        try {
            return entityManager
                    .createQuery(
                            "from Instrument instrument " +
                                    "where instrument.country = :country", Instrument.class)
                    .setParameter("country", country)
                    .getResultList();
        }catch (NoResultException nre){
            log.error("System failed why performing getInstrumentByCountry", nre);
            return null;
        }
    }

    @Override
    public void createNewInstrument(Instrument instrument) {
        log.info("Creating new instrument:" + instrument.toString());
        entityManager.persist(instrument);
    }

    @Override
    public void deleteInstrument(Instrument instrument) {
        log.info("Deleting instrument");
        entityManager.remove(instrument);
    }

    @Override
    public void updateInstrument(Instrument instrument) {
        log.info("Updating instrument");
        entityManager.merge(instrument);
    }
}

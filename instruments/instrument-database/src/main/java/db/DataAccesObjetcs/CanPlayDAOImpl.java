package db.DataAccesObjetcs;

import db.Band.Musician;
import db.Instruments.CanPlay;
import db.Instruments.Instrument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Patrik Procházka
 */
@Repository
public class CanPlayDAOImpl implements CanPlayDAO {

    final static Logger log = LoggerFactory.getLogger(InstrumentDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createNewPlays(CanPlay canPlay) {
        log.info("Creating new instance of plays");
        entityManager.persist(canPlay);
    }

    @Override
    public void deletePlays(CanPlay canPlay) {
        entityManager.remove(canPlay);
    }

    @Override
    public CanPlay getPlaysById(Long id) {
        try {
            log.info("Retrieving CanPlay by primary key ID");
            return entityManager
                    .createQuery(
                            "Select plays " +
                                    "from CanPlay plays " +
                                    "where plays.id = :id", CanPlay.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch (NoResultException nre){
            log.error("System failed why performing getPlaysById", nre);
            return null;
        }
    }

    @Override
    public List<CanPlay> getPlaysByPerson(Musician musician) {
        List<CanPlay> output = new ArrayList<>();
        try {
            if(musician == null){
                log.error("@param instrument is null", new NoResultException());
                throw new NullPointerException();
            }
            log.info("Retrieving CanPlay by musician");
            return entityManager
                    .createQuery(
                            "Select plays " +
                                    "from CanPlay plays " +
                                    "where plays.player = :person", CanPlay.class)
                    .setParameter("person", musician)
                    .getResultList();
        }catch (Exception exp){
            log.error("System failed why performing getPlaysByPerson", exp);
        }
        return output;
    }

    @Override
    public List<CanPlay> getPlaysByInstrument(Instrument instrument) {
        List<CanPlay> output = new ArrayList<>();
        try {
            if(instrument == null){
                log.error("@param instrument is null", new NoResultException());
                throw new NullPointerException();
            }
            log.info("Retrieving CanPlay by Instrument");
            output = entityManager
                    .createQuery(
                            "Select plays " +
                                    "from CanPlay plays " +
                                    "where plays.instrument = :instrument", CanPlay.class)
                    .setParameter("instrument", instrument)
                    .getResultList();
        }catch (Exception exp){
            log.error("System failed why performing getPlaysByInstrument", exp);
        }
        return output;
    }


}

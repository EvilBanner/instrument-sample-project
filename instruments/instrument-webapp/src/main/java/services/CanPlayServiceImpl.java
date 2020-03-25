package services;

import db.Band.Musician;
import db.DataAccesObjetcs.CanPlayDAO;
import db.Instruments.CanPlay;
import db.Instruments.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrik Procházka
 */
@Service
public class CanPlayServiceImpl implements CanPlayService {

    @Autowired
    private CanPlayDAO canPlayDAO;

    @Override
    public void create(CanPlay canPlay) {
        canPlayDAO.createNewPlays(canPlay);
    }

    @Override
    public void delete(CanPlay canPlay) {
        canPlayDAO.deletePlays(canPlay);
    }

    @Override
    public CanPlay getById(Long id) {
        return canPlayDAO.getPlaysById(id);
    }

    @Override
    public List<CanPlay> getPlaysByPerson(Musician musician) {
        return canPlayDAO.getPlaysByPerson(musician);
    }

    @Override
    public List<CanPlay> getPlaysByInstrument(Instrument instrument) {
        return canPlayDAO.getPlaysByInstrument(instrument);
    }
}

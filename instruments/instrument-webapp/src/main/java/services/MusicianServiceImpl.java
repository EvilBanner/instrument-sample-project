package services;

import db.Band.Musician;
import db.DataAccesObjetcs.MusicianDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Patrik Procházka
 */

@Service
@Transactional
public class MusicianServiceImpl implements MusicianService {

    @Autowired
    private MusicianDAO musicianDAO;

    @Override
    public Musician findById(Long id) {
        return musicianDAO.getMusicianById(id);
    }

    @Override
    public List<Musician> findByName(String MusicianName) {
        return musicianDAO.getMusicianByName(MusicianName);
    }

    @Override
    public List<Musician> findByCountry(String countryName) {
        return musicianDAO.getMusicianByCountry(countryName);
    }

    @Override
    public void create(Musician musician) {
        musicianDAO.createNewMusician(musician);
    }

    @Override
    public void delete(Musician musician) {
        musicianDAO.deleteMusician(musician);
    }

    @Override
    public List<Musician> getAll() {
        return musicianDAO.getAllMusicians();
    }

    @Override
    public void update(Musician musician) {
        musicianDAO.updateMusician(musician);
    }
}

package services;

import db.Band.Musician;
import db.Instruments.CanPlay;
import db.Instruments.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrik Procházka
 */

@Service
public interface CanPlayService {

    void create(CanPlay canPlay);

    void delete(CanPlay canPlay);

    CanPlay getById(Long id);

    List<CanPlay> getPlaysByPerson(Musician musician);

    List<CanPlay> getPlaysByInstrument(Instrument instrument);
}

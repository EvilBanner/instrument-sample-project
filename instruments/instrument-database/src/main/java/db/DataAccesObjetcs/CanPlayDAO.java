package db.DataAccesObjetcs;

import db.Band.Musician;
import db.Instruments.CanPlay;
import db.Instruments.Instrument;

import java.util.List;

/**
 * Datta Acces Object interface for entity CanPlay -> see CanPlay for more info
 * about entity
 * @author Patrik Procházka
 */
public interface CanPlayDAO {

    void createNewPlays(CanPlay canPlay);

    void deletePlays(CanPlay canPlay);

    CanPlay getPlaysById(Long id);

    List<CanPlay> getPlaysByPerson(Musician musician);

    List<CanPlay> getPlaysByInstrument(Instrument instrument);
}

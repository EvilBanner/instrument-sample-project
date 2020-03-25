package db.DataAccesObjetcs;

import db.Instruments.Instrument;

import java.util.List;

/**
 * Datta Acces Object interface for entity Instrument -> see Instrument for more info
 * about entity
 * Provides basic CRUD
 * @author Patrik Procházka
 */
public interface InstrumentDAO {

    Instrument getInstrumentById(Long id);

    List<Instrument> getInstrumentByName(String name);

    List<Instrument> getInstrumentByCountry(String country);

    void createNewInstrument(Instrument instrument);

    void deleteInstrument(Instrument instrument);

    void updateInstrument(Instrument instrument);
}

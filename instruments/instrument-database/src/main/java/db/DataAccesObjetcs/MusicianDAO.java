package db.DataAccesObjetcs;

import db.Band.Musician;

import java.util.List;

/**
 * Datta Acces Object interface for entity Instrument -> see Instrument for more info
 * about entity
 * Provides basic CRUD
 * @author Patrik Procházka
 */
public interface MusicianDAO {

    Musician getMusicianById(Long id);

   List<Musician> getMusicianByName(String name);

    List<Musician> getMusicianByCountry(String country);

    void createNewMusician(Musician musician);

    void deleteMusician(Musician musician);

    Musician updateMusician(Musician musician);

    List<Musician> getAllMusicians();


}

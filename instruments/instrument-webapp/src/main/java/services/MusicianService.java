package services;

import db.Band.Musician;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrik Procházka
 */

@Service
public interface MusicianService {

    Musician findById(Long id);

    void create(Musician musician);

    void delete(Musician musician);

    List<Musician> findByName(String personName);

    List<Musician> findByCountry(String countryName);

    void update(Musician musician);

    List<Musician> getAll();
}

package services;


import db.Instruments.Instrument;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InstrumentService {
    
    Instrument findById(Long id);

    void create(Instrument instrument);

    void delete(Instrument instrument);

    List<Instrument> findByName(String instrumentName);

    List<Instrument> findByCountry(String countryName);

    void update(Instrument instrument);

    List<Instrument> findAll();
}

package services;

import db.DataAccesObjetcs.InstrumentDAO;
import db.Instruments.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Patrik Procházka
 */
@Service
public class InstrumentServiceImpl implements InstrumentService{

    @Autowired
    private InstrumentDAO instrumentDAO;

    @Override
    public Instrument findById(Long id) {
        return instrumentDAO.getInstrumentById(id);
    }

    @Override
    public void create(Instrument instrument) {
        instrumentDAO.createNewInstrument(instrument);
    }

    @Override
    public void delete(Instrument instrument) {
        instrumentDAO.deleteInstrument(instrument);
    }

    @Override
    public List<Instrument> findByName(String instrumentName) {
        return instrumentDAO.getInstrumentByName(instrumentName);
    }

    @Override
    public List<Instrument> findByCountry(String countryName) {
        return instrumentDAO.getInstrumentByCountry(countryName);
    }

    @Override
    public void update(Instrument instrument) {
        instrumentDAO.updateInstrument(instrument);
    }

    @Override
    public List<Instrument> findAll() {
        return instrumentDAO.getAllInstruments();
    }
}

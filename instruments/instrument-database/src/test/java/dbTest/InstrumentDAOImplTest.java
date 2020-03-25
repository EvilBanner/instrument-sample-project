package dbTest;

import db.DataAccesObjetcs.InstrumentDAO;

import db.Instruments.Instrument;
import db.dbUtils.SessionContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Patrik Procházka
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SessionContext.class)
@ContextConfiguration(classes = SessionContext.class)
@Transactional
public class InstrumentDAOImplTest {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private InstrumentDAO instrumentDAO;


    private Instrument guitar;
    private Instrument violin;
    private Instrument drums;

    @Before
    public void setUp(){
        guitar = new Instrument("guitar", "USA");
        violin = new Instrument("violin", "Canada");
        drums = new Instrument("drums", "USA");
        instrumentDAO.createNewInstrument(guitar);
        instrumentDAO.createNewInstrument(violin);
        instrumentDAO.createNewInstrument(drums);
    }

    @Test
    public void getInstrumentByIdTest(){
        Instrument found = instrumentDAO.getInstrumentById(guitar.getId());
        Instrument foundSecond = instrumentDAO.getInstrumentById(violin.getId());

        Assert.assertEquals(found.getName(),guitar.getName());
        Assert.assertEquals(found.getCountry(),guitar.getCountry());
        Assert.assertEquals(foundSecond.getName(),violin.getName());
        Assert.assertEquals(foundSecond.getCountry(),violin.getCountry());
    }

    @Test
    public void getInstrumentByName(){
        List<Instrument> found = instrumentDAO.getInstrumentByName(guitar.getName());
        List<Instrument> foundSecond = instrumentDAO.getInstrumentByName(violin.getName());
        Assert.assertEquals(found.size(), 1);
        Assert.assertEquals(found.get(0), guitar);
        Assert.assertEquals(foundSecond.size(), 1);
        Assert.assertEquals(foundSecond.get(0), violin);
    }

    @Test
    public void getInstrumentByCountry(){
        List<Instrument> found = instrumentDAO.getInstrumentByCountry(guitar.getCountry());
        List<Instrument> foundSecond = instrumentDAO.getInstrumentByCountry(violin.getCountry());
        Assert.assertEquals(found.size(), 2);
        Assert.assertEquals(found.get(0), guitar);
        Assert.assertEquals(found.get(1), drums);
        Assert.assertEquals(foundSecond.size(), 1);
        Assert.assertEquals(foundSecond.get(0), violin);
    }
    @Test
    public void testDelete(){
        instrumentDAO.deleteInstrument(guitar);try {
            Assert.assertNull(instrumentDAO.getInstrumentById(guitar.getId()));
        }catch (NoResultException ignored){
        }

    }

    public void testUpdate(){
        Instrument tmpdrums = drums;
        tmpdrums.setCountry("France");
        instrumentDAO.updateInstrument(tmpdrums);
        Instrument found = instrumentDAO.getInstrumentById(drums.getId());
        Instrument foundSecond = instrumentDAO.getInstrumentById(drums.getId());
        Assert.assertEquals(found.getName(),tmpdrums.getName());
        Assert.assertEquals(found.getCountry(),tmpdrums.getCountry());
        Assert.assertNotEquals(found.getCountry(),drums.getCountry());

    }
}

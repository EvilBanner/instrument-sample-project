package dbTest;

import db.Band.Musician;
import db.DataAccesObjetcs.MusicianDAO;
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
public class MusicianDAOImplTest {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private MusicianDAO musicianDAO;


    private Musician johnny;
    private Musician jack;
    private Musician jimmy;

    @Before
    public void setUp(){
        johnny = new Musician("johnny", "USA");
        jack = new Musician("jack", "Canada");
        jimmy = new Musician("jimmy", "USA");
        musicianDAO.createNewMusician(johnny);
        musicianDAO.createNewMusician(jack);
        musicianDAO.createNewMusician(jimmy);
    }

    @Test
    public void getMusicianByIdTest(){
        Musician found = musicianDAO.getMusicianById(johnny.getId());
        Musician foundSecond = musicianDAO.getMusicianById(jack.getId());

        Assert.assertEquals(found.getName(),johnny.getName());
        Assert.assertEquals(found.getCountry(),johnny.getCountry());
        Assert.assertEquals(foundSecond.getName(),jack.getName());
        Assert.assertEquals(foundSecond.getCountry(),jack.getCountry());
    }

    @Test
    public void getMusicianByName(){
        List<Musician> found = musicianDAO.getMusicianByName(johnny.getName());
        List<Musician> foundSecond = musicianDAO.getMusicianByName(jack.getName());
        Assert.assertEquals(found.size(), 1);
        Assert.assertEquals(found.get(0), johnny);
        Assert.assertEquals(foundSecond.size(), 1);
        Assert.assertEquals(foundSecond.get(0), jack);
    }

    @Test
    public void getMusicianByCountry(){
        List<Musician> found = musicianDAO.getMusicianByCountry(johnny.getCountry());
        List<Musician> foundSecond = musicianDAO.getMusicianByCountry(jack.getCountry());
        Assert.assertEquals(found.size(), 2);
        Assert.assertEquals(found.get(0), johnny);
        Assert.assertEquals(found.get(1), jimmy);
        Assert.assertEquals(foundSecond.size(), 1);
        Assert.assertEquals(foundSecond.get(0), jack);
    }
    @Test
    public void testDelete(){
        musicianDAO.deleteMusician(johnny);
        try {
            Assert.assertNull(musicianDAO.getMusicianById(johnny.getId()));
        }catch (NoResultException ignored){

        }
    }
    @Test
    public void testUpdate(){
        Musician tmpJimmy = new Musician(jimmy);
        tmpJimmy.setName("jimmyNeutron");
        tmpJimmy.setCountry("France");
        musicianDAO.updateMusician(tmpJimmy);
        Musician found = musicianDAO.getMusicianById(jimmy.getId());
        Assert.assertEquals("jimmyNeutron",found.getName());
        Assert.assertEquals("France",found.getCountry());
    }
}

package controllers;

import db.Instruments.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import services.InstrumentService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Patrik Procházka
 */

@Controller
@RequestMapping("/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public String getAll(Model model){
        List<Instrument> allInstruments = instrumentService.findAll();
        model.addAttribute("allInstruments", allInstruments);
        return "/instrument/list";
    }

}

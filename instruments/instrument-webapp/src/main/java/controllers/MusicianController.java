package controllers;

import db.Band.Musician;
import db.DataAccesObjetcs.InstrumentDAOImpl;
import forms.MusicianValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import services.MusicianService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Patrik Procházka
 */


@Controller
public class MusicianController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MusicianService musicianService;


    final static Logger log = LoggerFactory.getLogger(MusicianController.class);

    @RequestMapping(value = "/musician/list", method = RequestMethod.GET)
    public String getAll(Model model){
        List<Musician> musicians= musicianService.getAll();
        model.addAttribute("musicians", musicians);
        return "/musician/list";
    }

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping(path = "/musician/delete/{id}", method = RequestMethod.GET )
    @Transactional
        public String delete(@PathVariable Long id){
            musicianService.delete(musicianService.findById(id));
            return "redirect:/musician/list";
    }


    @RequestMapping(value = "/musician/new", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        model.addAttribute("musicianForm", new Musician());
        return "/musician/new";
    }

    @RequestMapping( path = "/musician/create", method = RequestMethod.POST)
    @Transactional
    public String createPerson(@Validated @ModelAttribute("musicianForm") Musician musician,
                               BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "musician/new";
        }
        musicianService.create(musician);
        return "redirect:/musician/list";
    }


    @RequestMapping(path = "/musician/edit/{id}")
    @Transactional
    public String showEditForm(@PathVariable Long id, Model model){
        Musician editedMusician = musicianService.findById(id);
        model.addAttribute("musicianEditedForm", editedMusician );
        log.debug(editedMusician .toString());
        return "/musician/edit";
    }


    /**
     * This part is done wrong in favor of working, need to update later
     * @param musician
     * @param bindingResult
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(path = "/musician/{id}/save", method = RequestMethod.POST)
    @Transactional
    public String edit(@Validated @ModelAttribute("musicianEditedForm") Musician musician, BindingResult bindingResult,
                       Model model, @PathVariable Long id){
        if (bindingResult.hasErrors()) {
            for (FieldError fe : bindingResult.getFieldErrors()) {
                model.addAttribute(fe.getField() + "_error", true);
            }
            return "/musician/edit";
        }
        log.debug(musician.toString());
        Musician updatedMusician = musicianService.findById(id);
        updatedMusician.setName(musician.getName());
        updatedMusician.setCountry(musician.getCountry());
        musicianService.update(updatedMusician);
        return "redirect:/musician/list";
    }

    @RequestMapping(path = "/musician/search/{name}", method = RequestMethod.GET)
    public String searchByName(@PathVariable String name, Model model){
        List<Musician> musicians = musicianService.findByName(name);
        model.addAttribute("musicians", musicians);
        return "/musician/list";
    }
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new MusicianValidator());
    }
}

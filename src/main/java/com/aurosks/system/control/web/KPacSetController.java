package com.aurosks.system.control.web;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.domain.KPacSetSaveRequest;
import com.aurosks.system.control.service.KPacService;
import com.aurosks.system.control.service.KPacSetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class KPacSetController {
    @Autowired
    private KPacSetService kPacSetService;
    @Autowired
    private KPacService kPacService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(value = "/sets", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView model) throws JsonProcessingException {
        List<KPacSet> kPacSetList = this.kPacSetService.getAll();
        model.addObject("kPacSetList", this.objectMapper.writeValueAsString(kPacSetList));

        // used for kpacset creation form
        List<KPac> kPacList = this.kPacService.getAll();
        model.addObject("kPacList", this.objectMapper.writeValueAsString(kPacList));

        model.setViewName("kPacSets");
        return model;
    }

    @RequestMapping(value="/sets/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + "sets");
        this.kPacSetService.deleteById(id);
        return modelAndView;
    }

    @RequestMapping(value = "/sets/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute KPacSetSaveRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + "sets");
        this.kPacSetService.save(request);
        return modelAndView;
    }

    @GetMapping("/set/{id}")
    public ModelAndView getById(@PathVariable("id") int id) throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("kPacSet");
        KPacSet kPacSet = kPacSetService.getById(id);
        modelAndView.addObject("kPacSet", this.objectMapper.writeValueAsString(kPacSet));

        return modelAndView;
    }
}

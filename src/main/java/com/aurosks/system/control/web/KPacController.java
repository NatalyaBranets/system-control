package com.aurosks.system.control.web;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;
import com.aurosks.system.control.service.KPacService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value = "/kpacs")
public class KPacController {

    @Autowired
    private KPacService kPacService;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView model) throws JsonProcessingException {
        List<KPac> kPacsList = this.kPacService.getAll();
        model.addObject("kPacsList", this.objectMapper.writeValueAsString(kPacsList));
        model.setViewName("kPacs");
        return model;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + "kpacs");
        this.kPacService.deleteById(id);
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@ModelAttribute KPacSaveRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + "kpacs");
        this.kPacService.save(request);
        return modelAndView;
    }
}

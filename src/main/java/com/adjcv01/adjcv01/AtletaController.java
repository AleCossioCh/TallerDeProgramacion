package com.adjcv01.adjcv01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class AtletaController {
    @Autowired
    private AtletaRepository atletaRepository;

    @RequestMapping(value="listarAtletas", method = RequestMethod.GET)
    public String atletas(Model modelo){
        Iterable<Atleta> atletas = atletaRepository.findAll();
        modelo.addAttribute("listarAtleta", atletas);
        return ("atletas");
    }

    @RequestMapping(value="/atleta/new", method = RequestMethod.GET)
    public String newAtleta(Model modelo){
        return "newAtleta";
    }

    @RequestMapping(value="atletas", method = RequestMethod.POST)
    public String create(@ModelAttribute("atletas") Atleta a, Model modelo){
        atletaRepository.save(a);
        return "redirect:/listarAtletas";
    }

    @RequestMapping(value="/atletash/{idAtleta}", method = RequestMethod.GET) //este es elDetalle
    public String atletash(@PathVariable Integer idAtleta, Model modelo){
        Optional<Atleta> captura = atletaRepository.findById(idAtleta);
        Atleta a = captura.get();
        modelo.addAttribute("atle",a);
        return "detalleatleta";
    }

    @RequestMapping(value="elimAtle/{idAtleta}")
    public String elimMun(@PathVariable Integer idAtleta,Model modelo){
        atletaRepository.deleteById(idAtleta);
        return "redirect:/listarAtletas";
    }

    @RequestMapping(value = "/editatleta/{idAtleta}")
    public String editatleta(@PathVariable Integer idAtleta, Model model){
        Optional<Atleta> edito = atletaRepository.findById(idAtleta);
        Atleta a = edito.get();
        model.addAttribute("atle",a);
        return "editatleta";
    }

    @RequestMapping(value = "atletaActualizar", method = RequestMethod.POST)
    public String atletaActualizar(@ModelAttribute ("atleta") Atleta a, Model model){
        Optional<Atleta> editoagain = atletaRepository.findById(a.getIdAtleta());
        Atleta nuevo = editoagain.get();
        nuevo.setIdAtleta(a.getIdAtleta());
        nuevo.setNombreAtleta(a.getNombreAtleta());
        nuevo.setCategoria(a.getCategoria());
        nuevo.setApellidoAtleta(a.getApellidoAtleta());
        nuevo.setEdadAtleta(a.getEdadAtleta());
        nuevo.setClub(a.getClub());
        atletaRepository.save(nuevo);
        return "redirect:/listarAtletas";
    }
}

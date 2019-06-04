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

    @RequestMapping(value="/listaratletas", method = RequestMethod.GET)
    public String atletas(Model modelo){
        Iterable<Atleta> atletas = atletaRepository.findAll();
        modelo.addAttribute("listaratletas", atletas);
        return("atletas");
    }

    @RequestMapping(value="/atleta/new", method = RequestMethod.GET)
    public String newAtleta(Model modelo){
        return "newAtleta";
    }

    @RequestMapping(value="atletas", method = RequestMethod.POST)
    public String createAtleta(@ModelAttribute("atletas") Atleta a, Model modelo){
        atletaRepository.save(a);
        return "redirect:/listaratletas";
    }

    @RequestMapping(value="/detalleatleta/{idAtleta}", method = RequestMethod.GET) //este es elDetalle
    public String detalleatleta(@PathVariable Integer idAtleta, Model modelo){
        Optional<Atleta> captura = atletaRepository.findById(idAtleta);
        //va a trabajar con MunicipioRepository
        Atleta a = captura.get();
        modelo.addAttribute("atleta",a);//El modelo le va a enviar como mun, el m municipio
        return "detalleatleta";//Se va a mostrar en esta pagina
    }

    @RequestMapping(value="elimAtleta/{idAtleta}")
    public String elimAtleta(@PathVariable Integer idAtleta,Model modelo){
        atletaRepository.deleteById(idAtleta);
        return "redirect:/listaratletas";
    }

    @RequestMapping(value = "/editAtleta/{idAtleta}")
    public String editAtleta(@PathVariable Integer idAtleta, Model model){
        Optional<Atleta> edito = atletaRepository.findById(idAtleta);
        Atleta a = edito.get();
        model.addAttribute("atleta",a);
        return "editAtleta";
    }

    @RequestMapping(value = "atletaActualizar", method = RequestMethod.POST)
    public String atletaActualizar(@ModelAttribute ("atleta") Atleta a, Model model){
        Optional<Atleta> editoagain = atletaRepository.findById(a.getIdAtleta());
        Atleta nuevo = editoagain.get();
        nuevo.setIdAtleta(a.getIdAtleta());
        nuevo.setNombreAtleta(a.getNombreAtleta());
        nuevo.setApellidoAtleta(a.getApellidoAtleta());
        nuevo.setEdadAtleta(a.getEdadAtleta());
        nuevo.setCategoria(a.getCategoria());
        atletaRepository.save(nuevo);
        return "redirect:/listaratletas";
    }

}
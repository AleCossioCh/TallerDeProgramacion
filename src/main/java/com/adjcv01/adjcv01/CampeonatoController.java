package com.adjcv01.adjcv01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @Autowired
    private AtletaRepository atletaRepository;

    @GetMapping
    public String inicioCampeonato(Model modelo) {
        modelo.addAttribute("campeonato", new Campeonato());
        modelo.addAttribute("campeonatos", campeonatoRepository.findAll());
        modelo.addAttribute("atletas", atletaRepository.findAll());
        return "inicioCampeonato";
    }

    @PostMapping
    public String crearCampeonato(Model modelo, Campeonato campeonato) {
        campeonatoRepository.save(campeonato);

        modelo.addAttribute("campeonato",new Campeonato());
        modelo.addAttribute("campeonatos",campeonatoRepository.findAll());
        modelo.addAttribute("atletas",atletaRepository.findAll());
        Iterable<Atleta> listaratletasadulto = atletaRepository.findByCategoryAdulto();
        modelo.addAttribute("listaratletasadulto", listaratletasadulto);
        modelo.addAttribute("atletasInfantil", atletaRepository.findByCategoryInfantil());
        modelo.addAttribute("atletasProfesional", atletaRepository.findByCategoryProfecional());
        return "inicioCampeonato";
    }

    @GetMapping("/editarCampeonato/{idCampeonato}")
    public String editarCampeonatoForm(Model modelo, @PathVariable(name="idCampeonato") Integer idCampeonato) {
        Campeonato campeonatoParaEditar = campeonatoRepository.findById(idCampeonato).get();
        modelo.addAttribute("campeonato",campeonatoParaEditar);
        modelo.addAttribute("campeonatos",campeonatoRepository.findAll());//SELECT * FROM USUARIOS;
        modelo.addAttribute("atletas",atletaRepository.findAll());
        return "inicioCampeonato";
    }

    @GetMapping("/eliminarCampeonato/{idCampeonato}")
    public String eliminarCampeonato(Model modelo, @PathVariable(name="idCampeonato") Integer idCampeonato) {
        Campeonato campeonatoParaEliminar = campeonatoRepository.findById(idCampeonato).get();
        campeonatoRepository.delete(campeonatoParaEliminar);
        modelo.addAttribute("campeonato",new Campeonato());
        modelo.addAttribute("campeonatos",campeonatoRepository.findAll());//SELECT * FROM USUARIOS;
        modelo.addAttribute("atletas",atletaRepository.findAll());
        return "inicioCampeonato";
    }



}

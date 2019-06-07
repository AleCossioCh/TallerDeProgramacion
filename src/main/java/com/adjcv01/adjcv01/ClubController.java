package com.adjcv01.adjcv01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;
@Controller
public class ClubController {
        @Autowired
        private ClubRepository clubRepository;
        @Autowired
        private MunicipioRepository municipioRepository;

        @RequestMapping(value="/listarclubs", method = RequestMethod.GET)
        public String clubs(Model modelo){
            Iterable<Club> clubs = clubRepository.findAll();
            modelo.addAttribute("listarclubs", clubs);

            return("clubs");
        }

        @RequestMapping(value="/club/new", method = RequestMethod.GET)
        public String newClub(Model modelo){

            List<Municipio> municipios  = (List) municipioRepository.findAll();

            modelo.addAttribute("club", new Club());
            modelo.addAttribute("municipios", municipios);

            return "newClub";
        }

        @RequestMapping(value="clubs", method = RequestMethod.POST)
        public String createClub(@ModelAttribute("clubs") Club c, Model modelo){
            clubRepository.save(c);
            return "redirect:/listarclubs";
        }

        @RequestMapping(value="/detalleclub/{idClub}", method = RequestMethod.GET) //este es elDetalle
        public String detalleclub(@PathVariable Integer idClub, Model modelo){
            Optional<Club> captura = clubRepository.findById(idClub);
            //va a trabajar con MunicipioRepository
            Club c = captura.get();
            modelo.addAttribute("club",c);//El modelo le va a enviar como mun, el m municipio
            return "detalleclub";//Se va a mostrar en esta pagina
        }

        @RequestMapping(value="elimClub/{idClub}")
        public String elimClub(@PathVariable Integer idClub,Model modelo){
            clubRepository.deleteById(idClub);
            return "redirect:/listarclubs";
        }

        @RequestMapping(value = "/editClub/{idClub}")
        public String editClub(@PathVariable Integer idClub, Model model){
            Optional<Club> edito = clubRepository.findById(idClub);

            List<Municipio> municipios  = (List) municipioRepository.findAll();
            Club c = edito.get();
            model.addAttribute("municipios", municipios);
            model.addAttribute("club",c);
            return "editClub";
        }

        @RequestMapping(value = "clubActualizar", method = RequestMethod.POST)
        public String clubActualizar(@ModelAttribute ("club") Club c, Model model){
            Optional<Club> editoagain = clubRepository.findById(c.getIdClub());
            Club nuevo = editoagain.get();
            nuevo.setIdClub(c.getIdClub());
            nuevo.setNombreClub(c.getNombreClub());
            nuevo.setMunicipio(c.getMunicipio());
            clubRepository.save(nuevo);
            return "redirect:/listarclubs";
        }




}

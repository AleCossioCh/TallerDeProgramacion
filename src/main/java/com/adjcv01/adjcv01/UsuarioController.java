package com.adjcv01.adjcv01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("usuarios", usuarioRepository.findAll());
        modelo.addAttribute("roles", rolRepository.findAll());
        return "index";
    }

    @RequestMapping(value="usuarios", method = RequestMethod.POST)
    public String crearUsuario(Model modelo, Usuario usuario) {
        usuarioRepository.save(usuario);

        modelo.addAttribute("usuario",new Usuario());
        modelo.addAttribute("usuarios",usuarioRepository.findAll());
        modelo.addAttribute("roles",rolRepository.findAll());
        return "index";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuarioForm(Model modelo, @PathVariable(name="id") Long id) {
        Usuario usuarioParaEditar = usuarioRepository.findById(id).get();
        modelo.addAttribute("usuario",usuarioParaEditar);
        modelo.addAttribute("usuarios",usuarioRepository.findAll());//SELECT * FROM USUARIOS;
        modelo.addAttribute("roles",rolRepository.findAll());
        return "index";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(Model modelo, @PathVariable(name="id") Long id) {
        Usuario usuarioParaEliminar = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuarioParaEliminar);
        modelo.addAttribute("usuario",new Usuario());
        modelo.addAttribute("usuarios",usuarioRepository.findAll());//SELECT * FROM USUARIOS;
        modelo.addAttribute("roles",rolRepository.findAll());
        return "index";
    }
}

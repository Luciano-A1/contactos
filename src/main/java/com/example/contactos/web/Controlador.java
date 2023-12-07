package com.example.contactos.web;

import com.example.contactos.entidades.Contacto;
import com.example.contactos.servicio.ServicioContacto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class Controlador {

    private static final Logger logger = LoggerFactory.getLogger(Controlador.class);
    private final ServicioContacto servicioContacto;

    @Autowired
    public Controlador(ServicioContacto servicioContacto) {
        this.servicioContacto = servicioContacto;
    }

    @GetMapping("/")
    public String comienzo(Model modelo) {
        log.info("Estoy ejecutando el controlador MVC");
        List<Contacto> listarContactos = servicioContacto.listContactos();
        listarContactos.forEach(contacto -> logger.info(contacto.toString()));
        modelo.addAttribute("listarContactos", listarContactos);
        return "Indice";
    }

    @GetMapping("/agregar")
    public String mostrarAgregarContacto() {
        return "agregar";
    }
    
    @PostMapping("/agregar")
    public String agregar(Model modelo, Contacto contacto){
        logger.info("Contacto a Agregar: " + contacto);
        servicioContacto.guardarCambiar(contacto);
        modelo.addAttribute("contacto", contacto);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value = "id") long idContacto, Model modelo){
        Contacto contacto = servicioContacto.buscarPorId(idContacto);
        logger.info("Contacto a Editar: " + contacto);
        modelo.addAttribute("contacto", contacto);
        return "/editar";
    }
    
    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto){
         logger.info("Contacto a Guardar: " + contacto);
         servicioContacto.guardarCambiar(contacto);
         return "redirect:/";
    }
    
    @GetMapping("/borrar/{id}")
    public String editar(@PathVariable(value = "id") long idContacto){
        Contacto contacto = servicioContacto.buscarPorId(idContacto);
         logger.info("Contacto a borrar: " + contacto);
         servicioContacto.borrar(contacto);
         return "redirect:/";
    }

}

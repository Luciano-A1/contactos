package com.example.contactos.servicio;

import com.example.contactos.entidades.Contacto;
import java.util.List;

public interface ServicioContacto {

    public List<Contacto> listContactos();

    public void guardarCambiar(Contacto contacto);

    public void borrar(Contacto contacto);

    public Contacto buscarPorId(Long id_Contacto);
    
}

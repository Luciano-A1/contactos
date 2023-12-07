package com.example.contactos.Dao;

import com.example.contactos.entidades.Contacto;
import org.springframework.data.repository.CrudRepository;

public interface ContactoDao extends CrudRepository<Contacto, Long>{
    
}
